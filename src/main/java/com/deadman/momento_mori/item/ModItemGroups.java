package com.deadman.momento_mori.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class ModItemGroups {

    public static void Initialise() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.addAfter(Items.PHANTOM_MEMBRANE, ModItems.TOTEM_CARCASS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.addAfter(ModItems.TOTEM_CARCASS, ModItems.UNDYING_CRYSTAL));
    }
}