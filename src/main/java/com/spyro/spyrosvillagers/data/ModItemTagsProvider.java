package com.spyro.spyrosvillagers.data;

import com.spyro.spyrosvillagers.VillagerMod;
import com.spyro.spyrosvillagers.setup.ModItems;
import com.spyro.spyrosvillagers.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator p_i232552_1_, BlockTagsProvider p_i232552_2_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_i232552_1_, p_i232552_2_, VillagerMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_SIVLER, ModTags.Items.STORAGE_BLOCKS_SIVLER);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        tag(ModTags.Items.INGOTS_SILVER).add(ModItems.SILVER_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);
        tag(ModTags.Items.CUSTOMVILLAGER_SPAWNEGG).add(ModItems.CUSTOMVILLAGER_SPAWNEGG.get());
        tag(Tags.Items.EGGS).addTag(ModTags.Items.CUSTOMVILLAGER_SPAWNEGG);
    }
}
