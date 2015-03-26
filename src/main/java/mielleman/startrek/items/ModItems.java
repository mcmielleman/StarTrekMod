package mielleman.startrek.items;

import net.minecraft.item.Item;

public class ModItems {
	
	/*
	 * All the item objects are defined here.
	 */
	public static Item phaserItem;
	
	/*
	 * All the unlocalized names are defined here.
	 */
	public static String phaserItemName = "phaserItem";
	
	/*
	 * All the icons are defined here.
	 */
	public static String particleIcon = "particleLaser";
	public static String phaserItemIcon = "phaser";

	/*
	 * The items objectes are made here.
	 */
	public static void init() {
		
		phaserItem = new ItemPhaser();
	
	}

}
