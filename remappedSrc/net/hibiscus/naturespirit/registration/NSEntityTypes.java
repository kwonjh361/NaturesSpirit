package net.hibiscus.naturespirit.registration;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.hibiscus.naturespirit.entity.CheeseArrowEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import static net.hibiscus.naturespirit.NatureSpirit.MOD_ID;

public class NSEntityTypes {

  private static final FabricEntityTypeBuilder<CheeseArrowEntity> CHEESE_ARROW_ENTITY_BUILDER = FabricEntityTypeBuilder.create(MobCategory.MISC).entityFactory(CheeseArrowEntity::new);
  public static final EntityType<CheeseArrowEntity> CHEESE_ARROW = registerEntityType("cheese_arrow", CHEESE_ARROW_ENTITY_BUILDER.dimensions(EntityDimensions.scalable(0.5F, 0.5F)).trackRangeChunks(4).trackedUpdateRate(20).build());


  public static void registerEntityTypes() {}
  public static <T extends EntityType<?>> T registerEntityType(String id, T type) {
    return Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(MOD_ID, id), type);
  }

}
