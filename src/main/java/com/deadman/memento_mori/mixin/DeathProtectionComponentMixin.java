package com.deadman.memento_mori.mixin;

import com.deadman.memento_mori.entity.effect.ModStatusEffects;
import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DeathProtectionComponent.class)
public class DeathProtectionComponentMixin {

    @Inject(at = @At("RETURN"), method = "applyDeathEffects")
    public void applyDeathEffects(ItemStack stack, LivingEntity entity, CallbackInfo ci) {

        // 5 minutes of Memento Vivere I.
        // 20 ticks per second, so 300 seconds * by 20 is equal to 6000 ticks.
        var instance = new StatusEffectInstance(ModStatusEffects.MEMENTO_VIVERE, 6000);
        entity.addStatusEffect(instance);
    }
}