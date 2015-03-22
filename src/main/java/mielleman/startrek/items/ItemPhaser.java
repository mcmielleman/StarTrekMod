package mielleman.startrek.items;

import mielleman.startrek.reference.References;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemPhaser extends Item {

	public ItemPhaser() {
        setUnlocalizedName(References.MODID + "_" + Items.phaserItemName); 
        GameRegistry.registerItem(this, Items.phaserItemName);
	}

}
