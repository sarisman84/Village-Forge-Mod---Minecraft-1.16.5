package com.example.examplemod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.function.ToIntFunction;

public class FirstBlock extends Block {

    public FirstBlock() {
        super(Properties.of(Material.METAL).sound(SoundType.METAL).harvestLevel(2).lightLevel((blockState) -> 14));
        setRegistryName("firstblock");

    }

}
