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

	/*
	 * Defining the icons here, also the icon for the particle because can't defined in its own class(???).
	 */
	@SideOnly(Side.CLIENT)
	private IIcon icon;
	@SideOnly(Side.CLIENT)
	public static IIcon particle;
	
	/*
	 * Constructor, registering the item, set its unlocalized name, and setting max stack size.
	 */
	public ItemPhaser() {
        setUnlocalizedName(References.MODID + "_" + ModItems.phaserItemName); 
        GameRegistry.registerItem(this, ModItems.phaserItemName);
        this.maxStackSize = 1;
	}
	
	/*
	 * When the item is right clicked, it checks for redstone in inventory (or creative), 
	 * plays a sound, and spawns the laser entity.
	 * It spawns the entity a bit lower for visuals, should be improved yet.
	 */
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
    	if(player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(Items.redstone)) {

            world.playSoundAtEntity(player, "random.bow", 0.5F, 3.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote)
            {
            	EntityLaser laser = new EntityLaser(world, player);
                world.spawnEntityInWorld(laser);
                laser.posY = laser.posY - 0.5;
            }
    	}
    	return itemstack;
    }
    
    /*
     * Registering and returning the icon here, later we can add multiple icon for different itemdamages.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register){
    	icon = register.registerIcon(References.MODID + ":" + ModItems.phaserItemIcon);
    	//particle = register.registerIcon(References.MODID + ":" + ModItems.particleIcon);
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int dmg) {
		return icon;
	}
	
 

}
