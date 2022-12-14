package me.soda.gnome.mixin;

import meteordevelopment.meteorclient.systems.modules.Modules;
import net.greemdev.meteor.modules.IgnoreWorldBorder;
import net.minecraft.world.border.WorldBorder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldBorder.class)
public abstract class WorldBorderMixin {

    @Inject(method = "canCollide", at = @At("HEAD"), cancellable = true)
    private void onCanCollide(CallbackInfoReturnable<Boolean> info) {
        if (Modules.get().isActive(IgnoreWorldBorder.class)) info.setReturnValue(false);
    }

    @Inject(method = "contains(Lnet/minecraft/util/math/BlockPos;)Z", at = @At("HEAD"), cancellable = true)
    private void onContains(CallbackInfoReturnable<Boolean> info) {
        if (Modules.get().isActive(IgnoreWorldBorder.class)) info.setReturnValue(true);
    }

}
