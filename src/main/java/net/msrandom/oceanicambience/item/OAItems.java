package net.msrandom.oceanicambience.item;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.msrandom.oceanicambience.OceanicAmbience;
import net.msrandom.oceanicambience.entity.OAEntities;

import java.util.ArrayList;
import java.util.List;

public class OAItems {
    static final ItemGroup GROUP = new ItemGroup(OceanicAmbience.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BOXFISH_BUCKET);
        }
    };

    public static final List<Item> LIST = new ArrayList<>();
    public static final Item BOXFISH_BUCKET = add("boxfish_bucket", new FishBucketItem(() -> OAEntities.BOXFISH, () -> Fluids.WATER, makeProperties()));
    public static final Item BOXFISH = add("boxfish", new Item(makeProperties().food(OAFoods.BOXFISH)));

    private static <T extends Item> T add(String name, T item) {
        LIST.add(item.setRegistryName(name));
        return item;
    }

    public static Item.Properties makeProperties() {
        return new Item.Properties().group(GROUP);
    }
}
