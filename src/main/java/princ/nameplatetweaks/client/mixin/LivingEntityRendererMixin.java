package princ.nameplatetweaks.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static princ.nameplatetweaks.client.NameplateTweaks.*;

@Mixin(LivingEntityRenderer.class)
@Environment(EnvType.CLIENT)
public class LivingEntityRendererMixin {
    @Inject( method = "shouldShowName", at = @At("RETURN"), cancellable = true )
    public void shouldShowName(LivingEntity livingEntity, double d, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (livingEntity == localPlayer && config.selfNameplate) {
            callbackInfoReturnable.setReturnValue(true);
        }
    }
}
