package mod.coda.oceanicambience.events;

import mod.coda.oceanicambience.OceanicAmbience;
import mod.coda.oceanicambience.client.render.BoxfishRenderer;
import mod.coda.oceanicambience.entity.OAEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = OceanicAmbience.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventHandler {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(OAEntities.BOXFISH, BoxfishRenderer::new);
    }
}
