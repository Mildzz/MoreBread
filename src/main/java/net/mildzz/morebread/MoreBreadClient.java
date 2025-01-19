package net.mildzz.morebread;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mildzz.morebread.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class MoreBreadClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_BUSH_BLOCK, RenderLayer.getCutout());
    }
}
