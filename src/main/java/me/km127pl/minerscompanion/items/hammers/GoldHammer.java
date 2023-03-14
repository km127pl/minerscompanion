package me.km127pl.minerscompanion.items.hammers;

import me.km127pl.minerscompanion.items.BaseHammer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;

public class GoldHammer extends BaseHammer {

    /**
     * Creates a new hammer
     */
    public GoldHammer() {
        super(Tiers.GOLD, new Item.Properties().rarity(Rarity.COMMON));
    }
}
