package io.github.andrew6rant.chainmail_bucket.common.datagen;

import io.github.andrew6rant.chainmail_bucket.init.CBItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class CBModelProvider extends FabricModelProvider {
    public CBModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Models.GENERATED.upload(ModelIds.getItemSubModelId(CBItems.CHAINMAIL_BUCKET, "_bucket"), TextureMap.layer0(TextureMap.getId(CBItems.CHAINMAIL_BUCKET)), itemModelGenerator.writer);
        itemModelGenerator.register(CBItems.CHAINMAIL_BUCKET, "_helmet", Models.GENERATED);
    }
}
