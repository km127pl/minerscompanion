package me.km127pl.minerscompanion.items;

import me.km127pl.minerscompanion.MinersCompanion;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class HammerItem extends DiggerItem {
    public static final TagKey<Item> HAMMER_TAG = ItemTags.create(new ResourceLocation(MinersCompanion.MODID, "hammer"));

    public HammerItem(Tier itemTier, Item.Properties itemProperties) {
        super(0, -3f, itemTier, BlockTags.MINEABLE_WITH_PICKAXE, itemProperties);
    }

}
