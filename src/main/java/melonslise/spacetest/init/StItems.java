package melonslise.spacetest.init;

import melonslise.spacetest.SpaceTestCore;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

public final class StItems
{
	private StItems() {}

	public static final ItemGroup MAIN_ITEM_TAB = FabricItemGroupBuilder.build(SpaceTestCore.id("main"), () -> new ItemStack(Items.APPLE));

	/*
	public static final Item TEST_ITEM = register("test_item", new Item(new Item.Settings().group(MAIN_ITEM_TAB))
	{
		@Override
		public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
		{
			if(!world.isClient)
			{
				return super.use(world, user, hand);
			}

			ChunkPos.stream(new ChunkPos(user.getBlockPos()), 8)
				.map(chunkPos -> world.getChunk(chunkPos.x, chunkPos.z))
				.flatMap(chunk -> chunk.getBlockEntities().values().stream())
				.filter(be -> be.getType() == StBlockEntities.PLANET)
				.findFirst()
				.ifPresent(be ->
					System.out.println(PlanetProjection.planetToSpace(((PlanetBlockEntity) be).planetProps, new Vec3f(user.getPos()))));

			return super.use(world, user, hand);
		}
	});

	 */

	private static Item register(String name, Item item)
	{
		return Registry.register(Registry.ITEM, SpaceTestCore.id(name), item);
	}

	public static void register()
	{
		// NO OP
	}
}