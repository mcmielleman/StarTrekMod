package mielleman.startrek.entities;

import mielleman.startrek.StarTrekMod;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public static String phaserEntityName = "Phaser Beam";
	
	public static byte phaserEntityID = 0;
	
	public static void init() {
		EntityRegistry.registerModEntity(EntityLaser.class, phaserEntityName, phaserEntityID, StarTrekMod.instance, 120, 3, true);
    }

}
