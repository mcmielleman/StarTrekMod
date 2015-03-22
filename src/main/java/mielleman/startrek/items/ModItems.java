package mielleman.startrek.items;

import net.minecraft.item.Item;

public class ModItems {
	
	public static Item phaserItem;
	
	public static String phaserItemName = "phaserItem";
	
	public static void init() {
		
		phaserItem = new ItemPhaser();
	
	}

}
