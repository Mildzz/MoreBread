package net.mildzz.morebread.world;

import net.mildzz.morebread.MoreBread;
import net.mildzz.morebread.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_BLUEBERRY_BUSH = registerKey("patch_blueberry_bush");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        ConfiguredFeatures.register(
                context,
                PATCH_BLUEBERRY_BUSH,
                Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH_BLOCK.getDefaultState().with(SweetBerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MoreBread.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
