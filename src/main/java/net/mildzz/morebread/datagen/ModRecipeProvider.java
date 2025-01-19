package net.mildzz.morebread.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mildzz.morebread.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BLUEBERRY_MUFFIN, 2)
                .input('S', ModItems.BLUEBERRIES)
                .input('B', Items.SUGAR)
                .input('C', Items.WHEAT)
                .pattern(" S ")
                .pattern("BBB")
                .pattern("CCC")
                .criterion(hasItem(ModItems.BLUEBERRIES), conditionsFromItem(ModItems.BLUEBERRIES))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(recipeExporter, new Identifier(getRecipeName(ModItems.BLUEBERRY_MUFFIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.JELLY_FILLED_BUN, 2)
                .input('S', Items.SWEET_BERRIES)
                .input('B', Items.SUGAR)
                .input('C', Items.WHEAT)
                .pattern("CCC")
                .pattern("BSB")
                .pattern("CCC")
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(recipeExporter, new Identifier(getRecipeName(ModItems.JELLY_FILLED_BUN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHOCOLATE_DONUT, 2)
                .input('S', Items.COCOA_BEANS)
                .input('C', Items.WHEAT)
                .pattern(" SS")
                .pattern(" CC")
                .pattern(" CC")
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(recipeExporter, new Identifier(getRecipeName(ModItems.CHOCOLATE_DONUT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PANCAKES, 2)
                .input('S', ModItems.BUTTER)
                .input('C', Items.WHEAT)
                .pattern(" S ")
                .pattern("CCC")
                .criterion(hasItem(ModItems.BUTTER), conditionsFromItem(ModItems.BUTTER))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(recipeExporter, new Identifier(getRecipeName(ModItems.PANCAKES)));

        offerButterRecipe(recipeExporter, ModItems.BUTTER, Items.MILK_BUCKET);

        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.FOOD, ModItems.CINNAMON_BUN, Items.WHEAT);
    }

    public static CraftingRecipeJsonBuilder createButterRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(category, output, 8).input('#', input).pattern("##");
    }

    public static void offerButterRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createButterRecipe(RecipeCategory.FOOD, output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
}
