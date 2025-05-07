package com.deadman.memento_mori.mixin;

import com.deadman.memento_mori.entity.effect.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(at = @At("HEAD"), method = "tryUseDeathProtector", cancellable = true)
    public void tryUseDeathProtector(DamageSource source, CallbackInfoReturnable<Boolean> cir) {

        // This grabs a reference to the class I'm injecting into.
        LivingEntity self = (LivingEntity) (Object) this;

        // If the player has the Memento Vivere status effect, totems will become useless.
        if (self instanceof PlayerEntity playerEntity) {
            if (playerEntity.hasStatusEffect(ModStatusEffects.MEMENTO_VIVERE)) {
                cir.setReturnValue(false);
            }
        }
    }
}
