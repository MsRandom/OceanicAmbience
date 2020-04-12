package mod.coda.oceanicambience.events;

import mod.coda.oceanicambience.OceanicAmbience;
import mod.coda.oceanicambience.entity.OAEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OceanicAmbience.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEventHandler {

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(OAEntities.LIST.toArray(new EntityType[0]));
    }
}
