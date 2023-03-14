package me.km127pl.minerscompanion.items;

import me.km127pl.minerscompanion.MinersCompanion;
import me.km127pl.minerscompanion.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class MCTiers {

    public static Tier COPPER;
    public static Tier SUPERALLOY;

    static {
        COPPER = TierSortingRegistry.registerTier(
                new ForgeTier(1, 181, 4.5F, 1.0F, 5, null,
                        () -> Ingredient.of(Items.COPPER_INGOT.asItem())),
                new ResourceLocation(MinersCompanion.MODID, "copper"), List.of(Tiers.STONE), List.of()
        );

        SUPERALLOY = TierSortingRegistry.registerTier(
                new ForgeTier(5, 3200, 9.5F, 5.0F, 17, null,
                        () -> Ingredient.of(ItemInit.SUPERALLOY_INGOT.get())),
                new ResourceLocation(MinersCompanion.MODID, "superalloy"), List.of(Tiers.NETHERITE), List.of()
        );
    }
}
