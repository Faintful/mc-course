package net.faintful.mccourse.item.custom;

import net.faintful.mccourse.item.ModItems;
import net.faintful.mccourse.sound.ModSounds;
import net.faintful.mccourse.util.InventoryUtil;
import net.faintful.mccourse.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItem extends Item {

    public DowsingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("item.mccourse.dowsing_rod.tooltip.shift"));
        } else {
            tooltip.add(new TranslatableText("item.mccourse.dowsing_rod.tooltip"));
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for (int i = 0; i <= positionClicked.getY(); i++) {
                BlockState stateBelow = context.getWorld().getBlockState(positionClicked.down(i));
                Block blockBelow = stateBelow.getBlock();

                if (isValuableBlock(stateBelow)) {
                    outputValuableCoordinates(positionClicked.add(0, -i, 0), player, blockBelow);
                    foundBlock = true;
                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET)) {
                        addNbtToDataTablet(player, positionClicked.add(0, -i, 0), blockBelow);
                    }
                    context.getWorld().playSound(player, positionClicked, ModSounds.DOWSING_ROD_FOUND_ORE, SoundCategory.BLOCKS, 1f, 1f);
                    break;
                }
            }
            if (!foundBlock) {
                player.sendMessage(new TranslatableText("item.mccourse.dowsing_rod.no_valuables"), false);
            }
        }
        context.getStack().damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(player.getActiveHand()));
        return super.useOnBlock(context);
    }

    private void addNbtToDataTablet(PlayerEntity player, BlockPos pos, Block blockBelow) {
        ItemStack dataTablet = player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET));
        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("mccourse.last_ore", "Found " + blockBelow.asItem().getName().getString() + " at (" + pos.getX() + ", "+ pos.getY() + ", "+ pos.getZ() + ")");
        dataTablet.setNbt(nbtData);
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(new LiteralText("Found " + blockBelow.asItem().getName().getString() + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false );
    }

    private boolean isValuableBlock(BlockState block) {
        return block.isIn(ModTags.Blocks.DOWSING_ROD_DETECTABLE_BLOCKS);
        //return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE;
    }
}
