package com.deadman.momento_mori.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class MementoVivereStatusEffect extends StatusEffect {

    protected MementoVivereStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // Called when the effect is applied.
    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you experience faster
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }

    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
