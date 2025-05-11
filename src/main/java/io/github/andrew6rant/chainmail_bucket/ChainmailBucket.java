package io.github.andrew6rant.chainmail_bucket;

import io.github.andrew6rant.chainmail_bucket.init.CBBooleanProperties;
import io.github.andrew6rant.chainmail_bucket.init.CBItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.texture.PlayerSkinProvider;
import net.minecraft.util.Identifier;

public class ChainmailBucket implements ModInitializer {
    public static final String MOD_ID = "chainmail_bucket";
    public static Identifier id(String name){
        return Identifier.of(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        CBItems.init();
        CBBooleanProperties.init();
    }
}
