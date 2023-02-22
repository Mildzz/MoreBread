package net.mildzz.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.mildzz.MoreBread;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup BREAD;

    public static void registerItemGroups() {
        BREAD = FabricItemGroup.builder(new Identifier(MoreBread.MOD_ID, "bread"))
                .displayName(Text.translatable("itemgroup.bread"))
                .icon(() -> new ItemStack(ModItems.CINNAMON_BUN)).build();
    }
}
