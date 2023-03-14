package me.km127pl.minerscompanion.items.materials;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SuperalloyDust extends Item {
    public SuperalloyDust() {
        super(new Properties().rarity(Rarity.RARE));
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }
}
