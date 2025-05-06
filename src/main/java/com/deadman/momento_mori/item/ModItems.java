package com.deadman.momento_mori.item;

import com.deadman.momento_mori.MomentoMori;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final Item TOTEM_CARCASS = register("totem_carcass", Item::new, new Item.Settings().maxCount(1));
    public static final Item UNDYING_CRYSTAL = register("undying_crystal", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));

    public static void Initialise() {}

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {

        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MomentoMori.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}
