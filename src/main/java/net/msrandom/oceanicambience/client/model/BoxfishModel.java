package net.msrandom.oceanicambience.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.msrandom.oceanicambience.entity.BoxfishEntity;

public class BoxfishModel extends SegmentedModel<BoxfishEntity> {
    public ModelRenderer body;
    public ModelRenderer tail;
    public ModelRenderer fronthornright;
    public ModelRenderer fronthornleft;
    public ModelRenderer backspikeright;
    public ModelRenderer backspikeleft;
    public ModelRenderer dorsalfin;
    public ModelRenderer analfin;
    public ModelRenderer nosebump;
    public ModelRenderer rightpectoralfin;
    public ModelRenderer leftpectoralfin;

    public BoxfishModel() {
        this.textureWidth = 34;
        this.textureHeight = 22;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.body.addBox(-2.0F, -2.0F, -2.5F, 4, 4, 5, 0.0F);
        this.fronthornleft = new ModelRenderer(this, 0, 0);
        this.fronthornleft.mirror = true;
        this.fronthornleft.setRotationPoint(2.0F, -1.5F, -2.5F);
        this.fronthornleft.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(fronthornleft, 0.0F, -0.3490658503988659F, 0.0F);
        this.backspikeright = new ModelRenderer(this, 0, -2);
        this.backspikeright.setRotationPoint(-2.0F, 1.5F, 2.5F);
        this.backspikeright.addBox(0.0F, -0.5F, 0.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(backspikeright, 0.0F, -0.17453292519943295F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 7);
        this.tail.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.tail.addBox(0.0F, -2.0F, 0.0F, 0, 4, 3, 0.0F);
        this.dorsalfin = new ModelRenderer(this, 14, -1);
        this.dorsalfin.setRotationPoint(0.0F, -2.0F, 1.5F);
        this.dorsalfin.addBox(0.0F, -2.0F, 0.0F, 0, 2, 2, 0.0F);
        this.rightpectoralfin = new ModelRenderer(this, 19, 5);
        this.rightpectoralfin.setRotationPoint(-2.0F, 0.0F, -0.5F);
        this.rightpectoralfin.addBox(-2.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F);
        this.setRotateAngle(rightpectoralfin, 0.0F, 1.2217304763960306F, 0.0F);
        this.leftpectoralfin = new ModelRenderer(this, 19, 5);
        this.leftpectoralfin.mirror = true;
        this.leftpectoralfin.setRotationPoint(2.0F, 0.0F, -0.5F);
        this.leftpectoralfin.addBox(0.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F);
        this.setRotateAngle(leftpectoralfin, 0.0F, -1.2217304763960306F, 0.0F);
        this.analfin = new ModelRenderer(this, 19, -1);
        this.analfin.setRotationPoint(0.0F, 2.0F, 1.5F);
        this.analfin.addBox(0.0F, 0.0F, 0.0F, 0, 2, 2, 0.0F);
        this.nosebump = new ModelRenderer(this, 8, 11);
        this.nosebump.setRotationPoint(0.0F, -1.0F, -2.5F);
        this.nosebump.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 1, 0.0F);
        this.fronthornright = new ModelRenderer(this, 0, 0);
        this.fronthornright.setRotationPoint(-2.0F, -1.5F, -2.5F);
        this.fronthornright.addBox(0.0F, -0.5F, -2.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(fronthornright, 0.0F, 0.3490658503988659F, 0.0F);
        this.backspikeleft = new ModelRenderer(this, 0, -2);
        this.backspikeleft.mirror = true;
        this.backspikeleft.setRotationPoint(2.0F, 1.5F, 2.5F);
        this.backspikeleft.addBox(0.0F, -0.5F, 0.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(backspikeleft, 0.0F, 0.17453292519943295F, 0.0F);
        this.body.addChild(this.fronthornleft);
        this.body.addChild(this.leftpectoralfin);
        this.body.addChild(this.backspikeright);
        this.body.addChild(this.tail);
        this.body.addChild(this.dorsalfin);
        this.body.addChild(this.rightpectoralfin);
        this.body.addChild(this.analfin);
        this.body.addChild(this.nosebump);
        this.body.addChild(this.fronthornright);
        this.body.addChild(this.backspikeleft);
    }

    @Override
    public void setRotationAngles(BoxfishEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        if (!entityIn.isInWater()) {
            f = 1.5F;
        }
        this.tail.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(body);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
