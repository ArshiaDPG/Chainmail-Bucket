package io.github.andrew6rant.chainmail_bucket.init;

import io.github.andrew6rant.chainmail_bucket.ChainmailBucket;
import io.github.andrew6rant.chainmail_bucket.common.items.ChainmailBucketArmorMaterial;
import io.github.andrew6rant.chainmail_bucket.common.items.ChainmailBucketItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.WarningScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

public class CBItems {

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings){
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, ChainmailBucket.id(name)), factory, settings);
    }

    private static Item makeBucketItem(String name, ArmorMaterial material){
        EquipmentType type = EquipmentType.HELMET;
        return register("chainmail_bucket", ChainmailBucketItem::new, new Item.Settings()
                .armor(material, type)
                .component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(type.getEquipmentSlot())
                        .equipSound(material.equipSound())
                        .model(material.assetId())
                        .swappable(false)
                        .build())
                .repairable(material.repairIngredient())
                .maxDamage(11 * ChainmailBucketArmorMaterial.CHAINMAIL_BUCKET.durability())
        );
    }

    public static final Item CHAINMAIL_BUCKET = makeBucketItem("chainmail_bucket", ChainmailBucketArmorMaterial.CHAINMAIL_BUCKET);

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.BUCKET, CHAINMAIL_BUCKET));
    }
}
