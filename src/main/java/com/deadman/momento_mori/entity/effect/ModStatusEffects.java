package com.deadman.momento_mori.entity.effect;

import com.deadman.momento_mori.MomentoMori;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {

    public static final RegistryEntry<StatusEffect> MEMENTO_VIVERE = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MomentoMori.MOD_ID, "memento_vivere"), new MementoVivereStatusEffect(StatusEffectCategory.NEUTRAL, 0xffffff));

    public static void Initialise() {}
}