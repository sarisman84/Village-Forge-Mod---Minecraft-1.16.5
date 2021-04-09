package com.spyro.spyrosvillagers.setup;

import com.spyro.spyrosvillagers.Entity.CustomVillager.CustomVillagerEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModEntities {


    public static final RegistryObject<EntityType<CustomVillagerEntity>> CUSTOMVILLAGER = Registration.ENTITIES
            .register("customvillager", () -> EntityType.Builder.of(CustomVillagerEntity::new, EntityClassification.CREATURE)
                    .sized(0.5f, 0.5f).setShouldReceiveVelocityUpdates(false)
                    .build("customvillager"));


    public static void register() {
    }


}
