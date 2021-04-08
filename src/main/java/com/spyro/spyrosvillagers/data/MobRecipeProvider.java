package com.spyro.spyrosvillagers.data;

import com.spyro.spyrosvillagers.VillagerMod;
import com.spyro.spyrosvillagers.setup.ModBlocks;
import com.spyro.spyrosvillagers.setup.ModItems;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class MobRecipeProvider extends RecipeProvider {
    public MobRecipeProvider(DataGenerator p_i48262_1_) {
        super(p_i48262_1_);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.SILVER_INGOT.get(), 9)
                .requires(ModBlocks.SILVER_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.SILVER_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.SILVER_BLOCK.get()).define('#',ModItems.SILVER_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item",has(ModItems.SILVER_INGOT.get()))
                .save(consumer);

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item",has(ModBlocks.SILVER_ORE.get()))
                .save(consumer, modID("silver_ingot_smelting"));

        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item",has(ModBlocks.SILVER_ORE.get()))
                .save(consumer, modID("silver_ingot_blasting"));
    }

    private ResourceLocation modID(String path) {
    return new ResourceLocation(VillagerMod.MOD_ID, path);
    }

}
