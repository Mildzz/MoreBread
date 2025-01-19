package net.mildzz.morebread.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.mildzz.morebread.MoreBread;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup CRYSTAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MoreBread.MOD_ID, "bread"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bread"))
                    .icon(() -> new ItemStack(ModItems.BUTTER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BUTTER);
                        entries.add(ModItems.BLUEBERRIES);
                        entries.add(ModItems.BLUEBERRY_MUFFIN);
                        entries.add(ModItems.CINNAMON_BUN);
                        entries.add(ModItems.JELLY_FILLED_BUN);
                        entries.add(ModItems.CHOCOLATE_DONUT);
                        entries.add(ModItems.PANCAKES);
                    }).build());

    public static void registerItemGroups() {
        MoreBread.LOGGER.info("Registering mod item groups for " + MoreBread.MOD_ID);
    }
}
