package com.spyro.spyrosvillagers.setup;

import com.spyro.spyrosvillagers.blocks.FirstBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    public static final RegistryObject<Block> SILVER_ORE = Registration.registerBlock("silver_ore",() ->
            new Block(AbstractBlock.Properties.of(Material.STONE).strength(3, 10).harvestLevel(2).sound(SoundType.STONE)), ItemGroup.TAB_MATERIALS, true);

    public static final RegistryObject<Block> SILVER_BLOCK = Registration.registerBlock("silver_block",() ->
            new Block(AbstractBlock.Properties.of(Material.METAL).strength(3, 10).harvestLevel(2).sound(SoundType.METAL)), ItemGroup.TAB_MATERIALS, true);


    static void register() {}
}

