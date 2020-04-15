package net.msrandom.oceanicambience.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.msrandom.oceanicambience.item.OAItems;

import java.util.ArrayList;
import java.util.List;

public class OAEntities {
    private static final List<Item> EGGS = new ArrayList<>();
    public static final List<EntityType<?>> LIST = new ArrayList<>();
    public static final EntityType<BoxfishEntity> BOXFISH = create("boxfish", BoxfishEntity::new, EntityClassification.WATER_CREATURE, 0.5f, 0.5f, 0xe8f534, 0x42e3e3);
    public static final EntityType<SlenderSunfishEntity> SLENDER_SUNFISH = create("slender_sunfish", SlenderSunfishEntity::new, EntityClassification.WATER_CREATURE, 0.6f, 0.6f, 0x58768a, 0x485a5c);
    public static final EntityType<SwellSharkEntity> SWELL_SHARK = create("swell_shark", SwellSharkEntity::new, EntityClassification.WATER_CREATURE, 0.6f, 0.6f, 0xba793f, 0x422d1a);

    private static <T extends Entity> EntityType<T> create(String name, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height, int primaryEgg, int secondaryEgg) {
        final Item.Properties properties = OAItems.makeProperties();
        EntityType<T> type = EntityType.Builder.create(factory, classification).size(width, height).build(name);
        type.setRegistryName(name);
        LIST.add(type);
        EGGS.add(new SpawnEggItem(type, primaryEgg, secondaryEgg, properties).setRegistryName(name + "_spawn_egg"));
        return type;
    }

    public static void registerEggs() {
        OAItems.LIST.addAll(EGGS);
    }
}
