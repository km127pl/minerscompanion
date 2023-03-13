package me.km127pl.minerscompanion.creative;

import me.km127pl.minerscompanion.MinersCompanion;
import me.km127pl.minerscompanion.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MinersCompanion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MinersCompanionTab {
    public static CreativeModeTab MC_TAB;

    @SubscribeEvent
    public static void registerTabs(CreativeModeTabEvent.Register event) {
        MC_TAB = event.registerCreativeModeTab(new ResourceLocation(
                        MinersCompanion.MODID,
                        "mc_tab"
                ),
                builder -> builder.icon(
                        () -> new ItemStack(ItemInit.DIAMOND_HAMMER.get())
                ).title(Component.translatable("creativemodetab.mc_tab")));
    }
}
