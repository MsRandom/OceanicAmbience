package net.msrandom.oceanicambience.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.msrandom.oceanicambience.OceanicAmbience;
import net.msrandom.oceanicambience.client.render.BoxfishRenderer;
import net.msrandom.oceanicambience.entity.OAEntities;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = OceanicAmbience.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventHandler {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(OAEntities.BOXFISH, BoxfishRenderer::new);
    }
}
