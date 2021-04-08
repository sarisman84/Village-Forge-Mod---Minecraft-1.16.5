package com.spyro.spyrosvillagers.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    //final is equal to readonly in C#
    public static final RegistryObject<Item> SILVER_INGOT = Registration.registerItem("silver_ingot", new Item.Properties(),ItemGroup.TAB_MATERIALS);


    static void register () {}
}
