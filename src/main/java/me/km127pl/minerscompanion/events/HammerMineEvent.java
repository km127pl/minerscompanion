package me.km127pl.minerscompanion.events;

import me.km127pl.minerscompanion.items.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HammerMineEvent {

    private Level level;
    private Player player;
    private boolean shouldDrop;
    private Item item;

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
//        Block block = event.getState().getBlock();
//        Item inHand = event.getPlayer().getItemInHand(event.getPlayer().getUsedItemHand()).getItem();
        ItemStack inHandStack = event.getPlayer().getItemInHand(event.getPlayer().getUsedItemHand());
        Direction direction = event.getPlayer().getDirection();
        BlockPos pos = event.getPos();
        this.item = inHandStack.getItem();
        this.player = event.getPlayer();
        this.level = event.getPlayer().getLevel();
        this.shouldDrop = !event.getPlayer().isCreative();

        if (inHandStack.is(HammerItem.HAMMER_TAG)) {
            event.getPlayer().sendSystemMessage(Component.literal("X: " + event.getPlayer().getLookAngle().x));
            event.getPlayer().sendSystemMessage(Component.literal("Y: " + event.getPlayer().getLookAngle().y));
            event.getPlayer().sendSystemMessage(Component.literal("Z: " + event.getPlayer().getLookAngle().z));
            event.getPlayer().sendSystemMessage(Component.literal("D: " + direction));

            // check if player is looking down or up
            if (this.player.getLookAngle().y > 0.70 || this.player.getLookAngle().y < -0.70) { // player is looking up
                destroyBlock(pos.south());
                destroyBlock(pos.south().west());
                destroyBlock(pos.south().east());
                destroyBlock(pos.north());
                destroyBlock(pos.north().east());
                destroyBlock(pos.north().west());
                destroyBlock(pos.east());
                destroyBlock(pos.west());
            } else if (direction == Direction.EAST || direction == Direction.WEST) {
                destroyBlock(pos.above());
                destroyBlock(pos.below());

                destroyBlock(pos.north());
                destroyBlock(pos.north().above());
                destroyBlock(pos.north().below());

                destroyBlock(pos.south());
                destroyBlock(pos.south().above());
                destroyBlock(pos.south().below());
            } else if (direction == Direction.SOUTH || direction == Direction.NORTH) {
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
                    event.getPlayer().sendSystemMessage(Component.literal("Hammer broken! " + this.player.getName()));
                    event.getPlayer().sendSystemMessage(Component.literal("DMG " + damage));
                    event.getPlayer().sendSystemMessage(Component.literal("DMG MAX " + inHandStack.getMaxDamage()));
                }
                inHandStack.setDamageValue(damage + 8);
            }
        }

    }

    private void destroyBlock(BlockPos blockPos) {
        // make the hammer only break blocks if its allowed to (for example, so it doesn't break bedrock)
        if (this.item.isCorrectToolForDrops(this.level.getBlockState(blockPos))) {
            this.level.destroyBlock(blockPos, this.shouldDrop, this.player);
        }
    }

}
