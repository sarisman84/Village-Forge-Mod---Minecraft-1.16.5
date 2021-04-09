package com.spyro.spyrosvillagers.crafting.recipe;

import com.google.gson.JsonObject;
import com.spyro.spyrosvillagers.setup.ModRecipes;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

//PressingRecipe mimics Stonecutter recipes.
public class PressingRecipe extends SingleItemRecipe {
    public PressingRecipe(ResourceLocation recipeID,
                          Ingredient ingredient,
                          ItemStack result) {
        super(ModRecipes.Types.PRESSING, ModRecipes.Serializers.PRESSING.get(), recipeID, "", ingredient, result);
    }

    @Override
    public boolean matches(IInventory inventory, World world) {
        return this.ingredient.test(inventory.getItem(0));
    }

    //Serialization definition to deserialize information about crafting recipes for Pressing Recipe.
    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<PressingRecipe>{

        //From client basically, read info and de-serialize it.
        @Override
        public PressingRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            //Basically try to search for specific keywords from JSON and convert to info.
            Ingredient ingredient = Ingredient.fromJson(json.get("ingredient"));
            ResourceLocation itemId = new ResourceLocation(JSONUtils.getAsString(json,"result"));
            //Can set the default value to 1 in-case it cant find anything
            int count = JSONUtils.getAsInt(json, "count", 1);

            ItemStack result = new ItemStack(ForgeRegistries.ITEMS.getValue(itemId), count);
            //Once the result, the ingredient and the recipe ID are created, return them as a custom Recipe of a certain type.
            return new PressingRecipe(recipeID, ingredient, result);
        }

        //From server
        @Nullable
        @Override
        public PressingRecipe fromNetwork(ResourceLocation recipeID, PacketBuffer buffer) {
            //Read ingredient from network
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            //Read result
            ItemStack result = buffer.readItem();

            //Create recipe
            return new PressingRecipe(recipeID, ingredient, result);


        }

        //To server
        @Override
        public void toNetwork(PacketBuffer buffer, PressingRecipe recipe) {
            //Write ingredient
            recipe.ingredient.toNetwork(buffer);
            //Write result
            buffer.writeItem(recipe.result);


            //In-case you need multiple ingredients
            /*
             * buffer.writeByte(numberOfIngredients
             *for(int i = 0; i < numberOfIngredients; ++i){
             *
             * buffer.write(ingredient(1))
             * }
             * */
        }
    }
}
