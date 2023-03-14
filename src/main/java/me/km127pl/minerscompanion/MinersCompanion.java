package me.km127pl.minerscompanion;

import me.km127pl.minerscompanion.creative.MinersCompanionTab;
import me.km127pl.minerscompanion.init.BlockInit;
import me.km127pl.minerscompanion.init.ItemInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(MinersCompanion.MODID)
public class MinersCompanion {
    public static final String MODID = "minerscompanion";

    public MinersCompanion() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // register items in the custom tab
        eventBus.addListener(this::addCreative);

        // register blocks
        BlockInit.BLOCKS.register(eventBus);

        // register items
        ItemInit.ITEMS.register(eventBus);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == MinersCompanionTab.MC_TAB || event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemInit.NETHERITE_HAMMER);
            event.accept(ItemInit.DIAMOND_HAMMER);
            event.accept(ItemInit.GOLD_HAMMER);
            event.accept(ItemInit.IRON_HAMMER);
            event.accept(ItemInit.COPPER_HAMMER);
            event.accept(ItemInit.STONE_HAMMER);
        }
        if (event.getTab() == MinersCompanionTab.MC_TAB || event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemInit.SUPERALLOY_INGOT);
            event.accept(ItemInit.SUPERALLOY_DUST);
        }
        if (event.getTab() == MinersCompanionTab.MC_TAB || event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BlockInit.SUPERALLOY_BLOCK);
        }
    }


}
