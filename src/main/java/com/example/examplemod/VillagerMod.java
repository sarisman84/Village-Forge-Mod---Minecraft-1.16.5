package com.example.examplemod;

import com.example.examplemod.blocks.FirstBlock;
import com.example.examplemod.blocks.ModBlocks;
import com.example.examplemod.setup.ClientProxy;
import com.example.examplemod.setup.IProxy;
import com.example.examplemod.setup.ServerProxy;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VillagerMod.MODID)
public class VillagerMod
{
    public static final String MODID = "spyrosvillagers";
    private static final Logger LOGGER = LogManager.getLogger();

    public static IProxy proxy = DistExecutor.unsafeRunForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public VillagerMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }


    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new FirstBlock());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(ModBlocks.FIRSTBLOCK, new Item.Properties()).setRegistryName("firstblock"));

        }
    }
}
