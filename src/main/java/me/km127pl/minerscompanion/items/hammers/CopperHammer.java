package me.km127pl.minerscompanion.items.hammers;

import me.km127pl.minerscompanion.items.MCTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CopperHammer extends BaseHammer {

    /**
     * Creates a new hammer
     */
    public CopperHammer() {
        super(MCTiers.COPPER, new Item.Properties().rarity(Rarity.COMMON));
    }
}
