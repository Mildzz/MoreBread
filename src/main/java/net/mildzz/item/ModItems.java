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

    private static Item registerFood(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MoreBread.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.BREAD, CINNAMON_BUN);
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        MoreBread.LOGGER.info("Registering MoreBread items...");
    }
}
