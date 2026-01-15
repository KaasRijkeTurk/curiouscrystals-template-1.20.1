package net.projectisgoed.curiouscrystals.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public class ModToolMaterials {

    public static final ToolMaterial RUBY = new RubyToolMaterial();

    private static class RubyToolMaterial implements ToolMaterial {
        @Override
        public int getDurability() {
            return 1500; // vergelijkbaar met netherite
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 8.0f; // hoe snel het blokken kapot maakt
        }

        @Override
        public float getAttackDamage() {
            return 3.0f; // extra damage bovenop basis wapen
        }

        @Override
        public int getMiningLevel() {
            return 3; // diamond-level
        }

        @Override
        public int getEnchantability() {
            return 15; // hoe goed te enchant
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.RUBY); // repair met Ruby gem
        }
    }
}
