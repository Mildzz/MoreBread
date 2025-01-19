package net.mildzz.morebread.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mildzz.morebread.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBushGeneration {
    public static void generateBushes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_BLUEBERRY_COMMON);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_BLUEBERRY_RARE);

    }
}
