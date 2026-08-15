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