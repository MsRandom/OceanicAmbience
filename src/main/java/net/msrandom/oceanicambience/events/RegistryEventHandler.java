package net.msrandom.oceanicambience.events;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.msrandom.oceanicambience.OceanicAmbience;
import net.msrandom.oceanicambience.entity.OAEntities;
import net.msrandom.oceanicambience.item.OAItems;

@Mod.EventBusSubscriber(modid = OceanicAmbience.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEventHandler {
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        OAEntities.registerEggs();
        event.getRegistry().registerAll(OAItems.LIST.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(OAEntities.LIST.toArray(new EntityType[0]));
        Biomes.LUKEWARM_OCEAN.getSpawns(EntityClassification.WATER_CREATURE).add(new Biome.SpawnListEntry(OAEntities.SLENDER_SUNFISH, 5, 5, 10));
        Biomes.WARM_OCEAN.getSpawns(EntityClassification.WATER_CREATURE).add(new Biome.SpawnListEntry(OAEntities.SLENDER_SUNFISH, 5, 5, 10));
        EntitySpawnPlacementRegistry.register(OAEntities.BOXFISH, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
        EntitySpawnPlacementRegistry.register(OAEntities.SLENDER_SUNFISH, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractFishEntity::func_223363_b);
    }
}
