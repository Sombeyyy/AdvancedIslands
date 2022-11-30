package de.sombeyyy.islands.world;

import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RepeatingWorldGenerator extends ChunkGenerator {

    @Override
    public void generateNoise(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
        //super.generateNoise(worldInfo, random, chunkX, chunkZ, chunkData);
        for(int y = chunkData.getMinHeight(); y < 65 && y < chunkData.getMaxHeight(); y++) {
            for(int x = 0; x < 16; x++) {
                for(int z = 0; z < 16; z++) {
                    chunkData.setBlock(x, y, z, Material.STONE);
                }
            }
        }
    }

    private ChunkData generateDefaultChunk(ChunkData chunkData) {
        chunkData.setRegion(0, -64, 0, 15, -61, 15, Material.BEDROCK);
        chunkData.setRegion(0, -60, 0, 15, -48, 15, Material.STONE);
        chunkData.setRegion(0, -47, 0, 15, -33, 15, Material.SAND);
        //y=-32 to y=-25 can contain sand after landscaping
        chunkData.setRegion(0, -32, 0, 15, 0, 15, Material.WATER);
        return chunkData;
    }

}
