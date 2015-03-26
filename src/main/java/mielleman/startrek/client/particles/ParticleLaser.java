package mielleman.startrek.client.particles;

import mielleman.startrek.items.ItemPhaser;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class ParticleLaser extends EntityFX{

	/*
	 * Constructor, setting the color red to the entity and setting maxage and gravity.
	 */
	public ParticleLaser(World world, double x, double y, double z, double motionX, double motionY, double motionZ){
		super(world, x, y, z, motionX, motionY, motionZ);
		//this.setParticleIcon(ItemPhaser.particle);
		this.setRBGColorF(1.0F, 0.1F, 0.1F);
		particleMaxAge = 5;
		particleGravity = 0.0F;
    }
	
	/*
	 * If using a texture chart, this needs to return 0, 
	 * but we don't use those so return 1.
	 */
	@Override
	public int getFXLayer(){
		return 1;	
	}

	/*
	 * I had to do the moving manually otherwise it crashed because it was doing stuff
	 * with bounding boxes
	 * TODO 
	 */
	@Override
	public void moveEntity(double x, double y, double z){
		 this.boundingBox.offset(x, y, z);
         this.posX = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0D;
         this.posY = this.boundingBox.minY + (double)this.yOffset - (double)this.ySize;
         this.posZ = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0D;
	}
}
