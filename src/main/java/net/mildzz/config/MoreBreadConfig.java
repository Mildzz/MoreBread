package net.mildzz.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "more-bread")
public class MoreBreadConfig implements ConfigData {
    public String blackBerrySpawnBiomes = "minecraft:taiga,minecraft:taiga_hills,minecraft:taiga_mountains,minecraft:taiga_cold,minecraft:taiga_cold_hills,minecraft:taiga_cold_mountains,minecraft:dark_forest,minecraft:dark_forest_hills";

    public boolean craftableBerryBushes = false;
    public boolean replaceSweetBerryBushModel = true;
}
