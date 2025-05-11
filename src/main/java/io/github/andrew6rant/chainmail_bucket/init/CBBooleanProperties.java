package io.github.andrew6rant.chainmail_bucket.init;

import io.github.andrew6rant.chainmail_bucket.ChainmailBucket;
import io.github.andrew6rant.chainmail_bucket.common.items.models.WornProperty;
import net.minecraft.client.render.item.property.bool.BooleanProperties;

public class CBBooleanProperties {

    public static void init(){
        BooleanProperties.ID_MAPPER.put(ChainmailBucket.id("worn_property"), WornProperty.CODEC);
    }
}
