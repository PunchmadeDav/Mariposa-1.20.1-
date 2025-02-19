package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.datagen.MariposaConfiguredFeatures;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.mixin.lookup.BlockEntityTypeAccessor;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.Optional;
import java.util.function.Function;

public interface MariposaBlocks {
    BlockSetType SEQUOIA_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Mariposa.id("sequoia"));
    WoodType SEQUOIA_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Mariposa.id("sequoia"), SEQUOIA_BLOCK_SET_TYPE);
    SaplingGenerator SEQUOIA_SAPLING_GENERATOR = new SaplingGenerator(
            "sequoia",
            0.5F,
            Optional.of(MariposaConfiguredFeatures.SEQUOIA),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
    );
    Block SEQUOIA_PLANKS = createWithItem(
            "sequoia_planks",
			Block::new, AbstractBlock.Settings.create()
                    .mapColor(MapColor.RED)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    Block SEQUOIA_SAPLING = createWithItem(
            "sequoia_sapling",
            settings -> new SaplingBlock(
                    SEQUOIA_SAPLING_GENERATOR,
                    settings
            ), AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    Block SEQUOIA_LOG = createWithItem(
            "sequoia_log",
            PillarBlock::new,
            FabricBlockSettings.copyOf(Blocks.OAK_LOG)
                    .mapColor(MapColor.BROWN)
                    .sounds(BlockSoundGroup.WOOD)
    );

    Block STACKED_SEQUOIA_LOGS = createWithItem(
            "stacked_sequoia_logs",
            PillarBlock::new,
            FabricBlockSettings.copyOf(Blocks.OAK_LOG)
                    .mapColor(MapColor.BROWN)
                    .sounds(BlockSoundGroup.WOOD)
    );

    Block STRIPPED_SEQUOIA_LOG = createWithItem(
            "stripped_sequoia_log",
            PillarBlock::new,
            FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)
                    .mapColor(MapColor.RED)
                    .sounds(BlockSoundGroup.WOOD)
    );

    Block SEQUOIA_WOOD = createWithItem(
            "sequoia_wood",
			PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );
    Block STRIPPED_SEQUOIA_WOOD = createWithItem(
            "stripped_sequoia_wood",
			PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.RED).instrument(Instrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()
    );
    Block SEQUOIA_LEAVES = createWithItem(
            "sequoia_leaves",
            LeavesBlock::new,
            FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)
                    .mapColor(MapColor.DARK_GREEN)
                    .sounds(BlockSoundGroup.GRASS)
    );
    Block SEQUOIA_SIGN = create(
            "sequoia_sign",
            settings -> new SignBlock(settings, SEQUOIA_WOOD_TYPE),
            FabricBlockSettings.create()
                    .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()
    );
    Block SEQUOIA_WALL_SIGN = create(
            "sequoia_wall_sign",
            settings -> new WallSignBlock(settings, SEQUOIA_WOOD_TYPE),
            FabricBlockSettings.create()
                    .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()
    );
    Block SEQUOIA_HANGING_SIGN = create(
            "sequoia_hanging_sign",
            settings -> new HangingSignBlock(settings, SEQUOIA_WOOD_TYPE),
            FabricBlockSettings.create()
                    .mapColor(SEQUOIA_LOG.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()
    );
    Block SEQUOIA_WALL_HANGING_SIGN = create(
            "sequoia_wall_hanging_sign",
            settings -> new WallHangingSignBlock(settings, SEQUOIA_WOOD_TYPE),
            FabricBlockSettings.create()
                    .mapColor(MapColor.OAK_TAN)
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()
    );
    Block SEQUOIA_PRESSURE_PLATE = createWithItem(
            "sequoia_pressure_plate",
            settings -> new PressurePlateBlock(
                    PressurePlateBlock.ActivationRule.EVERYTHING,
                    settings,
                    SEQUOIA_BLOCK_SET_TYPE
            ),
            FabricBlockSettings.create()
                    .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    Block SEQUOIA_TRAPDOOR = createWithItem(
            "sequoia_trapdoor",
            settings -> new TrapdoorBlock(
                    settings,
                    SEQUOIA_BLOCK_SET_TYPE
            ),
            FabricBlockSettings.create()
                    .mapColor(MapColor.RED)
                    .instrument(Instrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable()
    );
    Block SEQUOIA_STAIRS = createWithItem("sequoia_stairs",
            settings -> new StairsBlock(SEQUOIA_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(SEQUOIA_PLANKS));
    Block POTTED_SEQUOIA_SAPLING = create(
            "potted_sequoia_sapling",
            settings -> new FlowerPotBlock(
                    SEQUOIA_SAPLING,
                    settings
            ),
            FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)
    );
    Block SEQUOIA_BUTTON = createWithItem(
            "sequoia_button",
            settings -> new ButtonBlock(
                    settings,
                    SEQUOIA_BLOCK_SET_TYPE,
                    30,
                    false
            ),
            FabricBlockSettings.create()
                    .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    Block SEQUOIA_SLAB = createWithItem(
            "sequoia_slab",
			SlabBlock::new, AbstractBlock.Settings.create()
                    .mapColor(MapColor.RED)
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    Block SEQUOIA_FENCE_GATE = createWithItem(
            "sequoia_fence_gate",
            settings -> new FenceGateBlock(
                    settings,
                    SEQUOIA_WOOD_TYPE
            ),
            FabricBlockSettings.create()
                    .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                    .solid()
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable()
    );
    Block SEQUOIA_FENCE = createWithItem(
            "sequoia_fence",
			FenceBlock::new,  AbstractBlock.Settings.create()
                    .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                    .instrument(Instrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable()
                    .sounds(BlockSoundGroup.WOOD)
    );
    Block SEQUOIA_DOOR = create(
            "sequoia_door",
            settings -> new DoorBlock(
                    settings,
                    SEQUOIA_BLOCK_SET_TYPE
            ),
            FabricBlockSettings.create()
                    .mapColor(SEQUOIA_PLANKS.getDefaultMapColor())
                    .instrument(Instrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    static Block create(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings);
        return Registry.register(Registries.BLOCK, Mariposa.id(name), block);
    }

    static Block createWithItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = create(name, factory, settings);
        MariposaItems.create(name, itemSettings -> new BlockItem(block, itemSettings), new Item.Settings());
        return block;
    }

    static void initialize() {
        StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_WOOD, MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
        StrippableBlockRegistry.register(MariposaBlocks.SEQUOIA_LOG, MariposaBlocks.STRIPPED_SEQUOIA_LOG);

        ((BlockEntityTypeAccessor) BlockEntityType.SIGN).getBlocks().add(MariposaBlocks.SEQUOIA_SIGN);
        ((BlockEntityTypeAccessor) BlockEntityType.SIGN).getBlocks().add(MariposaBlocks.SEQUOIA_WALL_SIGN);
        ((BlockEntityTypeAccessor) BlockEntityType.HANGING_SIGN).getBlocks().add(MariposaBlocks.SEQUOIA_HANGING_SIGN);
        ((BlockEntityTypeAccessor) BlockEntityType.HANGING_SIGN).getBlocks().add(MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
    }
}
