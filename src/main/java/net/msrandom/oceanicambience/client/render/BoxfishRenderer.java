package net.msrandom.oceanicambience.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
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
    protected void applyRotations(BoxfishEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
        if (!entityLiving.isInWater()) {
            matrixStackIn.translate(0.2, 0.1, 0);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90));
        }
    }

    @Override
    public ResourceLocation getEntityTexture(BoxfishEntity entity) {
        return TEXTURES[entity.getVariant()];
    }
}
