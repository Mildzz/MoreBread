package net.mildzz;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mildzz.block.ModBlocks;
import net.mildzz.config.MoreBreadConfig;
import net.mildzz.item.ModItemGroup;
import net.mildzz.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

import java.util.ArrayList;
import java.util.function.Predicate;

public class MoreBread implements ModInitializer {
    public static final String MOD_ID = "more-bread";
    public static MoreBreadConfig config;

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModItems.addItemsToItemGroup();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_BUSH_BLOCK, RenderLayer.getCutout());
        AutoConfig.register(MoreBreadConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(MoreBreadConfig.class).getConfig();

        registerBiomeGeneration(config.blackBerrySpawnBiomes, ModBlocks.BLUEBERRY_BUSH_BLOCK,
                "blueberry");
    }

    private void registerBiomeGeneration(String spawnBiomes, Block bushBlock, String name) {
        String[] biomes = spawnBiomes.replaceAll(" ", "").split(",");

        // Get list of spawn biomes
        ArrayList<RegistryKey<Biome>> biomeKeys = new ArrayList<>();
        ArrayList<TagKey<Biome>> biomeTags = new ArrayList<>();

        for (String biome : biomes) {
            // Category
            if (biome.charAt(0) == '#') {
                biomeTags.add(TagKey.of(RegistryKeys.BIOME, new Identifier(biome.substring(1))));
            } else {
                // Biome
                biomeKeys.add(RegistryKey.of(RegistryKeys.BIOME, new Identifier(biome)));
            }
        }

        Predicate<BiomeSelectionContext> biomeSelector = BiomeSelectors.includeByKey(biomeKeys);

        if (!biomeTags.isEmpty()) {
            for (TagKey<Biome> biomeTag : biomeTags) {
                biomeSelector = biomeSelector.or(BiomeSelectors.tag(biomeTag));
            }
        }

        // Add to biomes
        BiomeModifications.addFeature(biomeSelector,
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE,
                        new Identifier("more-bread", String.format("%s_generation", name))));
    }
}
