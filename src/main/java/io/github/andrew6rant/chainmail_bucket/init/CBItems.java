package io.github.andrew6rant.chainmail_bucket.init;

import io.github.andrew6rant.chainmail_bucket.ChainmailBucket;
import io.github.andrew6rant.chainmail_bucket.common.items.ChainmailBucketArmorMaterial;
import io.github.andrew6rant.chainmail_bucket.common.items.ChainmailBucketItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class CBItems {

    private static Item register(String name, Item item){
        return Registry.register(Registries.ITEM, ChainmailBucket.id(name), item);
    }

    public static final Item CHAINMAIL_BUCKET = register("chainmail_bucket", new ChainmailBucketItem(ChainmailBucketArmorMaterial.CHAINMAIL_BUCKET, ArmorItem.Type.HELMET,new Item.Settings()
            .maxDamage(net.minecraft.item.ArmorItem.Type.HELMET.getMaxDamage(15))
    ));

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.BUCKET, CHAINMAIL_BUCKET));
    }
}
