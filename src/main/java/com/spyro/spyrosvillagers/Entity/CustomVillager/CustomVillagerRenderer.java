package com.spyro.spyrosvillagers.Entity.CustomVillager;

import com.spyro.spyrosvillagers.VillagerMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CustomVillagerRenderer extends MobRenderer<CustomVillagerEntity, CustomVillagerModel>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(VillagerMod.MOD_ID, "extures/entity/customvillager.png");

    public CustomVillagerRenderer(EntityRendererManager manager, CustomVillagerModel customVillagerModel, float size) {
        super(manager, customVillagerModel, size);
    }

    @Override
    public ResourceLocation getTextureLocation(CustomVillagerEntity p_110775_1_) {
        return TEXTURE;
    }
}
