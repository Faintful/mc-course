package net.faintful.mccourse.util;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.faintful.mccourse.block.ModBlocks;
import net.faintful.mccourse.item.ModItems;
import net.faintful.mccourse.MCCourseMod;
import net.faintful.mccourse.command.ReturnHomeCommand;
import net.faintful.mccourse.command.SetHomeCommand;
import net.faintful.mccourse.event.ModPlayerEventCopyFrom;
import net.minecraft.block.ComposterBlock;

public class ModRegistries {

    public static void registerModRegistries() {
        registerFuels();
        registerModComposterChances();
        registerCommands();
        registerEvents();
        registerStrippables();
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

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.CHERRY_BLOSSOM_LOG, ModBlocks.STRIPPED_CHERRY_BLOSSOM_LOG);
        StrippableBlockRegistry.register(ModBlocks.CHERRY_BLOSSOM_WOOD, ModBlocks.STRIPPED_CHERRY_BLOSSOM_WOOD);
    }

}
