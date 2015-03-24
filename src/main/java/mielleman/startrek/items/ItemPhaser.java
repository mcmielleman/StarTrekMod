package mielleman.startrek.items;

import javax.swing.Icon;

import mielleman.startrek.entities.EntityLaser;
import mielleman.startrek.reference.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPhaser extends Item {

	@SideOnly(Side.CLIENT)
	private IIcon icon;
	
	public ItemPhaser() {
        setUnlocalizedName(References.MODID + "_" + ModItems.phaserItemName); 
        //setTextureName(References.MODID + ":" + "p");
        GameRegistry.registerItem(this, ModItems.phaserItemName);
        this.maxStackSize = 1;
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
    	if(player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(Items.redstone)) {

            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote)
            {
            	EntityLaser laser = new EntityLaser(world, player);
                world.spawnEntityInWorld(laser);
            }
    	}
    	return itemstack;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register){
    	icon = register.registerIcon(References.MODID + ":" + ModItems.phaserItem);
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int dmg) {
		return icon;
	}
	
 

}
