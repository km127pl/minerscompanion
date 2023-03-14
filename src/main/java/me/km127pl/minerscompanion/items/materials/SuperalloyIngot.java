package me.km127pl.minerscompanion.items.materials;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SuperalloyIngot extends Item {
    public SuperalloyIngot() {
        super(new Item.Properties().rarity(Rarity.RARE));
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }
}
