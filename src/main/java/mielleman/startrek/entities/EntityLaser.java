package mielleman.startrek.entities;

import mielleman.startrek.client.particles.ParticleLaser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaser extends EntityThrowable {
	/*
	 * A list of variables for the entity:
	 * Player: the person who threw the entity.
	 * explosionRadius: the radius of the explosion the entity makes (disabled).
	 * maxage: the max age this entity can get.
	 * age: the current age of the entity.
	 */
	public EntityPlayer player;
    private int explosionRadius;
    private int maxage;
    private int age;
    
    /*
     * Constructor and sending the the parameters to the super class.
     */
	public EntityLaser(World world) {
		super(world);
	}

    /*
     * Constructor and sending the the parameters to the super class.
     */
	public EntityLaser(World world, double par2, double par3, double par4) {
		super(world, par2, par3, par4);
	}
	
    /*
     * Constructor and sending the the parameters to the super class.
     * Also setting the above variables.
     */
	public EntityLaser(World world, EntityPlayer player) {
		super(world, player);
		this.player = player;
		age = 0;
		maxage = 150;
		explosionRadius = 3;
	}
	
	/*
	 * Defining what happend when the entity hits something.
	 * It dies and hurts the entity (if it hit one).
	 * This currently crashes TODO
	 */
	@Override
	protected void onImpact(MovingObjectPosition position) {
		//this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);            
	    this.setDead();
	    position.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(player), 1.0F);
	}
	
	/*
	 * The amount of gravity that affects this entity.
	 */
	@Override
    protected float getGravityVelocity()
    {
        return 0.00F;
    }
	
	/*
	 * Had to manually do the updating, the super class was not handling this well, 
	 * it wasn't killing the entity.
	 * TODO: Making the entity move faster. (not too much, a little)
	 */
	@Override
	public void onUpdate(){
		super.onUpdate();
        if(age++ >= maxage){
        	this.setDead();
        }
        //System.out.println(age);
		if(!worldObj.isRemote) {
		    for (int x = 0; x < 20; x++){
	    	    /*double motionX = rand.nextGaussian() * 0.01D;
    		    double motionY = rand.nextGaussian() * 0.01D;
		        double motionZ = rand.nextGaussian() * 0.01D;*/
		    	double motionX = 1.0;
		    	double motionY = 1.0;
		    	double motionZ = 1.0;

		        EntityFX particle = new ParticleLaser(worldObj, 
		        		                              posX + rand.nextFloat() * 0.05F,
		        		                              posY + 0.5D + rand.nextFloat() * height, 
		        		                              posZ + rand.nextFloat() * 0.05F, 
		        		                              motionX, 
		        		                              motionY, 
		        		                              motionZ);
		        Minecraft.getMinecraft().effectRenderer.addEffect(particle);
	         }

		}
		
	}
	
}
