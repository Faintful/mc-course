package net.faintful.mccourse;

import net.fabricmc.api.ModInitializer;
import net.faintful.mccourse.block.entity.ModBlockEntities;
import net.faintful.mccourse.item.ModItems;
import net.faintful.mccourse.block.ModBlocks;
import net.faintful.mccourse.enchantment.ModEnchantments;
import net.faintful.mccourse.painting.ModPaintings;
import net.faintful.mccourse.util.ModLootTableModifiers;
import net.faintful.mccourse.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {

	public static final String MOD_ID = "mccourse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModRegistries();
		ModEnchantments.registerModEnchantments();
		ModLootTableModifiers.modifyLootTables();
		ModPaintings.registerPaintings();
		ModBlockEntities.registerAllEntities();
	}
}
