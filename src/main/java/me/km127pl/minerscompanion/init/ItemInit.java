package me.km127pl.minerscompanion.init;

import me.km127pl.minerscompanion.MinersCompanion;
import me.km127pl.minerscompanion.items.hammers.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    // TODO:Move the hammers to their own respective classes
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinersCompanion.MODID);

    public static final RegistryObject<NetheriteHammer> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", NetheriteHammer::new);

    public static final RegistryObject<DiamondHammer> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", DiamondHammer::new);

    public static final RegistryObject<GoldHammer> GOLD_HAMMER = ITEMS.register("gold_hammer", GoldHammer::new
    );

    public static final RegistryObject<IronHammer> IRON_HAMMER = ITEMS.register("iron_hammer", IronHammer::new
    );

    public static final RegistryObject<CopperHammer> COPPER_HAMMER = ITEMS.register("copper_hammer", CopperHammer::new
    );

    public static final RegistryObject<StoneHammer> STONE_HAMMER = ITEMS.register("stone_hammer", StoneHammer::new
    );
}
