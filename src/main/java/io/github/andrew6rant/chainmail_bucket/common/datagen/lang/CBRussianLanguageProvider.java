package io.github.andrew6rant.chainmail_bucket.common.datagen.lang;

import io.github.andrew6rant.chainmail_bucket.init.CBItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class CBRussianLanguageProvider extends FabricLanguageProvider {
    public CBRussianLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "ru_ru", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(CBItems.CHAINMAIL_BUCKET, "Кольчужное ведро");
    }
}
