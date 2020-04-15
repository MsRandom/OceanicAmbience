package net.msrandom.oceanicambience.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.msrandom.oceanicambience.OceanicAmbience;
import net.msrandom.oceanicambience.client.model.SlenderSunfishModel;
import net.msrandom.oceanicambience.entity.SlenderSunfishEntity;

public class SlenderSunfishRenderer extends MobRenderer<SlenderSunfishEntity, SlenderSunfishModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(OceanicAmbience.MOD_ID, "textures/entity/slender_sunfish.png");

    public SlenderSunfishRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SlenderSunfishModel(), 0.2f);
    }

    @Override
    protected void preRenderCallback(SlenderSunfishEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
        matrixStackIn.translate(0, 0.45, 0);
    }

    @Override
    protected void applyRotations(SlenderSunfishEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
        if (!entityLiving.isInWater()) {
            matrixStackIn.translate(0.2, 0.3, 0);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90));
        }
    }

    @Override
    public ResourceLocation getEntityTexture(SlenderSunfishEntity entity) {
        return TEXTURE;
    }
}
