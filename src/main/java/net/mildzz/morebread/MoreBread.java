package net.mildzz.morebread;

import net.fabricmc.api.ModInitializer;

import net.mildzz.morebread.block.ModBlocks;
import net.mildzz.morebread.item.ModItemGroups;
import net.mildzz.morebread.item.ModItems;
import net.mildzz.morebread.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBread implements ModInitializer {
	public static final String MOD_ID = "morebread";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();
	}
}