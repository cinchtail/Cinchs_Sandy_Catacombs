package net.cinchtail.fullyfarmablesand;

import net.cinchtail.fullyfarmablesand.config.ModConfigs;
import net.cinchtail.fullyfarmablesand.loot.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FullyFarmableSand implements ModInitializer {
	public static final String MOD_ID = "fullyfarmablesand";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfigs.load();
		ModLootTableModifiers.modifyLootTables();
	}
}