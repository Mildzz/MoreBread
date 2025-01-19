package net.mildzz.morebread.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BLUEBERRIES = new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).build();
    public static final FoodComponent BLUEBERRY_MUFFIN = new FoodComponent.Builder().hunger(3).saturationModifier(0.25f).build();

    public static final FoodComponent JELLY_FILLED_BUN = new FoodComponent.Builder().hunger(3).saturationModifier(.4f).build();
    public static final FoodComponent CHOCOLATE_DONUT = new FoodComponent.Builder().hunger(3).saturationModifier(.35f).build();
    public static final FoodComponent PANCAKES = new FoodComponent.Builder().hunger(3).saturationModifier(.35f).build();
    public static final FoodComponent CINNAMON_BUN = new FoodComponent.Builder().hunger(4).saturationModifier(0.5F).build();
}
