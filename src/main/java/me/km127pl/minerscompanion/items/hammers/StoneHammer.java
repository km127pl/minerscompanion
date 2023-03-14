package me.km127pl.minerscompanion.items.hammers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;

public class StoneHammer extends BaseHammer {

    /**
     * Creates a new hammer
     */
    public StoneHammer() {
        super(Tiers.STONE, new Item.Properties().rarity(Rarity.COMMON));
    }
}
