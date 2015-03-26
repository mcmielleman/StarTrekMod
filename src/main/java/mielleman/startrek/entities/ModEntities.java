package mielleman.startrek.entities;

import mielleman.startrek.StarTrekMod;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	/*
	 * Entity file, used to store all entity variables and to register the entities.
	 */
	
	/*
	 * Defining the entity names here, allthough they are not seen very often.
	 */
	public static String phaserEntityName = "Phaser Beam";
	
	/*
	 * Defining the entity ID's here, they are mod specific.
	 */
	public static byte phaserEntityID = 0;
	
	/*
	 * Registering the entity here.
	 */
	public static void init() {
		EntityRegistry.registerModEntity(EntityLaser.class, phaserEntityName, phaserEntityID, StarTrekMod.instance, 120, 3, true);
    }

}
