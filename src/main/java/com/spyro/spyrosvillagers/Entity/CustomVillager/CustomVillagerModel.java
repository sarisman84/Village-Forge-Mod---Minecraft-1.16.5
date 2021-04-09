package com.spyro.spyrosvillagers.Entity.CustomVillager;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CustomVillagerModel extends BipedModel<CustomVillagerEntity> {

    public ModelRenderer body;

    protected CustomVillagerModel(float p_i1149_1_, float p_i1149_2_, int p_i1149_3_, int p_i1149_4_) {
        super(p_i1149_1_, p_i1149_2_, p_i1149_3_, p_i1149_4_);
    }


//    @Override
//    public void setupAnim(CustomVillagerEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
//
//    }

//    @Override
//    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
//
//    }
}
