package me.km127pl.minerscompanion.events;

import me.km127pl.minerscompanion.items.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HammerMineEvent {

    private Level level;
    private Player player;
    private boolean shouldDrop;

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
//        Block block = event.getState().getBlock();
//        Item inHand = event.getPlayer().getItemInHand(event.getPlayer().getUsedItemHand()).getItem();
        ItemStack inHandStack = event.getPlayer().getItemInHand(event.getPlayer().getUsedItemHand());
        Direction direction = event.getPlayer().getDirection();
        BlockPos pos = event.getPos();
        this.player = event.getPlayer();
        this.level = event.getPlayer().getLevel();
        this.shouldDrop = !event.getPlayer().isCreative();

        if (inHandStack.is(HammerItem.HAMMER_TAG)) {
            event.getPlayer().sendSystemMessage(Component.literal("X: " + event.getPlayer().getLookAngle().x));
            event.getPlayer().sendSystemMessage(Component.literal("Y: " + event.getPlayer().getLookAngle().y));
            event.getPlayer().sendSystemMessage(Component.literal("Z: " + event.getPlayer().getLookAngle().z));
            event.getPlayer().sendSystemMessage(Component.literal("D: " + direction));

            if (direction == Direction.EAST || direction == Direction.WEST) { // player is not mining Up or Down
                destroyBlock(pos.above());
                destroyBlock(pos.below());

                destroyBlock(pos.north());
                destroyBlock(pos.north().above());
                destroyBlock(pos.north().below());

                destroyBlock(pos.south());
                destroyBlock(pos.south().above());
                destroyBlock(pos.south().below());

                inHandStack.setDamageValue(inHandStack.getDamageValue() + 8);
            }

            if (direction == Direction.SOUTH || direction == Direction.NORTH) { // player is not mining Up or Down
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
                inHandStack.setDamageValue(damage + 7);
            }
        }

    }

    private void destroyBlock(BlockPos blockPos) {
        this.level.destroyBlock(blockPos, this.shouldDrop, this.player);
    }

}
