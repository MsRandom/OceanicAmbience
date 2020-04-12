package mod.coda.oceanicambience.client.render;

import mod.coda.oceanicambience.OceanicAmbience;
import mod.coda.oceanicambience.client.model.BoxfishModel;
import mod.coda.oceanicambience.entity.BoxfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BoxfishRenderer extends MobRenderer<BoxfishEntity, BoxfishModel> {
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[4];
    static {
        for (int i = 0; i < TEXTURES.length; i++)
            TEXTURES[i] = new ResourceLocation(OceanicAmbience.MOD_ID, "textures/entity/boxfish/texture_" + (i + 1) + ".png");
    }
    public BoxfishRenderer(EntityRendererManager managerIn) {
        super(managerIn, new BoxfishModel(), 0.2f);
    }

    @Override
    public ResourceLocation getEntityTexture(BoxfishEntity entity) {
        return TEXTURES[entity.getVariant()];
    }
}
