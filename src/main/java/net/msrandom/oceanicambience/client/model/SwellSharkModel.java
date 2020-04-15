package net.msrandom.oceanicambience.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.msrandom.oceanicambience.entity.SwellSharkEntity;

public class SwellSharkModel extends SegmentedModel<SwellSharkEntity> {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer dorsalfin1;
    public ModelRenderer frontfinright;
    public ModelRenderer frontfinleft;
    public ModelRenderer backfinleft;
    public ModelRenderer backfinright;
    public ModelRenderer body2;
    public ModelRenderer bodyinflated;
    public ModelRenderer tail;
    public ModelRenderer dorsalfin2;
    public ModelRenderer tailfin1;
    public ModelRenderer tailfin2;
    public ModelRenderer dorsalfininflated;

    public SwellSharkModel() {
        this.textureWidth = 94;
        this.textureHeight = 42;
        this.dorsalfin1 = new ModelRenderer(this, 24, 0);
        this.dorsalfin1.setRotationPoint(0.0F, -0.9F, 2.0F);
        this.dorsalfin1.addBox(-0.5F, -4.0F, -2.0F, 1, 4, 4, 0.0F);
        this.setRotateAngle(dorsalfin1, -0.9217083779782055F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 19);
        this.head.setRotationPoint(0.0F, 0.0F, -6.5F);
        this.head.addBox(-2.5F, -2.5F, -4.0F, 5, 5, 4, 0.0F);
        this.tailfin2 = new ModelRenderer(this, 50, 19);
        this.tailfin2.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.tailfin2.addBox(0.0F, -1.0F, 0.0F, 0, 3, 3, 0.0F);
        this.backfinright = new ModelRenderer(this, 35, 0);
        this.backfinright.setRotationPoint(-2.0F, 2.0F, 5.0F);
        this.backfinright.addBox(-2.0F, -0.5F, -0.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(backfinright, 0.0F, 0.0F, -0.6375687757535285F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.body.addBox(-2.5F, -2.5F, -6.5F, 5, 5, 13, 0.0F);
        this.tailfin1 = new ModelRenderer(this, 51, 20);
        this.tailfin1.setRotationPoint(0.0F, 1.0F, 3.0F);
        this.tailfin1.addBox(0.0F, 0.0F, -3.0F, 0, 2, 6, 0.0F);
        this.frontfinleft = new ModelRenderer(this, 69, 6);
        this.frontfinleft.setRotationPoint(2.0F, 2.0F, -4.5F);
        this.frontfinleft.addBox(0.0F, -0.5F, -0.5F, 5, 1, 4, 0.0F);
        this.setRotateAngle(frontfinleft, 0.0F, -0.18064157758141308F, 0.34574972482007665F);
        this.bodyinflated = new ModelRenderer(this, 37, 0);
        this.bodyinflated.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.bodyinflated.addBox(-4.5F, -4.0F, -6.5F, 9, 8, 13, 0.0F);
        this.frontfinright = new ModelRenderer(this, 69, 0);
        this.frontfinright.setRotationPoint(-2.0F, 2.0F, -4.5F);
        this.frontfinright.addBox(-5.0F, -0.5F, -0.5F, 5, 1, 4, 0.0F);
        this.setRotateAngle(frontfinright, 0.0F, 0.18064157758141308F, -0.34574972482007665F);
        this.body2 = new ModelRenderer(this, 20, 19);
        this.body2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.body2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
        this.tail = new ModelRenderer(this, 38, 23);
        this.tail.setRotationPoint(0.0F, -0.5F, 5.5F);
        this.tail.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 7, 0.0F);
        this.setRotateAngle(tail, 0.3466223894460738F, 0.0F, 0.0F);
        this.dorsalfin2 = new ModelRenderer(this, 0, 0);
        this.dorsalfin2.setRotationPoint(0.0F, -0.5F, 3.5F);
        this.dorsalfin2.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(dorsalfin2, -0.7740535232594852F, 0.0F, 0.0F);
        this.backfinleft = new ModelRenderer(this, 35, 5);
        this.backfinleft.setRotationPoint(2.0F, 2.0F, 5.0F);
        this.backfinleft.addBox(0.0F, -0.5F, -0.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(backfinleft, 0.0F, 0.0F, 0.6375687757535285F);
        this.dorsalfininflated = new ModelRenderer(this, 2, 4);
        this.dorsalfininflated.setRotationPoint(0.0F, -2.4F, 2.0F);
        this.dorsalfininflated.addBox(-0.5F, -4.0F, -2.0F, 1, 4, 4, 0.0F);
        this.setRotateAngle(dorsalfininflated, -0.9217083779782055F, 0.0F, 0.0F);
        this.body.addChild(this.dorsalfin1);
        this.body.addChild(this.head);
        this.tail.addChild(this.tailfin2);
        this.body.addChild(this.backfinright);
        this.tail.addChild(this.tailfin1);
        this.body.addChild(this.frontfinleft);
        this.body.addChild(this.bodyinflated);
        this.body.addChild(this.frontfinright);
        this.body.addChild(this.body2);
        this.body2.addChild(this.tail);
        this.body2.addChild(this.dorsalfin2);
        this.body.addChild(this.backfinleft);
        this.bodyinflated.addChild(this.dorsalfininflated);
    }

    @Override
    public void setRotationAngles(SwellSharkEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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
