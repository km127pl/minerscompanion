package me.km127pl.minerscompanion.init;

import me.km127pl.minerscompanion.MinersCompanion;
import me.km127pl.minerscompanion.items.hammers.*;
import me.km127pl.minerscompanion.items.materials.SuperalloyDust;
import me.km127pl.minerscompanion.items.materials.SuperalloyIngot;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinersCompanion.MODID);

    // HAMMERS
    public static final RegistryObject<SuperalloyHammer> SUPERALLOY_HAMMER = ITEMS.register("superalloy_hammer", SuperalloyHammer::new);
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

    // MATERIALS

    public static final RegistryObject<Item> SUPERALLOY_INGOT = ITEMS.register("superalloy_ingot", SuperalloyIngot::new);
    public static final RegistryObject<Item> SUPERALLOY_DUST = ITEMS.register("superalloy_dust", SuperalloyDust::new);
}
