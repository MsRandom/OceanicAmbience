package net.msrandom.oceanicambience.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class SwellSharkEntity extends AbstractFishEntity {
    private static final DataParameter<Boolean> PUFFED = EntityDataManager.createKey(SwellSharkEntity.class, DataSerializers.BOOLEAN);
    private int puffTimer;
    private int deflateTimer;
    private static final Predicate<LivingEntity> ENEMY_MATCHER = entity -> entity != null && (!(entity instanceof PlayerEntity) || !entity.isSpectator() && !((PlayerEntity) entity).isCreative()) && entity.getCreatureAttribute() != CreatureAttribute.WATER;

    public SwellSharkEntity(EntityType<? extends SwellSharkEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(PUFFED, false);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new PuffGoal(this));
    }

    public boolean isPuffed() {
        return this.dataManager.get(PUFFED);
    }

    public void setPuffed(boolean puffed) {
        this.dataManager.set(PUFFED, puffed);
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        if (key.equals(PUFFED)) {
            this.recalculateSize();
        }

        super.notifyDataManagerChange(key);
    }

    public void tick() {
        if (!this.world.isRemote && this.isAlive() && this.isServerWorld()) {
            if (this.puffTimer > 0) {
                if (!isPuffed() && this.puffTimer > 40) {
                    this.playSound(SoundEvents.ENTITY_PUFFER_FISH_BLOW_UP, this.getSoundVolume(), this.getSoundPitch());
                    this.setPuffed(true);
                }

                ++this.puffTimer;
            } else if (isPuffed()) {
                if (this.deflateTimer > 100) {
                    this.playSound(SoundEvents.ENTITY_PUFFER_FISH_BLOW_OUT, this.getSoundVolume(), this.getSoundPitch());
                    this.setPuffed(false);
                }

                ++this.deflateTimer;
            }
        }

        super.tick();
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("Puffed", this.isPuffed());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setPuffed(compound.getBoolean("Puffed"));
    }

    @Override
    protected ItemStack getFishBucket() {
        return ItemStack.EMPTY;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_TROPICAL_FISH_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_TROPICAL_FISH_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_TROPICAL_FISH_HURT;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_TROPICAL_FISH_FLOP;
    }

    public EntitySize getSize(Pose poseIn) {
        return super.getSize(poseIn).scale(isPuffed() ? 1 : 0.5f);
    }

    @Override
    protected boolean processInteract(PlayerEntity player, Hand hand) {
        return false;
    }

    static class PuffGoal extends Goal {
        private final SwellSharkEntity shark;

        public PuffGoal(SwellSharkEntity shark) {
            this.shark = shark;
        }

        public boolean shouldExecute() {
            List<LivingEntity> list = this.shark.world.getEntitiesWithinAABB(LivingEntity.class, this.shark.getBoundingBox().grow(8.0D), ENEMY_MATCHER);
            return !list.isEmpty();
        }

        public void startExecuting() {
            this.shark.puffTimer = 1;
            this.shark.deflateTimer = 0;
        }

        public void resetTask() {
            this.shark.puffTimer = 0;
        }

        public boolean shouldContinueExecuting() {
            List<LivingEntity> list = this.shark.world.getEntitiesWithinAABB(LivingEntity.class, this.shark.getBoundingBox().grow(8.0D), ENEMY_MATCHER);
            return !list.isEmpty();
        }
    }
}
