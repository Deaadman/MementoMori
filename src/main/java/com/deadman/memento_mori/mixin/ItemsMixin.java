/*
package com.deadman.memento_mori.mixin;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static net.minecraft.item.Items.register;

@Mixin(Items.class)
public class ItemsMixin {

    // Change the rarity of the Totem of Undying to EPIC instead of UNCOMMON.
    @Shadow
    @Final
    public static final Item TOTEM_OF_UNDYING = register(
            "totem_of_undying",
            new Item.Settings().maxCount(1).rarity(Rarity.EPIC).component(DataComponentTypes.DEATH_PROTECTION, DeathProtectionComponent.TOTEM_OF_UNDYING));
}*/
