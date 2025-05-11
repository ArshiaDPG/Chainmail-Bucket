package io.github.andrew6rant.chainmail_bucket.common.datagen.tags;

import io.github.andrew6rant.chainmail_bucket.init.CBItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class CBItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public CBItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ConventionalItemTags.EMPTY_BUCKETS).add(CBItems.CHAINMAIL_BUCKET);
    }
}
