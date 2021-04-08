package com.spyro.spyrosvillagers.data;

import com.spyro.spyrosvillagers.VillagerMod;
import com.spyro.spyrosvillagers.data.client.ModBlockStateProvider;
import com.spyro.spyrosvillagers.data.client.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = VillagerMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        gen.addProvider(new ModItemModelProvider(gen, helper));
        gen.addProvider(new ModBlockStateProvider(gen, helper));

        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(gen, helper);
        gen.addProvider(blockTagsProvider);
        gen.addProvider(new ModItemTagsProvider(gen, blockTagsProvider, helper));

        gen.addProvider(new ModLootTableProvider(gen));
        gen.addProvider(new MobRecipeProvider(gen));
    }
}
