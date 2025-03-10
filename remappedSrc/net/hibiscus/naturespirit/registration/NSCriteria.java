package net.hibiscus.naturespirit.registration;

import net.fabricmc.fabric.mixin.object.builder.CriteriaAccessor;
import net.hibiscus.naturespirit.NatureSpirit;
import net.hibiscus.naturespirit.advancements.CoconutHitCriterion;

public class NSCriteria {

  public static final CoconutHitCriterion COCONUT_HIT_CRITERION = CriteriaAccessor.callRegister(new CoconutHitCriterion());

  public static void registerCriteria() {}
  }