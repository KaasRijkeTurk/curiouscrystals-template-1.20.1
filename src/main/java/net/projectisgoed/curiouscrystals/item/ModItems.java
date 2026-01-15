package net.projectisgoed.curiouscrystals.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.projectisgoed.curiouscrystals.CuriousCrystals;
import net.projectisgoed.curiouscrystals.block.ModBlocks;

public class ModItems {

    // Gems
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item OPAL = registerItem("opal", new Item(new FabricItemSettings()));
    public static final Item ONYX = registerItem("onyx", new Item(new FabricItemSettings()));
    public static final Item BISMUTH = registerItem("bismuth", new Item(new FabricItemSettings()));
    public static final Item PERIDOT = registerItem("peridot", new Item(new FabricItemSettings()));
    public static final Item CITRINE = registerItem("citrine", new Item(new FabricItemSettings()));
    public static final Item ALEXANDRITE = registerItem("alexandrite", new Item(new FabricItemSettings()));
    public static final Item JADE = registerItem("jade", new Item(new FabricItemSettings()));
    public static final Item ROSEQUARTZ_GEM = registerItem("rosequartz_gem", new Item(new FabricItemSettings()));
    // RUBY Smithing Template
    public static final Item GEM_UPGRADE_TEMPLATE = registerItem("gem_upgrade_template",
            new Item(new FabricItemSettings()));

// RUBY armor verwijderen, alleen OPAL items behouden

    public static final Item OPAL_HELMET = registerItem("opal_helmet",
            new ArmorItem(ModArmorMaterials.OPAL, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item OPAL_CHESTPLATE = registerItem("opal_chestplate",
            new ArmorItem(ModArmorMaterials.OPAL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item OPAL_LEGGINGS = registerItem("opal_leggings",
            new ArmorItem(ModArmorMaterials.OPAL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item OPAL_BOOTS = registerItem("opal_boots",
            new ArmorItem(ModArmorMaterials.OPAL, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    // RUBY Weapons
    public static final Item RUBY_DIAMOND_SWORD = registerItem("ruby_diamond_sword",
            new net.minecraft.item.SwordItem(net.projectisgoed.curiouscrystals.item.ModToolMaterials.RUBY,
                    3, // base attack damage (extra boven weapon base)
                    -2.4f, // attack speed
                    new FabricItemSettings()));

    public static final Item RUBY_DIAMOND_AXE = registerItem("ruby_diamond_axe",
            new net.minecraft.item.AxeItem(net.projectisgoed.curiouscrystals.item.ModToolMaterials.RUBY,
                    7, // base attack damage
                    -3.1f, // attack speed
                    new FabricItemSettings()));
    // Voeg items toe aan ItemGroups
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(SAPPHIRE);
        entries.add(OPAL);
        entries.add(ONYX);
        entries.add(BISMUTH);
        entries.add(PERIDOT);
        entries.add(CITRINE);
        entries.add(ALEXANDRITE);
        entries.add(JADE);
        entries.add(ROSEQUARTZ_GEM);

        entries.add(ModBlocks.BISMUTH_ORE);
        entries.add(ModBlocks.ONYX_ORE);
        entries.add(ModBlocks.BLACKSTONE_RUBY_ORE);
        entries.add(ModBlocks.BLACKSTONE_SAPPHIRE_ORE);
        entries.add(ModBlocks.DEEPSLATE_OPAL_ORE);
        entries.add(ModBlocks.OPAL_ORE);
        entries.add(ModBlocks.PERIDOT_ORE);

        entries.add(ModItems.OPAL_HELMET);
        entries.add(ModItems.OPAL_CHESTPLATE);
        entries.add(ModItems.OPAL_LEGGINGS);
        entries.add(ModItems.OPAL_BOOTS);
        entries.add(GEM_UPGRADE_TEMPLATE);
        entries.add(ModItems.RUBY_DIAMOND_SWORD);
        entries.add(ModItems.RUBY_DIAMOND_AXE);
        entries.add(GEM_UPGRADE_TEMPLATE);

    }



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CuriousCrystals.MOD_ID, name), item);
    }

    private static ArmorItem registerArmorItem(String name, ArmorItem item) {
        return (ArmorItem) Registry.register(Registries.ITEM, new Identifier(CuriousCrystals.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CuriousCrystals.LOGGER.info("Registering Mod Items for " + CuriousCrystals.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
