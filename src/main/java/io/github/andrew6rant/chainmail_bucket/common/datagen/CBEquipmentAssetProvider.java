package io.github.andrew6rant.chainmail_bucket.common.datagen;

import io.github.andrew6rant.chainmail_bucket.ChainmailBucket;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/*
    As taken from: https://github.com/Starexify/BigSwordsR/blob/1.21.4-fabric/src%2Fclient%2Fjava%2Fnet%2Fnova%2Fbig_swords%2Fdata%2Fmodels%2FBSEquipmentModelProvider.java
 */
public class CBEquipmentAssetProvider implements DataProvider {
    public final FabricDataOutput output;
    public final DataOutput.PathResolver pathResolver;

    public static final RegistryKey<EquipmentAsset> CHAINMAIL_BUCKET = register("chainmail_bucket");
    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, ChainmailBucket.id(name));
    }
    public CBEquipmentAssetProvider(FabricDataOutput output) {
        this.output = output;
        this.pathResolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "equipment");
    }

    public static void bootstrap(BiConsumer<RegistryKey<EquipmentAsset>, EquipmentModel> equipmentBiConsumer) {
        equipmentBiConsumer.accept(CHAINMAIL_BUCKET, EquipmentModel.builder().addHumanoidLayers(CHAINMAIL_BUCKET.getValue()).build());
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        Map<RegistryKey<EquipmentAsset>, EquipmentModel> map = new HashMap<>();
        bootstrap((key, model) -> {
            if (map.putIfAbsent(key, model) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + key);
            }
        });
        return DataProvider.writeAllToPath(writer, EquipmentModel.CODEC, this.pathResolver::resolveJson, map);
    }

    @Override
    public String getName() {
        return "Chainmail Bucket Equipment Model Generator";
    }
}
