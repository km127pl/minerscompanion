package me.km127pl.minerscompanion.items.hammers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class SuperalloyHammer extends BaseHammer {

    /*
     * Creates a new hammer
     */
    public SuperalloyHammer() {
        super(Tiers.NETHERITE, new Item.Properties().rarity(Rarity.EPIC));
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }
}
