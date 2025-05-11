package io.github.andrew6rant.chainmail_bucket.common.items.models;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.render.item.property.bool.BooleanProperty;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record WornProperty(List<EquipmentSlot> slotList) implements BooleanProperty {

    public static final MapCodec<WornProperty> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            Codec.list(EquipmentSlot.CODEC).fieldOf("valid_slots").orElse(EquipmentSlot.VALUES.stream().filter(EquipmentSlot::isArmorSlot).toList()).forGetter(WornProperty::slotList))
            .apply(instance, WornProperty::new));

    @Override
    public MapCodec<? extends BooleanProperty> getCodec() {
        return CODEC;
    }

    @Override
    public boolean test(ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity entity, int seed, ItemDisplayContext displayContext) {
        if (entity == null){
            return false;
        }
        for (EquipmentSlot slot : slotList){
            if (entity.canUseSlot(slot) && stack == entity.getEquippedStack(slot)){
                return true;
            }
        }
        return false;
    }
}
