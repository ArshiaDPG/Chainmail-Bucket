package io.github.andrew6rant.chainmail_bucket.common.datagen;

import io.github.andrew6rant.chainmail_bucket.common.items.models.WornProperty;
import io.github.andrew6rant.chainmail_bucket.init.CBItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;

import java.util.List;

public class CBModelProvider extends FabricModelProvider {
    public CBModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerChainmailBucket(itemModelGenerator, CBItems.CHAINMAIL_BUCKET);
    }

    public final void registerChainmailBucket(ItemModelGenerator itemModelGenerator, Item item) {
        ItemModel.Unbaked unworn = ItemModels.basic(itemModelGenerator.registerSubModel(item, "", Models.GENERATED));
        ItemModel.Unbaked worn = ItemModels.basic(itemModelGenerator.registerSubModel(item, "_helmet", Models.GENERATED));
        itemModelGenerator.output.accept(item, ItemModels.condition(new WornProperty(List.of(EquipmentSlot.HEAD)), worn, unworn));
    }
}
