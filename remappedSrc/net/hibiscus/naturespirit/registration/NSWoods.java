package net.hibiscus.naturespirit.registration;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.hibiscus.naturespirit.NatureSpirit;
import net.hibiscus.naturespirit.blocks.CoconutBlock;
import net.hibiscus.naturespirit.blocks.OliveBranchBlock;
import net.hibiscus.naturespirit.blocks.SproutingCoconutBlock;
import net.hibiscus.naturespirit.datagen.NSConfiguredFeatures;
import net.hibiscus.naturespirit.items.CoconutHalfItem;
import net.hibiscus.naturespirit.registration.sets.WoodSet;
import net.hibiscus.naturespirit.registration.sets.WoodSet.WoodPreset;
import net.hibiscus.naturespirit.world.tree.*;
import net.minecraft.block.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import java.util.List;
import java.util.Optional;

import static net.hibiscus.naturespirit.NatureSpirit.MOD_ID;
import static net.hibiscus.naturespirit.registration.NSRegistryHelper.*;

public class NSWoods {

  public static final WoodSet REDWOOD = new WoodSet(
      new ResourceLocation(MOD_ID, "redwood"),
      MapColor.TERRACOTTA_BROWN,
      MapColor.COLOR_RED,
      Blocks.CHERRY_LEAVES,
      Blocks.CHERRY_LOG,
      Blocks.BAMBOO_HANGING_SIGN,
      Items.BAMBOO_CHEST_RAFT,
      Blocks.BAMBOO_BUTTON,
      Blocks.CHERRY_SAPLING,
      () -> NSBoatTypes.REDWOOD,
      WoodSet.WoodPreset.FROSTABLE,
      false,
      new RedwoodSaplingGenerator()
  );

  public static final WoodSet SUGI = new WoodSet(
      new ResourceLocation(MOD_ID, "sugi"),
      MapColor.DEEPSLATE,
      MapColor.DIRT,
      REDWOOD.getLeaves(),
      REDWOOD.getLog(),
      REDWOOD.getHangingSign(),
      REDWOOD.getChestBoatItem(),
      REDWOOD.getButton(),
      REDWOOD.getSapling(),
      () -> NSBoatTypes.SUGI,
      WoodSet.WoodPreset.FANCY,
      true,
      new SugiSaplingGenerator()
  );

  public static final WoodSet WISTERIA = new WoodSet(
      new ResourceLocation(MOD_ID, "wisteria"),
      MapColor.COLOR_GRAY,
      MapColor.TERRACOTTA_WHITE,
      SUGI.getLeaves(),
      SUGI.getLog(),
      SUGI.getHangingSign(),
      SUGI.getChestBoatItem(),
      SUGI.getButton(),
      SUGI.getSapling(),
      () -> NSBoatTypes.WISTERIA,
      WoodSet.WoodPreset.WISTERIA,
      true,
      new WhiteWisteriaSaplingGenerator()
  );

  public static final WoodSet FIR = new WoodSet(
      new ResourceLocation(MOD_ID, "fir"),
      MapColor.COLOR_GRAY,
      MapColor.DIRT,
      WISTERIA.getPurpleLeaves(),
      WISTERIA.getLog(),
      WISTERIA.getHangingSign(),
      WISTERIA.getChestBoatItem(),
      WISTERIA.getButton(),
      WISTERIA.getPurpleSapling(),
      () -> NSBoatTypes.FIR,
      WoodSet.WoodPreset.FROSTABLE,
      false,
      new FirSaplingGenerator()
  );

  public static final WoodSet WILLOW = new WoodSet(
      new ResourceLocation(MOD_ID, "willow"),
      MapColor.TERRACOTTA_BLACK,
      MapColor.TERRACOTTA_BROWN,
      FIR.getLeaves(),
      FIR.getLog(),
      FIR.getHangingSign(),
      FIR.getChestBoatItem(),
      FIR.getButton(),
      FIR.getSapling(),
      () -> NSBoatTypes.WILLOW,
      WoodSet.WoodPreset.WILLOW,
      false,
      new WillowSaplingGenerator()
  );

  public static final WoodSet ASPEN = new WoodSet(
      new ResourceLocation(MOD_ID, "aspen"),
      MapColor.WOOL,
      MapColor.SAND,
      WILLOW.getLeaves(),
      WILLOW.getLog(),
      WILLOW.getHangingSign(),
      WILLOW.getChestBoatItem(),
      WILLOW.getButton(),
      WILLOW.getSapling(),
      () -> NSBoatTypes.ASPEN,
      WoodSet.WoodPreset.ASPEN,
      false,
      new AspenSaplingGenerator()
  );
  public static final WoodSet MAPLE = new WoodSet(
      new ResourceLocation(MOD_ID, "maple"),
      MapColor.PODZOL,
      MapColor.COLOR_ORANGE,
      ASPEN.getLeaves(),
      ASPEN.getLog(),
      ASPEN.getHangingSign(),
      ASPEN.getChestBoatItem(),
      ASPEN.getButton(),
      ASPEN.getSapling(),
      () -> NSBoatTypes.MAPLE,
      WoodSet.WoodPreset.MAPLE,
      false,
      new RedMapleSaplingGenerator()
  );

  public static final WoodSet CYPRESS = new WoodSet(
      new ResourceLocation(MOD_ID, "cypress"),
      MapColor.PODZOL,
      MapColor.WOOD,
      MAPLE.getYellowLeaves(),
      MAPLE.getLog(),
      MAPLE.getHangingSign(),
      MAPLE.getChestBoatItem(),
      MAPLE.getButton(),
      MAPLE.getYellowSapling(),
      () -> NSBoatTypes.CYPRESS,
      WoodSet.WoodPreset.DEFAULT,
      false,
      new CypressSaplingGenerator()
  );

  public static final WoodSet OLIVE = new WoodSet(
      new ResourceLocation(MOD_ID, "olive"),
      MapColor.SAND,
      MapColor.GRASS,
      CYPRESS.getLeaves(),
      CYPRESS.getLog(),
      CYPRESS.getHangingSign(),
      CYPRESS.getChestBoatItem(),
      CYPRESS.getButton(),
      CYPRESS.getSapling(),
      () -> NSBoatTypes.OLIVE,
      WoodSet.WoodPreset.DEFAULT,
      false,
      new OliveSaplingGenerator()
  );

  public static final Block OLIVE_BRANCH = registerPlantBlock("olive_branch", new OliveBranchBlock(BlockBehaviour.Properties.of().instabreak().noCollission().randomTicks().sound(SoundType.GRASS).noOcclusion().pushReaction(PushReaction.DESTROY)), OLIVE.getLog(), 0.5F);

  public static final WoodSet JOSHUA = new WoodSet(
      new ResourceLocation(MOD_ID, "joshua"),
      MapColor.GRASS,
      MapColor.DEEPSLATE,
      OLIVE.getLeaves(),
      OLIVE.getLog(),
      OLIVE.getHangingSign(),
      OLIVE.getChestBoatItem(),
      OLIVE.getButton(),
      OLIVE.getSapling(),
      () -> NSBoatTypes.JOSHUA,
      WoodSet.WoodPreset.JOSHUA,
      true,
      new JoshuaSaplingGenerator()
  );

  public static final WoodSet GHAF = new WoodSet(
      new ResourceLocation(MOD_ID, "ghaf"),
      MapColor.COLOR_LIGHT_GRAY,
      MapColor.COLOR_BROWN,
      JOSHUA.getLeaves(),
      JOSHUA.getLog(),
      JOSHUA.getHangingSign(),
      JOSHUA.getChestBoatItem(),
      JOSHUA.getButton(),
      JOSHUA.getSapling(),
      () -> NSBoatTypes.GHAF,
      WoodSet.WoodPreset.SANDY,
      false,
      new GhafSaplingGenerator()
  );

  public static final Block XERIC_THATCH = registerBlock("xeric_thatch",
      new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.4F).sound(SoundType.GRASS)), GHAF.getChestBoatItem());
  public static final Block XERIC_THATCH_STAIRS = registerBlock(
      "xeric_thatch_stairs",
      new StairBlock(XERIC_THATCH.defaultBlockState(), BlockBehaviour.Properties.copy(XERIC_THATCH))
  );
  public static final Block XERIC_THATCH_SLAB = registerBlock("xeric_thatch_slab",
      new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.GRASS).strength(0.4f)));
  public static final Block XERIC_THATCH_CARPET = registerBlock("xeric_thatch_carpet",
      new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0F).pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS))
  );

  public static final WoodSet PALO_VERDE = new WoodSet(
      new ResourceLocation(MOD_ID, "palo_verde"),
      MapColor.COLOR_YELLOW,
      MapColor.GLOW_LICHEN,
      GHAF.getLeaves(),
      GHAF.getLog(),
      GHAF.getHangingSign(),
      GHAF.getChestBoatItem(),
      GHAF.getButton(),
      GHAF.getSapling(),
      () -> NSBoatTypes.PALO_VERDE,
      WoodSet.WoodPreset.SANDY,
      false,
      new PaloVerdeSaplingGenerator()
  );

  public static final WoodSet COCONUT = new WoodSet(
      new ResourceLocation(MOD_ID, "coconut"),
      MapColor.CRIMSON_STEM,
      MapColor.COLOR_BROWN,
      PALO_VERDE.getLeaves(),
      PALO_VERDE.getLog(),
      PALO_VERDE.getHangingSign(),
      PALO_VERDE.getChestBoatItem(),
      PALO_VERDE.getButton(),
      PALO_VERDE.getSapling(),
      () -> NSBoatTypes.COCONUT,
      WoodSet.WoodPreset.NO_SAPLING,
      true,
      new CoconutSaplingGenerator()
  );

  public static final Block COCONUT_THATCH = registerBlock("coconut_thatch",
      new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.4F).sound(SoundType.GRASS)), COCONUT.getChestBoatItem());
  public static final Block COCONUT_THATCH_STAIRS = registerBlock(
      "coconut_thatch_stairs",
      new StairBlock(COCONUT_THATCH.defaultBlockState(), BlockBehaviour.Properties.copy(COCONUT_THATCH))
  );
  public static final Block COCONUT_THATCH_SLAB = registerBlock("coconut_thatch_slab",
      new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.GRASS).strength(0.4f)));
  public static final Block COCONUT_THATCH_CARPET = registerBlock("coconut_thatch_carpet",
      new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0F).pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS))
  );
  public static final Block COCONUT_BLOCK = registerPlantBlock("coconut", new CoconutBlock(
      BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.GRASS).noOcclusion().pushReaction(PushReaction.DESTROY)
  ), Items.SWEET_BERRIES, 0.2F);
  public static final Block COCONUT_SPROUT = registerPlantBlock("coconut_sprout", new SproutingCoconutBlock(new CoconutSaplingGenerator(),
      BlockBehaviour.Properties.of().strength(1.0F).sound(SoundType.GRASS).noOcclusion().pushReaction(PushReaction.DESTROY)
  ), PALO_VERDE.getSapling(), 0.2F);
  public static final FoodProperties COCONUT_COMPONENT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();

  public static final Item COCONUT_SHELL = registerPlantItem("coconut_shell",
      new Item(new Item.Properties()),

      Items.BOWL,
      CreativeModeTabs.INGREDIENTS,
      0.1F
  );
  public static final Item COCONUT_HALF = registerPlantItem("coconut_half",
      new CoconutHalfItem(new Item.Properties().food(COCONUT_COMPONENT), COCONUT_SHELL),

      Items.BEETROOT,
      CreativeModeTabs.FOOD_AND_DRINKS,
      0.1F
  );

  public static final WoodSet CEDAR = new WoodSet(
      new ResourceLocation(MOD_ID, "cedar"),
      MapColor.TERRACOTTA_MAGENTA,
      MapColor.COLOR_GRAY,
      COCONUT.getLeaves(),
      COCONUT.getLog(),
      COCONUT.getHangingSign(),
      COCONUT.getChestBoatItem(),
      COCONUT.getButton(),
      COCONUT_SPROUT,
      () -> NSBoatTypes.CEDAR,
      WoodSet.WoodPreset.DEFAULT,
      false,
      new CedarSaplingGenerator()
  );

  public static final WoodSet LARCH = new WoodSet(
      new ResourceLocation(MOD_ID, "larch"),
      MapColor.COLOR_BLUE,
      MapColor.COLOR_LIGHT_GRAY,
      CEDAR.getLeaves(),
      CEDAR.getLog(),
      CEDAR.getHangingSign(),
      CEDAR.getChestBoatItem(),
      CEDAR.getButton(),
      CEDAR.getSapling(),
      () -> NSBoatTypes.LARCH,
      WoodPreset.DEFAULT,
      false,
      new LarchSaplingGenerator()
  );

  public static final Block EVERGREEN_THATCH = registerBlock("evergreen_thatch",
      new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.4F).sound(SoundType.GRASS)), LARCH.getChestBoatItem());
  public static final Block EVERGREEN_THATCH_STAIRS = registerBlock(
      "evergreen_thatch_stairs",
      new StairBlock(EVERGREEN_THATCH.defaultBlockState(), BlockBehaviour.Properties.copy(EVERGREEN_THATCH))
  );
  public static final Block EVERGREEN_THATCH_SLAB = registerBlock("evergreen_thatch_slab",
      new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.GRASS).strength(0.4f)));
  public static final Block EVERGREEN_THATCH_CARPET = registerBlock("evergreen_thatch_carpet",
      new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0F).pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS))
  );

  public static final WoodSet MAHOGANY = new WoodSet(
      new ResourceLocation(MOD_ID, "mahogany"),
      MapColor.COLOR_BROWN,
      MapColor.COLOR_LIGHT_GRAY,
      LARCH.getLeaves(),
      LARCH.getLog(),
      LARCH.getHangingSign(),
      LARCH.getChestBoatItem(),
      LARCH.getButton(),
      LARCH.getSapling(),
      () -> NSBoatTypes.MAHOGANY, WoodSet.WoodPreset.DEFAULT,
      true,
      new MahoganySaplingGenerator()
  );

  public static final WoodSet SAXAUL = new WoodSet(
      new ResourceLocation(MOD_ID, "saxaul"),
      MapColor.COLOR_LIGHT_GRAY,
      MapColor.COLOR_LIGHT_GRAY,
      MAHOGANY.getLeaves(),
      MAHOGANY.getLog(),
      MAHOGANY.getHangingSign(),
      MAHOGANY.getChestBoatItem(),
      MAHOGANY.getButton(),
      MAHOGANY.getSapling(),
      () -> NSBoatTypes.SAXAUL,
      WoodSet.WoodPreset.SANDY,
      false,
      new SaxaulSaplingGenerator()
  );

//   public static final WoodSet BANYAN = new WoodSet(
//           new Identifier(MOD_ID, "banyan"),
//           MapColor.BROWN,
//           MapColor.LIGHT_GRAY,
//           LARCH.getLeaves(),
//           LARCH.getLog(),
//           LARCH.getHangingSign(),
//           LARCH.getChestBoatItem(),
//           LARCH.getButton(),
//           LARCH.getSapling(),
//           () -> NSBoatTypes.BANYAN,
//           new BanyanSaplingGenerator(),
//           WoodSet.WoodPreset.DEFAULT,
//           false
//   );

  private static final List<WoodSet> WOOD_SETS = ImmutableList.of(
      REDWOOD,
      SUGI,
      WISTERIA,
      FIR,
      WILLOW,
      ASPEN,
      MAPLE,
      CYPRESS,
      OLIVE,
      JOSHUA,
      GHAF,
      PALO_VERDE,
      COCONUT,
      CEDAR,
      LARCH,
      MAHOGANY,
      SAXAUL
  );

  public static List<WoodSet> getWoodSets() {
    return WOOD_SETS;
  }

  static {
    NSBoatTypes.init();
  }

  public static void registerWoods() {
    FlammableBlockRegistry.getDefaultInstance().add(OLIVE_BRANCH, 6, 20);
    NSMiscBlocks.registerMiscBlocks();
  }
}
