package princ.nameplatetweaks.client.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static princ.nameplatetweaks.client.NameplateTweaks.*;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject( method = "shouldShowName", at = @At("RETURN"), cancellable = true )
    public void shouldShowName(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        LivingEntity entity = (LivingEntity) (Object) this;
        EntityType<?> entityType = entity.getType();

        if (entity instanceof Player) return;

        if (config.alwaysShowNamedEntitiesNameplate && entity.hasCustomName()) {
            callbackInfoReturnable.setReturnValue(true);
        }

        if (config.lenEnabled) {
            if (config.lenFilter.isEmpty()) {
                callbackInfoReturnable.setReturnValue(true);
                return;
            }

            if (config.lenFilter.contains(entityType)) {
                callbackInfoReturnable.setReturnValue(true);
            }
        }
    }
}