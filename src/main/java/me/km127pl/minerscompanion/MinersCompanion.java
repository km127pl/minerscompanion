package me.km127pl.minerscompanion;

import me.km127pl.minerscompanion.events.HammerMineEvent;
import me.km127pl.minerscompanion.init.ItemInit;
import me.km127pl.minerscompanion.items.MCTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MinersCompanion.MODID)
public class MinersCompanion {
    public static final String MODID = "minerscompanion";

    public MinersCompanion() {
        // register items
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::addCreative);
        ItemInit.ITEMS.register(eventBus);
        MinecraftForge.EVENT_BUS.register(new HammerMineEvent());

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == MCTab.MC_TAB || event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemInit.DIAMOND_HAMMER);
            event.accept(ItemInit.GOLD_HAMMER);
            event.accept(ItemInit.IRON_HAMMER);
            event.accept(ItemInit.STONE_HAMMER);
        }
    }


}
