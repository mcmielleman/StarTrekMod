package mielleman.startrek.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaser extends EntityThrowable {
	public EntityLivingBase player;
    private int explosionRadius = 3;
	public EntityLaser(World world) {
		super(world);
	}

	public EntityLaser(World world, double par2, double par3, double par4) {
		super(world, par2, par3, par4);
	}
	public EntityLaser(World world, EntityLivingBase entityLivingBase) {
		super(world, entityLivingBase);
		player = entityLivingBase;
	}

	@Override
	protected void onImpact(MovingObjectPosition position) {
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);            
	    this.setDead();
	}
	
	@Override
    protected float getGravityVelocity()
    {
        return 0.00F;
    }
	
	@Override
	public void onUpdate(){
		super.onUpdate();
		//if(!worldObj.isRemote) {
		 /*   for (int x = 0; x < 20; x++){
	    	    double motionX = rand.nextGaussian() * 0.02D;
    		    double motionY = rand.nextGaussian() * 0.02D;
		        double motionZ = rand.nextGaussian() * 0.02D;
		        worldObj.spawnParticle(
		              "reddust", 
		              posX + rand.nextFloat() * width * 2.0F - width, 
		              posY + 0.5D + rand.nextFloat() * height, 
	    	          posZ + rand.nextFloat() * width * 2.0F - width, 
    		          motionX, 
		              motionY, 
		              motionZ);
	         }*/

		//}
		
	}
	
	public EntityPlayer getOwner() {
		if(player instanceof EntityPlayer){
			return (EntityPlayer)player;
		} else {
			return null;
		}
		
		
	}

}
