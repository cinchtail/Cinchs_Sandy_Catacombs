package net.cinchtail.cinchssandycatacombs.loot;

import net.cinchtail.cinchssandycatacombs.config.ModConfigs;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModLootTableModifiers {

    public static void modifyLootTables() {
        if (ModConfigs.enableHuskSandDrops || ModConfigs.configMissing) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
                if (key.equals(EntityTypes.HUSK.getDefaultLootTable().get())) {
                    LootPool poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(Items.SAND)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f)))
                                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(0.5f, 1.0f))))
                            .build();

                    tableBuilder.pool(poolBuilder);
                }
            });
        }

        if (ModConfigs.enableParchedSandDrops || ModConfigs.configMissing) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
                if (key.equals(EntityTypes.PARCHED.getDefaultLootTable().get())) {
                    LootPool poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(Items.SAND)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f)))
                                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(0.5f, 1.0f))))
                            .build();

                    tableBuilder.pool(poolBuilder);
                }
            });
        }

        if (ModConfigs.enableCamelHuskSandDrops || ModConfigs.configMissing) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
                if (key.equals(EntityTypes.CAMEL_HUSK.getDefaultLootTable().get())) {
                    LootPool poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(Items.SAND)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 8.0f)))
                                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(0.4f, 0.8f))))
                            .build();

                    tableBuilder.pool(poolBuilder);
                }
            });
        }

        if (ModConfigs.enableStraySnowBallDrops || !ModConfigs.configMissing) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
                if (key.equals(EntityTypes.STRAY.getDefaultLootTable().get())) {
                    LootPool poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(Items.SNOWBALL)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(0.4f, 0.8f))))
                            .build();

                    tableBuilder.pool(poolBuilder);
                }
            });
        }

        if (ModConfigs.enableBoggedMossBlockDrops || !ModConfigs.configMissing) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
                if (key.equals(EntityTypes.BOGGED.getDefaultLootTable().get())) {
                    LootPool poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(Items.MOSS_BLOCK)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(0.4f, 0.8f))))
                            .build();

                    tableBuilder.pool(poolBuilder);
                }
            });
        }
    }
}