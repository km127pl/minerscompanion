package me.km127pl.minerscompanion.init;

import me.km127pl.minerscompanion.MinersCompanion;
import me.km127pl.minerscompanion.items.HammerItem;
import me.km127pl.minerscompanion.items.MCTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    // TODO:Move the hammers to their own respective classes
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinersCompanion.MODID);

    public static final RegistryObject<HammerItem> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", () ->
            new HammerItem(Tiers.NETHERITE, new Item.Properties().rarity(Rarity.RARE))
    );

    public static final RegistryObject<HammerItem> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () ->
            new HammerItem(Tiers.DIAMOND, new Item.Properties().rarity(Rarity.UNCOMMON))
    );

    public static final RegistryObject<HammerItem> GOLD_HAMMER = ITEMS.register("gold_hammer", () ->
            new HammerItem(Tiers.GOLD, new Item.Properties().rarity(Rarity.COMMON))
    );

    public static final RegistryObject<HammerItem> IRON_HAMMER = ITEMS.register("iron_hammer", () ->
            new HammerItem(Tiers.IRON, new Item.Properties().rarity(Rarity.COMMON))
    );

    public static final RegistryObject<HammerItem> COPPER_HAMMER = ITEMS.register("copper_hammer", () ->
            new HammerItem(MCTiers.COPPER, new Item.Properties().rarity(Rarity.COMMON))
    );

    public static final RegistryObject<HammerItem> STONE_HAMMER = ITEMS.register("stone_hammer", () ->
            new HammerItem(Tiers.STONE, new Item.Properties().rarity(Rarity.COMMON))
    );
}
