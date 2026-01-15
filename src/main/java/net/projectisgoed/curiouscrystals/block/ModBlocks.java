package net.projectisgoed.curiouscrystals.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.projectisgoed.curiouscrystals.CuriousCrystals;

public class ModBlocks {
    public static final Block BISMUTH_ORE = registerBlock("bismuth_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));

    public static final Block ONYX_ORE = registerBlock("onyx_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));

    public static final Block OPAL_ORE = registerBlock("opal_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));

    public static final Block DEEPSLATE_OPAL_ORE = registerBlock("deepslate_opal_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));

    public static final Block BLACKSTONE_RUBY_ORE = registerBlock("blackstone_ruby_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));

    public static final Block BLACKSTONE_SAPPHIRE_ORE = registerBlock("blackstone_sapphire_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));

    public static final Block PERIDOT_ORE = registerBlock("peridot_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CuriousCrystals.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CuriousCrystals.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CuriousCrystals.LOGGER.info("Registering ModBlocks for " + CuriousCrystals.MOD_ID);
    }
}
