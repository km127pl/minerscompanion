package me.km127pl.minerscompanion.init;

import me.km127pl.minerscompanion.MinersCompanion;
import me.km127pl.minerscompanion.blocks.material.SuperalloyBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MinersCompanion.MODID);

    public static final RegistryObject<Block> SUPERALLOY_BLOCK = registerBlock("superalloy_block", SuperalloyBlock::new);

    public static <T extends Block> RegistryObject<T> registerBlock(String id, Supplier<T> _block) {
        RegistryObject<T> block = BLOCKS.register(id, _block);

        ItemInit.ITEMS.register(id,
                () -> new BlockItem(block.get(), new Item.Properties())
        );
        return block;
    }

}
