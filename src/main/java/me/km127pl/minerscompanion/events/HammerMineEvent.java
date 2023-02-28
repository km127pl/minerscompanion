package me.km127pl.minerscompanion.events;

import me.km127pl.minerscompanion.items.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HammerMineEvent {

    private Level level;
    private Player player;
    private boolean shouldDrop;
    private Item item;
    private ItemStack itemStack;

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        this.player = event.getPlayer();
        ItemStack inHandStack = this.player.getItemInHand(this.player.getUsedItemHand());
        Direction direction =this.player.getDirection();
        BlockPos pos = event.getPos();

        this.item = inHandStack.getItem();
        this.level = this.player.getLevel();
        this.shouldDrop = !this.player.isCreative();
        this.itemStack = inHandStack;

        if (inHandStack.is(HammerItem.HAMMER_TAG)) {

            //TODO: This probably can be done much better
            if (this.player.getLookAngle().y > 0.70 || this.player.getLookAngle().y < -0.70) { // player is looking up/down
                destroyBlock(pos.south());
                destroyBlock(pos.south().west());
                destroyBlock(pos.south().east());
                destroyBlock(pos.north());
                destroyBlock(pos.north().east());
                destroyBlock(pos.north().west());
                destroyBlock(pos.east());
                destroyBlock(pos.west());
            } else if (direction == Direction.EAST || direction == Direction.WEST) { // player is looking straight east/west
                destroyBlock(pos.above());
                destroyBlock(pos.below());

                destroyBlock(pos.north());
                destroyBlock(pos.north().above());
                destroyBlock(pos.north().below());

                destroyBlock(pos.south());
                destroyBlock(pos.south().above());
                destroyBlock(pos.south().below());
            } else if (direction == Direction.SOUTH || direction == Direction.NORTH) { // player is looking straight south/north
                destroyBlock(pos.above());
                destroyBlock(pos.below());

                destroyBlock(pos.east());
                destroyBlock(pos.east().above());
                destroyBlock(pos.east().below());

                destroyBlock(pos.west());
                destroyBlock(pos.west().above());
                destroyBlock(pos.west().below());
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
