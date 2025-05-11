package io.github.andrew6rant.chainmail_bucket.client;

import io.github.andrew6rant.chainmail_bucket.init.CBItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;



@Environment(EnvType.CLIENT)
public class ChainmailBucketClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(CBItems.CHAINMAIL_BUCKET, Identifier.ofVanilla("is_helmet"), (itemStack, clientWorld, livingEntity, j) -> {
            if (livingEntity instanceof PlayerEntity) {
                return livingEntity.getEquippedStack(EquipmentSlot.HEAD) == itemStack ? 1.0F : 0.0F;
            } return 0.0F;
        });
    }
}
