package me.km127pl.minerscompanion.items;

import me.km127pl.minerscompanion.MinersCompanion;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HammerItem extends PickaxeItem {
    public static final TagKey<Item> HAMMER_TAG = ItemTags.create(new ResourceLocation(MinersCompanion.MODID, "hammer"));
    private Level level;
    private boolean shouldDrop;
    private Item item;
    private Player player;

    public HammerItem(Tier itemTier, Item.Properties itemProperties) {
        super(itemTier, 0, 0f, itemProperties);
    }

    // Yes, this is the BlockMine event, I have no idea why it's named this way.
    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        if (!(livingEntity instanceof Player player)) return false;

        ItemStack inHandStack = player.getItemInHand(player.getUsedItemHand());
        Direction direction = player.getDirection();

        this.player = player;
        this.level = level;
        this.item = inHandStack.getItem();
        this.shouldDrop = !player.isCreative();

        if (inHandStack.is(HammerItem.HAMMER_TAG)) {

            //TODO: This probably can be done much better
            if (player.getLookAngle().y > 0.70 || player.getLookAngle().y < -0.70) { // player is looking up/down
                destroyBlock(blockPos.south());
                destroyBlock(blockPos.south().west());
                destroyBlock(blockPos.south().east());
                destroyBlock(blockPos.north());
                destroyBlock(blockPos.north().east());
                destroyBlock(blockPos.north().west());
                destroyBlock(blockPos.east());
                destroyBlock(blockPos.west());
            } else if (direction == Direction.EAST || direction == Direction.WEST) { // player is looking straight east/west
                destroyBlock(blockPos.above());
                destroyBlock(blockPos.below());

                destroyBlock(blockPos.north());
                destroyBlock(blockPos.north().above());
                destroyBlock(blockPos.north().below());

                destroyBlock(blockPos.south());
                destroyBlock(blockPos.south().above());
                destroyBlock(blockPos.south().below());
            } else if (direction == Direction.SOUTH || direction == Direction.NORTH) { // player is looking straight south/north
                destroyBlock(blockPos.above());
                destroyBlock(blockPos.below());

                destroyBlock(blockPos.east());
                destroyBlock(blockPos.east().above());
                destroyBlock(blockPos.east().below());

                destroyBlock(blockPos.west());
                destroyBlock(blockPos.west().above());
                destroyBlock(blockPos.west().below());
            }

            // don't damage the hammer if the player is in creative mode
            if (this.shouldDrop) {
                int damage = inHandStack.getDamageValue();
                if (damage - 8 > inHandStack.getMaxDamage()) { // item should be destroyed
                    player.getInventory().clearOrCountMatchingItems((i) -> i.equals(inHandStack), 1, player.getInventory());
                }
                inHandStack.setDamageValue(damage + 8);
            }
        }

        return false; // should cancel block break event
    }

    //TODO:Destroy the block using the hammer itself, so fortune enchantments work
    //TODO:This should be replaced by a function in the hammer itself (possibly overriding an onBreak method of sorts)
    private boolean destroyBlock(BlockPos blockPos) {
        // make the hammer only break blocks if it's allowed to (for example, so it doesn't break bedrock)
        if (this.item.isCorrectToolForDrops(this.level.getBlockState(blockPos))) {
            this.level.destroyBlock(blockPos, this.shouldDrop, this.player);
            return true;
        }

        return false;
    }
}
