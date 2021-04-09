package com.spyro.spyrosvillagers.setup;

import com.spyro.spyrosvillagers.VillagerMod;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Supplier;

public class Registration {

    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = create(ForgeRegistries.CONTAINERS);
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = create(ForgeRegistries.TILE_ENTITIES);
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = create(ForgeRegistries.RECIPE_SERIALIZERS);
    public static final DeferredRegister<EntityType<?>> ENTITIES = create(ForgeRegistries.ENTITIES);


    //Deffered Registration taken from eerussianguy as well as altered based on SilentChaos512's videos. errussiangu -> Github: https://github.com/eerussianguy/Rainbow-Oaks/blob/main/src/main/java/com/eerussianguy/rainbowoaks/RORegistry.java
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier, ItemGroup tab, boolean registerItem) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        if(registerItem)
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        return block;
    }



    public static <T extends Item> RegistryObject<T> registerItem(String name, Item.Properties properties, ItemGroup tab){
        RegistryObject<T> item = (RegistryObject<T>) ITEMS.register(name, () -> new Item(properties.tab(tab)));
        return item;
    }
    public static <T extends Item>RegistryObject<T> registerItem(String name, Supplier<T> item){
        return ITEMS.register(name, item);
    }

    //Taken from SilentChaos512: https://www.youtube.com/watch?v=3Uqnb8TqjTY
    //Used to initialize the registrators (is called in the Villager Core class).
    public static void register(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CONTAINERS.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
        TILE_ENTITIES.register(modEventBus);
        ENTITIES.register(modEventBus);

        //Class load registries
        ModItems.register();
        ModBlocks.register();
        ModRecipes.register();
        ModTileEntityTypes.register();
        ModContainerTypes.register();
        ModEntities.register();

    }



    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, VillagerMod.MOD_ID);
    }
}
