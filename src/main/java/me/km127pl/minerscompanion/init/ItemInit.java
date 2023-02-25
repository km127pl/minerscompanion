package me.km127pl.minerscompanion.init;

import me.km127pl.minerscompanion.MinersCompanion;
import me.km127pl.minerscompanion.items.HammerItem;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinersCompanion.MODID);

    public static final RegistryObject<HammerItem> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () ->
            new HammerItem(Tiers.DIAMOND, new Item.Properties().rarity(Rarity.UNCOMMON))
    );

    public static final RegistryObject<HammerItem> GOLD_HAMMER = ITEMS.register("gold_hammer", () ->
            new HammerItem(Tiers.GOLD, new Item.Properties().rarity(Rarity.COMMON))
    );

    public static final RegistryObject<HammerItem> IRON_HAMMER = ITEMS.register("iron_hammer", () ->
            new HammerItem(Tiers.IRON, new Item.Properties().rarity(Rarity.COMMON))
    );

    public static final RegistryObject<HammerItem> STONE_HAMMER = ITEMS.register("stone_hammer", () ->
            new HammerItem(Tiers.STONE, new Item.Properties().rarity(Rarity.COMMON))
    );
}
