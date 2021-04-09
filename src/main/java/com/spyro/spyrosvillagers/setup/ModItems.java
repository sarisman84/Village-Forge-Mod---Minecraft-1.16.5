package com.spyro.spyrosvillagers.setup;

import com.spyro.spyrosvillagers.item.eggs.LazySpawnEggItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    //final is equal to readonly in C#
    public static final RegistryObject<Item> SILVER_INGOT = Registration.registerItem("silver_ingot", new Item.Properties(),ItemGroup.TAB_MATERIALS);
    public static final RegistryObject<LazySpawnEggItem<?, ?>> CUSTOMVILLAGER_SPAWNEGG = Registration.registerItem("customvillager_egg", () ->
            new LazySpawnEggItem<>(ModEntities.CUSTOMVILLAGER, 1, 1, new Item.Properties().tab(ItemGroup.TAB_MISC))
    );

   static void register(){
       LazySpawnEggItem.addEggsToMap();
   }


}
