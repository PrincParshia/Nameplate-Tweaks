package princ.nameplatetweaks.client;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import net.fabricmc.api.ClientModInitializer;
import princ.nameplatetweaks.config.client.NameplateTweaksConfig;

public class NameplateTweaks implements ClientModInitializer {
    public static final String NAMESPACE = "nameplate-tweaks";
    public static final String GENERIC_CONFIG_TRANSLATION_PREFIX = "config." + NAMESPACE;
    public static final NameplateTweaksConfig config = ConfigApiJava.registerAndLoadConfig(NameplateTweaksConfig::new, RegisterType.CLIENT);

	@Override
	public void onInitializeClient() {
	}
}