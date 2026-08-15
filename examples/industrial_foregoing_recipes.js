ServerEvents.recipes(event => {
	event.recipes.industrialforegoing.crusher(
		'minecraft:gravel',
		'minecraft:cobblestone'
	)

	event.recipes.industrialforegoing.dissolution_chamber(
		['minecraft:dirt', 'minecraft:sand'],
		Fluid.of('minecraft:water', 500),
		Item.of('minecraft:diamond', 2),
		200
	).outputFluid(Fluid.of('minecraft:lava', 100))

	event.recipes.industrialforegoing.fluid_extractor(
		'minecraft:oak_log',
		'minecraft:stripped_oak_log',
		0.05,
		Fluid.of('industrialforegoing:latex', 8)
	)

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

	event.recipes.industrialforegoing.stonework_generate(
		'minecraft:obsidian',
		1000, 1000, 0, 1000
	)
})
