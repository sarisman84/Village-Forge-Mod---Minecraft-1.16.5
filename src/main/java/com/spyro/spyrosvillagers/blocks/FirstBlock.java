package com.spyro.spyrosvillagers.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FirstBlock extends Block {

    public FirstBlock() {
        super(Properties.of(Material.METAL).sound(SoundType.METAL).harvestLevel(2).lightLevel((blockState) -> 14));
        setRegistryName("firstblock");

    }

}
