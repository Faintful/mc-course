package net.faintful.mccourse;

import net.fabricmc.api.ModInitializer;
import net.faintful.mccourse.block.entity.ModBlockEntities;
import net.faintful.mccourse.config.ModConfigs;
import net.faintful.mccourse.effect.ModEffects;
import net.faintful.mccourse.item.ModItems;
import net.faintful.mccourse.block.ModBlocks;
import net.faintful.mccourse.enchantment.ModEnchantments;
import net.faintful.mccourse.painting.ModPaintings;
import net.faintful.mccourse.potion.ModPotions;
import net.faintful.mccourse.recipe.ModRecipes;
import net.faintful.mccourse.util.ModLootTableModifiers;
import net.faintful.mccourse.util.ModRegistries;
import net.faintful.mccourse.world.feature.ModConfiguredFeatures;
import net.faintful.mccourse.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {

	public static final String MOD_ID = "mccourse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModBlockEntities.registerAllEntities();

		ModEnchantments.registerModEnchantments();
		ModLootTableModifiers.modifyLootTables();

		ModRecipes.register();

		ModRegistries.registerModRegistries();

		ModPaintings.registerPaintings();

		ModWorldGen.generateModWorldGen();

		ModEffects.registerEffects();
		ModPotions.registerPotions();
	}
}
