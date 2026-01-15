package net.projectisgoed.curiouscrystals.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class OpalRegenerationHandler {

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (OpalArmorEffect.hasFullOpalArmor(player)) {
                    if (player.age % 20 == 0) { // 1 seconde
                        player.heal(1.0F);
                    }
                }
            }
        });
    }
}
