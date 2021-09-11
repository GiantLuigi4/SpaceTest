package melonslise.spacetest;

import melonslise.spacetest.common.init.SpaceTestBlockEntities;
import melonslise.spacetest.common.init.SpaceTestBlocks;
import melonslise.spacetest.common.init.SpaceTestItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SpaceTest.ID)
public class SpaceTest
{
	public static final String ID = "spacetest";

	public SpaceTest()
	{
		SpaceTestBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SpaceTestItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		SpaceTestBlockEntities.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}