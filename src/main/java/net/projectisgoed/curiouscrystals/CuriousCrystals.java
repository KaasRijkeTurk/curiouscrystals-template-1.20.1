package net.projectisgoed.curiouscrystals;

import net.fabricmc.api.ModInitializer;

import net.projectisgoed.curiouscrystals.block.ModBlocks;
import net.projectisgoed.curiouscrystals.event.OpalRegenerationHandler;
import net.projectisgoed.curiouscrystals.event.RubyWeaponLifeStealHandler;
import net.projectisgoed.curiouscrystals.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuriousCrystals implements ModInitializer {
	public static final String MOD_ID = "curiouscrystals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
		// Weapon life steal
		RubyWeaponLifeStealHandler.register();
		// Registreer Opal armor regen event
		OpalRegenerationHandler.register();
    }
}