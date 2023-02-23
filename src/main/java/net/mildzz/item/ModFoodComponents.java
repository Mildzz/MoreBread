package net.mildzz.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CINNAMON_BUN = new FoodComponent.Builder().hunger(2).saturationModifier(0.5f).build();
    public static final FoodComponent PANCAKES = new FoodComponent.Builder().hunger(5).saturationModifier(5f).build();
    public static final FoodComponent BLUEBERRY_MUFFIN = new FoodComponent.Builder().hunger(3).saturationModifier(3f).build();
    public static final FoodComponent JELLY_FILLED_BUN = new FoodComponent.Builder().hunger(2).saturationModifier(1f).build();
}
