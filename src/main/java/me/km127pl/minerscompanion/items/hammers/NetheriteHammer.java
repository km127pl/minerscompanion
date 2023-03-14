package me.km127pl.minerscompanion.items.hammers;

import me.km127pl.minerscompanion.items.BaseHammer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class NetheriteHammer extends BaseHammer {

    /**
     * Creates a new hammer
     */
    public NetheriteHammer() {
        super(Tiers.NETHERITE, new Item.Properties().rarity(Rarity.RARE));
    }
}
