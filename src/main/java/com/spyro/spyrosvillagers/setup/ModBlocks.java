package com.spyro.spyrosvillagers.setup;

import com.spyro.spyrosvillagers.block.metalpress.MetalPressBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModBlocks {

    public static final RegistryObject<Block> SILVER_ORE = Registration.registerBlock("silver_ore",() ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3, 10)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)), ItemGroup.TAB_MATERIALS, true);

    public static final RegistryObject<Block> SILVER_BLOCK = Registration.registerBlock("silver_block",() ->
            new Block(AbstractBlock.Properties.of(Material.METAL).strength(3, 10).harvestLevel(2).sound(SoundType.METAL)), ItemGroup.TAB_MATERIALS, true);


    public static final RegistryObject<MetalPressBlock> METAL_PRESS = Registration.registerBlock("metal_press", () ->
            new MetalPressBlock(AbstractBlock.Properties
                    .of(Material.METAL)
                    .strength(4, 20)
                    .sound(SoundType.METAL)), ItemGroup.TAB_DECORATIONS,true);

    static void register() {}
}

