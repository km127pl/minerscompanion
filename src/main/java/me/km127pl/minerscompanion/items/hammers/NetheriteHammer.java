package me.km127pl.minerscompanion.items.hammers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;

public class NetheriteHammer extends BaseHammer {

    /**
     * Creates a new hammer
     */
    public NetheriteHammer() {
        super(Tiers.NETHERITE, new Item.Properties().rarity(Rarity.RARE));
    }
}
