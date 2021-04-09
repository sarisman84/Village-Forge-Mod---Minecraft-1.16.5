package com.spyro.spyrosvillagers.setup;

import com.spyro.spyrosvillagers.VillagerMod;
import com.spyro.spyrosvillagers.item.eggs.LazySpawnEggItem;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static final class Blocks{
        public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SIVLER = forge("storage_blocks/silver");

                private static ITag.INamedTag<Block> forge(String path){
                return BlockTags.bind(new ResourceLocation(VillagerMod.MOD_ID, path).toString());
                }

                private static ITag.INamedTag<Block> mod(String path){
                return BlockTags.bind(new ResourceLocation(VillagerMod.MOD_ID, path).toString());
                }
    }

    public static final class Items{
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SIVLER = forge("storage_blocks/silver");
        public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("ingots/silver");
        public static final ITag.INamedTag<Item> CUSTOMVILLAGER_SPAWNEGG = forge("spawn_egg/customvillager");
        private static ITag.INamedTag<Item> forge(String path){
            return ItemTags.bind(new ResourceLocation(VillagerMod.MOD_ID, path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path){
            return ItemTags.bind(new ResourceLocation(VillagerMod.MOD_ID, path).toString());
        }
    }

    public static final class Entities{
        public static final ITag.INamedTag<EntityType<?>> CUSTOMVILLAGER = forge("entities/customvillager");

        private static ITag.INamedTag<EntityType<?>> forge(String path){
            return EntityTypeTags.bind(new ResourceLocation(VillagerMod.MOD_ID, path).toString());
        }

        private static ITag.INamedTag<EntityType<?>> mod(String path){
            return EntityTypeTags.bind(new ResourceLocation(VillagerMod.MOD_ID, path).toString());
        }
    }
}
