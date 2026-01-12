package princ.nameplatetweaks.config.client;

import me.fzzyhmstrs.fzzy_config.annotations.Translation;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigGroup;
import me.fzzyhmstrs.fzzy_config.validation.collection.ValidatedList;
import me.fzzyhmstrs.fzzy_config.validation.minecraft.ValidatedRegistryType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;

import java.util.List;

import static princ.nameplatetweaks.client.NameplateTweaks.GENERIC_CONFIG_TRANSLATION_PREFIX;
import static princ.nameplatetweaks.client.NameplateTweaks.NAMESPACE;

@Translation( prefix = GENERIC_CONFIG_TRANSLATION_PREFIX )
public class NameplateTweaksConfig extends Config {
    public NameplateTweaksConfig() {
        super(Identifier.fromNamespaceAndPath(NAMESPACE, "general"), "", "", NAMESPACE);
    }

    public boolean nameplateShadow = true;
    public boolean nameplatePhysics = true;
    public boolean selfNameplate = true;
    public boolean alwaysShowNamedEntitiesNameplate = false;
    public ConfigGroup livingEntitiesNameplate = new ConfigGroup("livingEntitiesNameplate");
    public boolean lenEnabled = false;
    public ValidatedList<EntityType<?>> lenFilter = ValidatedRegistryType.of(BuiltInRegistries.ENTITY_TYPE).toList(List.of());
}
