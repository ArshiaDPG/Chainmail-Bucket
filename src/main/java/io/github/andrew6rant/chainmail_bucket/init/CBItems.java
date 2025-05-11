package io.github.andrew6rant.chainmail_bucket.init;

import io.github.andrew6rant.chainmail_bucket.ChainmailBucket;
import io.github.andrew6rant.chainmail_bucket.common.items.ChainmailBucketArmorMaterial;
import io.github.andrew6rant.chainmail_bucket.common.items.ChainmailBucketItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

public class CBItems {

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings){
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, ChainmailBucket.id(name)), factory, settings);
    }

    public static final Item CHAINMAIL_BUCKET = register("chainmail_bucket", ChainmailBucketItem::new, new Item.Settings()
            .armor(ChainmailBucketArmorMaterial.CHAINMAIL_BUCKET, EquipmentType.HELMET)
            .equippableUnswappable(EquipmentSlot.HEAD)
            .maxDamage(11 * ChainmailBucketArmorMaterial.CHAINMAIL_BUCKET.durability()));

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.BUCKET, CHAINMAIL_BUCKET));
    }
}
