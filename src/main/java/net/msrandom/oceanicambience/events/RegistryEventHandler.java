package net.msrandom.oceanicambience.events;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
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
        event.getRegistry().registerAll(OAItems.LIST.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(OAEntities.LIST.toArray(new EntityType[0]));
    }
}
