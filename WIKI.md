# KubeJS Industrial Foregoing

Recipe schemas for Industrial Foregoing on Minecraft 1.21.1 / NeoForge.

Everything goes inside `ServerEvents.recipes(event => { ... })` in a `kubejs/server_scripts/` file.

---

## Crusher

`crusher(output, input)`

| Argument | Type | Notes |
| --- | --- | --- |
| `output` | Ingredient | Industrial Foregoing stores the result as an ingredient, not an item stack |
| `input` | Ingredient | |

```js
event.recipes.industrialforegoing.crusher(
	'minecraft:gravel',
	'minecraft:cobblestone'
)
```

---

## Dissolution Chamber

`dissolution_chamber(input, inputFluid, output, processingTime)`

| Argument | Type | Notes |
| --- | --- | --- |
| `input` | Ingredient[] | May be empty for fluid-only recipes |
| `inputFluid` | SizedFluidIngredient | Use `Fluid.of(id, amount)` |
| `output` | ItemStack | |
| `processingTime` | int | Ticks |
| `outputFluid` | FluidStack | Optional, set with the chained `.outputFluid(...)` |

```js
event.recipes.industrialforegoing.dissolution_chamber(
	['minecraft:dirt', 'minecraft:sand'],
	Fluid.of('minecraft:water', 500),
	Item.of('minecraft:diamond', 2),
	200
).outputFluid(Fluid.of('minecraft:lava', 100))
```

---

## Fluid Extractor

`fluid_extractor(input, result, breakChance, output[, defaultRecipe])`

| Argument | Type | Notes |
| --- | --- | --- |
| `input` | Ingredient | The block being tapped |
| `result` | BlockState | What is left behind; `minecraft:air` is allowed |
| `breakChance` | float | 0.0 - 1.0 |
| `output` | FluidStack | Use `Fluid.of(id, amount)` |
| `defaultRecipe` | boolean | Optional, defaults to `false`, always written to JSON |

```js
event.recipes.industrialforegoing.fluid_extractor(
	'minecraft:oak_log',
	'minecraft:stripped_oak_log',
	0.05,
	Fluid.of('industrialforegoing:latex', 8)
)
```

---

## Laser Drill (Ore)

`laser_drill_ore(output, catalyst, rarity[, entity_data])`

| Argument | Type | Notes |
| --- | --- | --- |
| `output` | SizedIngredient | Flat form: `{ item: id, count: n }` or `{ tag: id, count: n }` |
| `catalyst` | Ingredient | The laser lens |
| `rarity` | Rarity[] | See [Rarity](#rarity) |
| `entity_data` | EntityData | Optional, see [Entity data](#entity-data) |

```js
event.recipes.industrialforegoing.laser_drill_ore(
	{ item: 'minecraft:diamond', count: 1 },
	'industrialforegoing:red_laser_lens',
	[{
		biome_filter: { whitelist: [], blacklist: [] },
		dimension_filter: { whitelist: [], blacklist: ['minecraft:the_end'] },
		depth_min: 0,
		depth_max: 255,
		weight: 5
	}]
)
```

---

## Laser Drill (Fluid)

`laser_drill_fluid(output, catalyst, rarity[, entity_data])`

| Argument | Type | Notes |
| --- | --- | --- |
| `output` | SizedFluidIngredient | Use `Fluid.of(id, amount)` |
| `catalyst` | Ingredient | The laser lens |
| `rarity` | Rarity[] | See [Rarity](#rarity) |
| `entity_data` | EntityData | Optional, see [Entity data](#entity-data) |

```js
event.recipes.industrialforegoing.laser_drill_fluid(
	Fluid.of('industrialforegoing:ether_gas', 10),
	'industrialforegoing:purple_laser_lens',
	[{
		biome_filter: { whitelist: [], blacklist: [] },
		dimension_filter: { whitelist: [], blacklist: [] },
		depth_min: -64,
		depth_max: 256,
		weight: 8
	}],
	{ entity: { type: 'minecraft:wither' }, data: {}, display: '' }
)
```

---

## Stonework Generate

`stonework_generate(output, waterNeed, lavaNeed, waterConsume, lavaConsume)`

| Argument | Type | Notes |
| --- | --- | --- |
| `output` | ItemStack | |
| `waterNeed` | int | mB that must be present |
| `lavaNeed` | int | mB that must be present |
| `waterConsume` | int | mB actually drained |
| `lavaConsume` | int | mB actually drained |

```js
event.recipes.industrialforegoing.stonework_generate(
	'minecraft:obsidian',
	1000, 1000, 0, 1000
)
```

---

## Rarity

Used by both laser drill schemas. All five fields are mandatory, Industrial Foregoing's codec has no defaults.

| Field | Type | Notes |
| --- | --- | --- |
| `biome_filter` | `{ whitelist, blacklist }` | Lists of biome tag ids, e.g. `'minecraft:is_nether'` |
| `dimension_filter` | `{ whitelist, blacklist }` | Lists of dimension type ids, e.g. `'minecraft:the_end'` |
| `depth_min` | int | |
| `depth_max` | int | |
| `weight` | int | Higher means more common |

A recipe takes a list of these, so a single ore can have different weights at different depths.

## Entity data

Optional on both laser drill schemas. Replaces the plain `entity` string used on 1.20.1.

| Field | Type | Notes |
| --- | --- | --- |
| `entity` | `{ type }` or `{ tag }` | Entity type id or entity type tag |
| `data` | object | NBT, `{}` when unused |
| `display` | string | Display override, `''` when unused |

Pass it as the last constructor argument. The chained `.entity_data(...)` setter makes KubeJS drop the recipe without reporting an error.

## Removing recipes

The schemas register the same keys Industrial Foregoing uses, so filters work on any of them:

```js
event.remove({ type: 'industrialforegoing:laser_drill_ore', output: 'minecraft:diamond' })
```

## Recipe ids

Generated ids come from the output for every machine except the crusher and the fluid extractor, which use the input. Two recipes that would generate the same id overwrite each other, so pass `.id('namespace:path')` when adding several recipes that share that key.
