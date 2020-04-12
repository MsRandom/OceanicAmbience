package net.msrandom.oceanicambience.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class OAEntities {
    public static final List<EntityType<?>> LIST = new ArrayList<>();
    public static final EntityType<BoxfishEntity> BOXFISH = create("boxfish", BoxfishEntity::new, EntityClassification.WATER_CREATURE, 0.5f, 0.5f);

    private static <T extends Entity> EntityType<T> create(String name, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height) {
        EntityType<T> type = EntityType.Builder.create(factory, classification).size(width, height).build(name);
        type.setRegistryName(name);
        LIST.add(type);
        return type;
    }
}
