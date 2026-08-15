package net.cinchtail.cinchssandycatacombs;

import net.cinchtail.cinchssandycatacombs.config.ModConfigs;
import net.cinchtail.cinchssandycatacombs.loot.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CinchsSandyCatacombs implements ModInitializer {
	public static final String MOD_ID = "cinchssandycatacombs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfigs.load();
		ModLootTableModifiers.modifyLootTables();
	}
}

//give @s chest[container_loot={loot_table:"cinchssandycatacombs:chests/desert_catacombs_common"}]
//give @s minecraft:suspicious_gravel[block_entity_data={id:"minecraft:suspicious_sand",LootTable:"cinchssandycatacombs:archaeology/desert_catacombs"}]
//give @s decorated_pot[block_entity_data={id:"minecraft:decorated_pot",LootTable:"cinchssandycatacombs:pots/desert_catacombs_common"}]
//give @s decorated_pot[block_entity_data={id:"minecraft:decorated_pot",LootTable:"cinchssandycatacombs:pots/desert_catacombs_rare"},pot_decorations=["minecraft:brick","minecraft:brick","minecraft:brick","minecraft:brewer_pottery_sherd"]]