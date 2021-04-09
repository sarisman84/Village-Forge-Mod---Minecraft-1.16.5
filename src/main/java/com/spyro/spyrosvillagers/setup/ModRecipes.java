package com.spyro.spyrosvillagers.setup;

import com.spyro.spyrosvillagers.VillagerMod;
import com.spyro.spyrosvillagers.crafting.recipe.PressingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModRecipes {
    public static class Types{
        public static final IRecipeType<PressingRecipe> PRESSING = IRecipeType.register(VillagerMod.MOD_ID + "pressing");
    }

    public static class Serializers{
        public static final RegistryObject<IRecipeSerializer<?>> PRESSING = Registration.RECIPE_SERIALIZERS.register("pressing", PressingRecipe.Serializer::new);

    }

    static void register() {}
    private ModRecipes() {}
}
