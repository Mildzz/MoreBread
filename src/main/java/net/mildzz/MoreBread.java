package net.mildzz;

import net.fabricmc.api.ModInitializer;

import net.mildzz.item.ModItemGroup;
import net.mildzz.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBread implements ModInitializer {
	public static final String MOD_ID = "more-bread";
	public static final Logger LOGGER = LoggerFactory.getLogger("more-bread");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModItems.addItemsToItemGroup();
	}
}