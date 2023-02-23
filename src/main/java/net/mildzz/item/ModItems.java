package net.mildzz.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mildzz.MoreBread;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CINNAMON_BUN = registerFood("cinnamon_bun",
            new Item(new FabricItemSettings().food(ModFoodComponents.CINNAMON_BUN)));
    public static final Item PANCAKES = registerFood("pancakes",
            new Item(new FabricItemSettings().food(ModFoodComponents.PANCAKES)));
    public static final Item BLUEBERRY_MUFFIN = registerFood("blueberry_muffin",
            new Item(new FabricItemSettings().food(ModFoodComponents.BLUEBERRY_MUFFIN)));
    public static final Item JELLY_FILLED_BUN = registerFood("jelly_filled_bun",
            new Item(new FabricItemSettings().food(ModFoodComponents.JELLY_FILLED_BUN)));
    public static final Item BUTTER = registerFood("butter",
            new Item(new FabricItemSettings()));
    public static final Item BLUEBERRY = registerFood("blueberry",
            new Item(new FabricItemSettings().food(ModFoodComponents.BLUEBERRY)));

    private static Item registerFood(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MoreBread.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.BREAD, CINNAMON_BUN);
        addToItemGroup(ModItemGroup.BREAD, PANCAKES);
        addToItemGroup(ModItemGroup.BREAD, BLUEBERRY_MUFFIN);
        addToItemGroup(ModItemGroup.BREAD, JELLY_FILLED_BUN);
        addToItemGroup(ModItemGroup.BREAD, BUTTER);
        addToItemGroup(ModItemGroup.BREAD, BLUEBERRY);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        MoreBread.LOGGER.info("Registering MoreBread items...");
    }
}
