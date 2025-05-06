package com.deadman.memento_mori.mixin;

import com.deadman.memento_mori.MementoMori;
import com.deadman.memento_mori.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.ForgingSlotsManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {

    private final Property levelCost = Property.create();
    private int MoreThanOneCrystal = 0;

    public AnvilScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, ForgingSlotsManager forgingSlotsManager) {
        super(type, syncId, playerInventory, context, forgingSlotsManager);
    }

    @Inject(at = @At("RETURN"), method = "updateResult")
    public void updateResult(CallbackInfo ci) {
        ItemStack itemStack = this.input.getStack(0);
        ItemStack itemStack2 = this.input.getStack(1);

        // TODO: Disable renaming if this combo is put into the furnace.
        if (itemStack.getItem() == ModItems.TOTEM_CARCASS && itemStack2.getItem() == ModItems.UNDYING_CRYSTAL) {
            this.output.setStack(0, Items.TOTEM_OF_UNDYING.getDefaultStack());
            this.levelCost.set(30);

            if (itemStack2.getCount() > 1) {
                MoreThanOneCrystal = itemStack2.getCount();
            }
        }
    }

    @Inject(at = @At("RETURN"), method = "onTakeOutput")
    public void onTakeOutput(PlayerEntity player, ItemStack stack, CallbackInfo ci) {
        ItemStack itemStack = this.input.getStack(1);

        MementoMori.LOGGER.info(itemStack.getItem().toString());
        MementoMori.LOGGER.info(stack.getItem().toString());

        if (MoreThanOneCrystal > 1) {
            MoreThanOneCrystal = MoreThanOneCrystal - 1;

            ItemStack itemStack2 = ModItems.UNDYING_CRYSTAL.getDefaultStack();
            itemStack2.setCount(MoreThanOneCrystal);

            this.input.setStack(1, itemStack2);
        }
    }
}