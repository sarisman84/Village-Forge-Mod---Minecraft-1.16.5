package com.spyro.spyrosvillagers.setup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.spyro.spyrosvillagers.VillagerMod.MOD_ID;

public class Registrator {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    //Deffered Registration taken from eerussianguy on Github: https://github.com/eerussianguy/Rainbow-Oaks/blob/main/src/main/java/com/eerussianguy/rainbowoaks/RORegistry.java
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier, ItemGroup tab) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        return block;
    }

    public static <T extends Item> RegistryObject<T> registerItem(String name, Item.Properties properties, ItemGroup tab){
        RegistryObject<T> item = (RegistryObject<T>) ITEMS.register(name, () -> new Item(properties.tab(tab)));
        return item;
    }

    //Taken from SilentChaos512: https://www.youtube.com/watch?v=3Uqnb8TqjTY
    public static void register(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);


        ModItems.register();
        ModBlocks.register();
    }
}
