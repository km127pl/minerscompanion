package me.km127pl.minerscompanion.items.hammers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;

public class IronHammer extends BaseHammer {

    /**
     * Creates a new hammer
     */
    public IronHammer() {
        super(Tiers.IRON, new Item.Properties().rarity(Rarity.COMMON));
    }
}
