package net.mildzz.morebread.world;

import net.mildzz.morebread.MoreBread;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PATCH_BLUEBERRY_COMMON = registerKey("patch_blueberry_common");
    public static final RegistryKey<PlacedFeature> PATCH_BLUEBERRY_RARE = registerKey("patch_blueberry_rare");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry1 = configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PATCH_BLUEBERRY_BUSH);

        PlacedFeatures.register(
                context,
                PATCH_BLUEBERRY_COMMON,
                registryEntry1,
                RarityFilterPlacementModifier.of(32),
                SquarePlacementModifier.of(),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(
                context,
                PATCH_BLUEBERRY_RARE,
                registryEntry1,
                RarityFilterPlacementModifier.of(384),
                SquarePlacementModifier.of(),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

    }


        public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MoreBread.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
