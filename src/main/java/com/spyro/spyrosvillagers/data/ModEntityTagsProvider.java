package com.spyro.spyrosvillagers.data;

import com.spyro.spyrosvillagers.VillagerMod;
import com.spyro.spyrosvillagers.setup.ModEntities;
import com.spyro.spyrosvillagers.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModEntityTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, VillagerMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Entities.CUSTOMVILLAGER).add(ModEntities.CUSTOMVILLAGER.get());
    }
}
