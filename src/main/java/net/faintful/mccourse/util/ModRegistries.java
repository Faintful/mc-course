package net.faintful.mccourse.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.faintful.mccourse.Item.ModItems;
import net.faintful.mccourse.MCCourseMod;
import net.minecraft.block.ComposterBlock;

public class ModRegistries {

    public static void registerModRegistries() {
        registerFuels();
        registerModComposterChances();
    }

    public static void registerFuels() {
        System.out.println("Registering fuels for MC Course" + MCCourseMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.COAL_SLIVER, 400);
    }

    private static void registerModComposterChances() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TURNIP_SEEDS, 0.35f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TURNIP, 0.65f);
    }

}
