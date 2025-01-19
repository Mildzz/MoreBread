package net.mildzz.morebread.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mildzz.morebread.MoreBread;
import net.mildzz.morebread.block.custom.BlueberryBushBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLUEBERRY_BUSH_BLOCK = registerBlock("blueberry_bush",
            new BlueberryBushBlock(FabricBlockSettings.copyOf(Blocks.SWEET_BERRY_BUSH)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MoreBread.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MoreBread.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        MoreBread.LOGGER.info("Registering mod blocks for " + MoreBread.MOD_ID);
    }
}
