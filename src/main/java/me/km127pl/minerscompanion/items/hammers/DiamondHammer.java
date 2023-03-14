package me.km127pl.minerscompanion.items.hammers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;

public class DiamondHammer extends BaseHammer {

    /**
     * Creates a new hammer
     */
    public DiamondHammer() {
        super(Tiers.DIAMOND, new Item.Properties().rarity(Rarity.UNCOMMON));
    }
}
