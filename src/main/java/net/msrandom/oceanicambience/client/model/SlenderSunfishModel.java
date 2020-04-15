package net.msrandom.oceanicambience.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.msrandom.oceanicambience.entity.SlenderSunfishEntity;

public class SlenderSunfishModel extends SegmentedModel<SlenderSunfishEntity> {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer tail;
    public ModelRenderer dorsalfin;
    public ModelRenderer analfin;
    public ModelRenderer pectoralfinright;
    public ModelRenderer pectoralfinleft;

    public SlenderSunfishModel() {
        this.textureWidth = 54;
        this.textureHeight = 33;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 12.5F, 0.0F);
        this.body.addBox(-1.5F, -4.0F, -6.5F, 3, 8, 13, 0.0F);
        this.dorsalfin = new ModelRenderer(this, 0, 22);
        this.dorsalfin.setRotationPoint(0.0F, -3.5F, 5.5F);
        this.dorsalfin.addBox(-0.5F, -8.0F, -1.0F, 1, 8, 2, 0.0F);
        this.pectoralfinleft = new ModelRenderer(this, 0, 3);
        this.pectoralfinleft.setRotationPoint(1.5F, 0.0F, -3.0F);
        this.pectoralfinleft.addBox(0.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.tail = new ModelRenderer(this, 37, 0);
        this.tail.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.tail.addBox(-0.5F, -4.0F, 0.0F, 1, 8, 2, 0.0F);
        this.pectoralfinright = new ModelRenderer(this, 0, 0);
        this.pectoralfinright.setRotationPoint(-1.5F, 0.0F, -3.0F);
        this.pectoralfinright.addBox(-3.0F, 0.0F, -1.0F, 3, 0, 2, 0.0F);
        this.head = new ModelRenderer(this, 20, 0);
        this.head.setRotationPoint(0.0F, -1.0F, -6.5F);
        this.head.addBox(-1.5F, -3.0F, -5.0F, 3, 6, 5, 0.0F);
        this.analfin = new ModelRenderer(this, 7, 22);
        this.analfin.setRotationPoint(0.0F, 3.5F, 5.5F);
        this.analfin.addBox(-0.5F, 0.0F, -1.0F, 1, 8, 2, 0.0F);
        this.body.addChild(this.dorsalfin);
        this.body.addChild(this.pectoralfinleft);
        this.body.addChild(this.tail);
        this.body.addChild(this.pectoralfinright);
        this.body.addChild(this.head);
        this.body.addChild(this.analfin);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(body);
    }

    @Override
    public void setRotationAngles(SlenderSunfishEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}
