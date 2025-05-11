package io.github.andrew6rant.chainmail_bucket;

import io.github.andrew6rant.chainmail_bucket.common.datagen.CBModelProvider;
import io.github.andrew6rant.chainmail_bucket.common.datagen.CBRecipeProvider;
import io.github.andrew6rant.chainmail_bucket.common.datagen.lang.CBLanguageProvider;
import io.github.andrew6rant.chainmail_bucket.common.datagen.lang.CBRussianLanguageProvider;
import io.github.andrew6rant.chainmail_bucket.common.datagen.lang.CBSimplifiedChineseLanguageProvider;
import io.github.andrew6rant.chainmail_bucket.common.datagen.tags.CBItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ChainmailBucketDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack =fabricDataGenerator.createPack();
        pack.addProvider(CBLanguageProvider::new);
        pack.addProvider(CBRussianLanguageProvider::new);
        pack.addProvider(CBSimplifiedChineseLanguageProvider::new);

        pack.addProvider(CBModelProvider::new);
        pack.addProvider(CBRecipeProvider::new);
        pack.addProvider(CBItemTagProvider::new);
    }
}
