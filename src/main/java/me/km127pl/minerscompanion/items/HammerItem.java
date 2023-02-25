package me.km127pl.minerscompanion.items;

import me.km127pl.minerscompanion.MinersCompanion;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class HammerItem extends DiggerItem {
    public static final TagKey<Item> HAMMER_TAG = ItemTags.create(new ResourceLocation(MinersCompanion.MODID, "hammer"));

    public HammerItem(Tier itemTier, Item.Properties itemProperties) {
        super(0, -3f, itemTier, BlockTags.MINEABLE_WITH_PICKAXE, itemProperties);
    }

}
