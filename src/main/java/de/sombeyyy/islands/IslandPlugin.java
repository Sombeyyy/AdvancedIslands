package de.sombeyyy.islands;

import de.sombeyyy.islands.world.RepeatingWorldGenerator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public class IslandPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "Island Plugin was enabled successfully.");
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "Island Plugin was disabled successfully.");
    }

    @Override
    public @Nullable ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
        getLogger().log(Level.WARNING, "RepeatingWorldGenerator is used!");
        return new RepeatingWorldGenerator();
    }

    //TODO: bukkit.yml -> worlds: world: generator: 'IslandPlugin'

}
