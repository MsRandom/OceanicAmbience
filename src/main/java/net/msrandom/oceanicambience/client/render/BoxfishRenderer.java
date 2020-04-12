package net.msrandom.oceanicambience.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.msrandom.oceanicambience.OceanicAmbience;
import net.msrandom.oceanicambience.client.model.BoxfishModel;
import net.msrandom.oceanicambience.entity.BoxfishEntity;

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
