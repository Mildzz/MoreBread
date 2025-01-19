package net.mildzz.morebread.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mildzz.morebread.MoreBread;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BUTTER = registerItem("butter", new Item(new FabricItemSettings()));
    public static final Item BLUEBERRIES = registerItem("blueberries", new Item(new FabricItemSettings().food(ModFoodComponents.BLUEBERRIES)));
    public static final Item BLUEBERRY_MUFFIN = registerItem("blueberry_muffin", new Item(new FabricItemSettings().food(ModFoodComponents.BLUEBERRY_MUFFIN)));

    public static final Item JELLY_FILLED_BUN = registerItem("jelly_filled_bun", new Item(new FabricItemSettings().food(ModFoodComponents.JELLY_FILLED_BUN)));
    public static final Item CHOCOLATE_DONUT = registerItem("chocolate_donut", new Item(new FabricItemSettings().food(ModFoodComponents.CHOCOLATE_DONUT)));
    public static final Item PANCAKES = registerItem("pancakes", new Item(new FabricItemSettings().food(ModFoodComponents.PANCAKES)));
    public static final Item CINNAMON_BUN = registerItem("cinnamon_bun", new Item(new FabricItemSettings().food(ModFoodComponents.CINNAMON_BUN)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(BUTTER);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MoreBread.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreBread.LOGGER.info("Registering mod items for " + MoreBread.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
