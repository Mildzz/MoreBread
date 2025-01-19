package net.mildzz.morebread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.mildzz.morebread.block.ModBlocks;
import net.mildzz.morebread.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;

import java.util.function.Consumer;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Consumer<BlockStateSupplier> blockStateCollector = blockStateModelGenerator.blockStateCollector;
        blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.BLUEBERRY_BUSH_BLOCK)
                        .coordinate(
                                BlockStateVariantMap.create(Properties.AGE_3)
                                        .register(
                                                stage -> BlockStateVariant.create()
                                                        .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(ModBlocks.BLUEBERRY_BUSH_BLOCK, "_stage" + stage, Models.CROSS, TextureMap::cross))
                                        )
                        )
        );

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BUTTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_MUFFIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.JELLY_FILLED_BUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE_DONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANCAKES, Models.GENERATED);
        itemModelGenerator.register(ModItems.CINNAMON_BUN, Models.GENERATED);
    }
}
