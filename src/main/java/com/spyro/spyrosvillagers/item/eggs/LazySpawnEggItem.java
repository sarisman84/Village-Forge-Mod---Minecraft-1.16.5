package com.spyro.spyrosvillagers.item.eggs;

import jdk.nashorn.internal.runtime.Debug;
import jdk.nashorn.internal.runtime.logging.DebugLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;


//By WolfShotz: https://github.com/WolfShotz/Wyrmroost/blob/master/src/main/java/com/github/wolfshotz/wyrmroost/items/LazySpawnEggItem.java#L58
public class LazySpawnEggItem<E extends Entity, T extends EntityType<E>> extends SpawnEggItem {
    public static final Set<LazySpawnEggItem> SPAWN_EGGS = new HashSet<>();

    public final Lazy<T> type;

    public LazySpawnEggItem(Supplier<T> type, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);

        this.type = Lazy.of(type);
        SPAWN_EGGS.add(this);
    }


    @Override
    public ITextComponent getName(ItemStack p_200295_1_) {
        ResourceLocation regName = type.get().getRegistryName();
        return new TranslationTextComponent("entity." + regName.getNamespace() + "." + regName.getPath())
                .append(" ").append(new TranslationTextComponent("item.spyrosvillagers.spawn_egg"));
    }

    public EntityType<?> getType(@Nullable CompoundNBT tag) {
        if (tag != null && tag.contains("EntityTag", 10)) {
            CompoundNBT childTag = tag.getCompound("EntityTag");
            if (childTag.contains("id", 8))
                return EntityType.byString(childTag.getString("id")).orElse(type.get());
        }

        return type.get();
    }

    public static void addEggsToMap() {
        try {
            Map<EntityType<?>, SpawnEggItem> eggMap = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
            for (LazySpawnEggItem item : SPAWN_EGGS) eggMap.put((EntityType<?>)item.type.get(), item);
        } catch (Exception e) {
            DebugLogger.quote(e.getMessage());
        }
    }
}


