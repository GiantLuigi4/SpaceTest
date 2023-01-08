package melonslise.spacetest.world.dimension;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import melonslise.spacetest.SpaceTestCore;
import net.minecraft.block.BlockState;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.Blender;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.noise.NoiseConfig;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class VoidChunkGenerator extends ChunkGenerator
{
	public static final Identifier ID = new Identifier(SpaceTestCore.ID, "void");

	public static final Codec<VoidChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(
					RegistryOps.createRegistryCodec(Registry.STRUCTURE_SET_KEY).forGetter(c -> c.structureSetRegistry),
					RegistryOps.createRegistryCodec(Registry.BIOME_KEY).forGetter(c -> c.biomeRegistry))
			.apply(instance, instance.stable(VoidChunkGenerator::new)));

	private final Registry<Biome> biomeRegistry;

	public VoidChunkGenerator(Registry<StructureSet> structureSetRegistry, Registry<Biome> biomeRegistry)
	{
		super(structureSetRegistry, Optional.of(RegistryEntryList.of(Collections.emptyList())), new FixedBiomeSource(biomeRegistry.getOrCreateEntry(BiomeKeys.PLAINS))); // FIXME: own biome
		this.biomeRegistry = biomeRegistry;
	}

	@Override
	protected Codec<? extends ChunkGenerator> getCodec()
	{
		return CODEC;
	}

	@Override
	public void carve(ChunkRegion chunkRegion, long seed, NoiseConfig noiseConfig, BiomeAccess biomeAccess, StructureAccessor structureAccessor, Chunk chunk, GenerationStep.Carver carverStep)
	{

	}

	@Override
	public void buildSurface(ChunkRegion region, StructureAccessor structures, NoiseConfig noiseConfig, Chunk chunk)
	{

	}

	@Override
	public void populateEntities(ChunkRegion region)
	{

	}

	@Override
	public int getWorldHeight()
	{
		return 384;
	}

	@Override
	public CompletableFuture<Chunk> populateNoise(Executor executor, Blender blender, NoiseConfig noiseConfig, StructureAccessor structureAccessor, Chunk chunk)
	{
		return CompletableFuture.completedFuture(chunk);
	}

	@Override
	public int getSeaLevel()
	{
		return 64;
	}

	@Override
	public int getMinimumY()
	{
		return 0;
	}

	@Override
	public int getHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world, NoiseConfig noiseConfig)
	{
		return 0;
	}

	@Override
	public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world, NoiseConfig noiseConfig)
	{
		return new VerticalBlockSample(0, new BlockState[0]);
	}

	@Override
	public void getDebugHudText(List<String> text, NoiseConfig noiseConfig, BlockPos pos)
	{

	}
}