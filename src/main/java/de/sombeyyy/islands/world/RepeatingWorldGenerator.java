package de.sombeyyy.islands.world;

import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
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

    /**
     * Generate flat chunk data without noise
     * @param chunkData the data of the chunk
     * @return chunk with flat layers
     */
    private ChunkData generateDefaultChunk(ChunkData chunkData) {
        chunkData.setRegion(0, -64, 0, 15, -61, 15, Material.BEDROCK);
        chunkData.setRegion(0, -60, 0, 15, -48, 15, Material.STONE);
        chunkData.setRegion(0, -47, 0, 15, -33, 15, Material.SAND);
        //y=-32 to y=-25 can contain sand after landscaping
        chunkData.setRegion(0, -32, 0, 15, 0, 15, Material.WATER);
        return chunkData;
    }

    /**
     * Manipulate the flat layer chunk so there is some repeating noise
     * @param chunkData the data of the chunk
     * @param chunkX x coordinate of the chunk
     * @param chunkZ z coordinate of the chunk
     * @return chunk with repeating noisiness
     */
    private ChunkData manipulateDefaultChunk(ChunkData chunkData, int chunkX, int chunkZ) {
        Pair<Byte, Byte> reducedCoords = getReducedChunkCoords(chunkX, chunkZ);
        return chunkData;
    }

    /**
     * Reduces the chunk coordinate to values between 0 and 15
     * @param chunkX x coordinate of the chunk (west/east)
     * @param chunkZ z coordinate of the chunk (north/west)
     * @return values between 0 and 15
     */
    private Pair<Byte, Byte> getReducedChunkCoords(int chunkX, int chunkZ) {
        chunkX = chunkX >> 4;
        chunkZ = chunkZ >> 4;
        return new Pair<>((byte) chunkX, (byte) chunkZ);
    }

    private record Pair<T, K>(T first, K second) {

        @Override
            public String toString() {
                return "Pair<" + first + "," + second + ">";
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair<?, ?> pair = (Pair<?, ?>) o;
                return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
            }

    }

}
