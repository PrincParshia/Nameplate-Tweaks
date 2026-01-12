package princ.nameplatetweaks.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.feature.NameTagFeatureRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static princ.nameplatetweaks.client.NameplateTweaks.config;

@Mixin(NameTagFeatureRenderer.class)
@Environment(EnvType.CLIENT)
public class NameTagFeatureRendererMixin {
    @ModifyArg(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)V"
            ),
            index = 4
    )
    public boolean modifyDrawShadow(boolean bl) {
        if (config.nameplateShadow) {
            return true;
        }
        return bl;
    }

    @ModifyArg(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/Font;drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)V"
            ),
            index = 7
    )
    public Font.DisplayMode modifyFontDisplayMode(Font.DisplayMode displayMode) {
        if (config.nameplatePhysics) {
            return Font.DisplayMode.NORMAL;
        }
        return displayMode;
    }
}
