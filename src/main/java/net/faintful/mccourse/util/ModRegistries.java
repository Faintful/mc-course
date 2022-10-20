package net.faintful.mccourse.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.faintful.mccourse.Item.ModItems;
import net.faintful.mccourse.MCCourseMod;

public class ModRegistries {

    public static void registerFuels() {
        System.out.println("Registering fuels for MC Course" + MCCourseMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.COAL_SLIVER, 400);
    }
}
