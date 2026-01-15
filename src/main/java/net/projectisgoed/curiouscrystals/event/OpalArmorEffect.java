package net.projectisgoed.curiouscrystals.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.projectisgoed.curiouscrystals.item.ModItems;

public class OpalArmorEffect {

    /**
     * Checkt of de speler full Opal armor draagt
     */
    public static boolean hasFullOpalArmor(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return boots.isOf(ModItems.OPAL_BOOTS)
                && leggings.isOf(ModItems.OPAL_LEGGINGS)
                && chestplate.isOf(ModItems.OPAL_CHESTPLATE)
                && helmet.isOf(ModItems.OPAL_HELMET);
    }
}
