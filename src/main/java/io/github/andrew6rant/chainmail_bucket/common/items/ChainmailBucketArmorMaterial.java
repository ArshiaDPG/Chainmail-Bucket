package io.github.andrew6rant.chainmail_bucket.common.items;

import com.google.common.collect.Maps;
import io.github.andrew6rant.chainmail_bucket.common.datagen.CBEquipmentAssetProvider;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public interface ChainmailBucketArmorMaterial {

    ArmorMaterial CHAINMAIL_BUCKET = new ArmorMaterial(15, createDefenseMap(1, 4, 5, 2, 4), 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, ItemTags.REPAIRS_CHAIN_ARMOR, CBEquipmentAssetProvider.CHAINMAIL_BUCKET);
    private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(Map.of(EquipmentType.BOOTS, bootsDefense, EquipmentType.LEGGINGS, leggingsDefense, EquipmentType.CHESTPLATE, chestplateDefense, EquipmentType.HELMET, helmetDefense, EquipmentType.BODY, bodyDefense));
    }
}
