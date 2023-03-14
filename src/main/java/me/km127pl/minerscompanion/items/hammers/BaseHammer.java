package me.km127pl.minerscompanion.items.hammers;

import me.km127pl.minerscompanion.MinersCompanion;
import me.km127pl.minerscompanion.items.hammers.NetheriteHammer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BaseHammer extends DiggerItem {
    public static final TagKey<Item> HAMMER_TAG = ItemTags.create(new ResourceLocation(MinersCompanion.MODID, "hammer"));

    // runtime variables
    private ItemStack itemStack;
    private Level level;
    private BlockState blockState;
    private Player player;

    /**
     * Creates a new hammer
     * @param itemTier the tier of the hammer
     * @param itemProperties the properties of the hammer
     */
    public BaseHammer(Tier itemTier, Item.Properties itemProperties) {
        super(0, -3f, itemTier, BlockTags.MINEABLE_WITH_PICKAXE, itemProperties);
    }

    /**
     * Called when a hammer breaks a block
     * @param itemStack     the item stack of the hammer
     * @param level         the level where the player is
     * @param blockState    the state of the block
     * @param blockPos      the position of the block
     * @param entity        the player
     * @return              if the event was cancelled
     */
    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity entity) {
        if (!level.isClientSide && blockState.getDestroySpeed(level, blockPos) != 0.0F) {
            this.itemStack = itemStack;
            this.level = level;
            this.blockState = blockState;
            this.player = (Player) entity;

            mine3DBlock(blockPos);
            itemStack.hurtAndBreak(1, entity, (livingEntity) -> {
                livingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
        return false;
    }

    /**
     * Called when a hammer breaks a block
     * @param blockPos      the position of the block
     * @return              0 if the event was cancelled
     */
    public int mineBlock(BlockPos blockPos) {
//        return mineBlock(itemStack, level, blockState, blockPos, player);
        if (this.level.getBlockState(blockPos).isAir()) return 0;
        if (!this.itemStack.isCorrectToolForDrops(this.level.getBlockState(blockPos))) return 0;

        this.level.destroyBlock(
                blockPos,
                true
        );

        return 1;
    }

    /**
     * Mines a 3x3 block square
     *
     * @param pos   the position of the block
     */
    private void mine3DBlock(BlockPos pos) {
        Direction direction = player.getDirection();
        int damage = 0;
        if (this.player.getLookAngle().y > 0.70 || this.player.getLookAngle().y < -0.70) { // player is looking up/down
                damage += mineBlock(pos.south());
                damage += mineBlock(pos.south().west());
                damage += mineBlock(pos.south().east());
                damage += mineBlock(pos.north());
                damage += mineBlock(pos.north().east());
                damage += mineBlock(pos.north().west());
                damage += mineBlock(pos.east());
                damage += mineBlock(pos.west());
            } else if (direction == Direction.EAST || direction == Direction.WEST) { // player is looking straight east/west
                damage += mineBlock(pos.above());
                damage += mineBlock(pos.below());

                damage += mineBlock(pos.north());
                damage += mineBlock(pos.north().above());
                damage += mineBlock(pos.north().below());

                damage += mineBlock(pos.south());
                damage += mineBlock(pos.south().above());
                damage += mineBlock(pos.south().below());
            } else if (direction == Direction.SOUTH || direction == Direction.NORTH) { // player is looking straight south/north
               damage +=  mineBlock(pos.above());
               damage +=  mineBlock(pos.below());

               damage +=  mineBlock(pos.east());
               damage +=  mineBlock(pos.east().above());
               damage +=  mineBlock(pos.east().below());

               damage +=  mineBlock(pos.west());
               damage +=  mineBlock(pos.west().above());
               damage +=  mineBlock(pos.west().below());
            }

            // apply damage to players item
            // don't damage the hammer if the player is in creative mode
            // TODO: Account for unbreaking
            if (!this.player.isCreative()) {
                int itemStackDamage = this.itemStack.getDamageValue();
                if (itemStackDamage - damage > itemStack.getMaxDamage()) { // item should be destroyed
                    this.player.getInventory().clearOrCountMatchingItems((i) -> i.equals(itemStack), 1, player.getInventory());
                }
                itemStack.setDamageValue(itemStackDamage + damage);
            }
    }

}
