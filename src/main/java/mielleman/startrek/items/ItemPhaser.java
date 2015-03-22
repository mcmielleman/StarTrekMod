package mielleman.startrek.items;

import mielleman.startrek.reference.References;
import mielleman.startrek.items.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemPhaser extends Item {

	public ItemPhaser() {
        setUnlocalizedName(References.MODID + "_" + ModItems.phaserItemName); 
        setTextureName(References.MODID + ":" + "p");
        GameRegistry.registerItem(this, ModItems.phaserItemName);
        this.maxStackSize = 1;
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {

    	if(player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(Items.redstone)) {

            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(new EntitySnowball(world, player));
            }
    	}
    	return itemstack;
    }
	
 

}
