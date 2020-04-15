package net.msrandom.oceanicambience.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.msrandom.oceanicambience.OceanicAmbience;
import net.msrandom.oceanicambience.client.model.SwellSharkModel;
import net.msrandom.oceanicambience.entity.SwellSharkEntity;

public class SwellSharkRenderer extends MobRenderer<SwellSharkEntity, SwellSharkModel> {
    private static final ResourceLocation PUFFED = new ResourceLocation(OceanicAmbience.MOD_ID, "textures/entity/swell_shark/puffed.png");
    private static final ResourceLocation NORMAL = new ResourceLocation(OceanicAmbience.MOD_ID, "textures/entity/swell_shark/normal.png");

    public SwellSharkRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SwellSharkModel(), 0.4f);
    }

    @Override
    protected void applyRotations(SwellSharkEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
        if (!entityLiving.isInWater()) {
            matrixStackIn.translate(0.2, 0.3, 0);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90));
        }
    }

    @Override
    public ResourceLocation getEntityTexture(SwellSharkEntity entity) {
        return entity.isPuffed() ? PUFFED : NORMAL;
    }
}
