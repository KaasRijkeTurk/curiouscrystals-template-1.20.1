package net.projectisgoed.curiouscrystals.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.projectisgoed.curiouscrystals.item.ModItems;

public class RubyWeaponLifeStealHandler {

    public static void register() {
        AttackEntityCallback.EVENT.register((player, world, hand, targetEntity, hitResult) -> {
            if (!(player instanceof PlayerEntity)) return ActionResult.PASS;
            if (!(targetEntity instanceof LivingEntity)) return ActionResult.PASS;

            ItemStack weapon = player.getMainHandStack();

            // Check of speler een Ruby sword of axe vasthoudt
            if (isRubyWeapon(weapon)) {

                float damage = getWeaponDamage(weapon);

                // Heal speler: 10% van de damage
                float healAmount = damage * 0.10f;

                // Max 4 HP per hit
                if (healAmount > 4f) healAmount = 4f;

                // Cooldown via wapen stack
                if (!player.getItemCooldownManager().isCoolingDown(weapon.getItem())) {
                    player.heal(healAmount);
                    player.getItemCooldownManager().set(weapon.getItem(), 10); // 0.5 sec
                }
            }

            return ActionResult.PASS;
        });
    }

    private static boolean isRubyWeapon(ItemStack stack) {
        return stack.getItem() == ModItems.RUBY_DIAMOND_SWORD
                || stack.getItem() == ModItems.RUBY_DIAMOND_AXE;
    }

    private static float getWeaponDamage(ItemStack stack) {
        float damage = 1f;
        try {
            damage += stack.getAttributeModifiers(net.minecraft.entity.EquipmentSlot.MAINHAND)
                    .get(net.minecraft.entity.attribute.EntityAttributes.GENERIC_ATTACK_DAMAGE)
                    .stream().mapToDouble(mod -> mod.getValue()).sum();
        } catch (Exception ignored) {}
        return damage;
    }
}
