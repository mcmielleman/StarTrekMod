package mielleman.startrek.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaser extends EntityThrowable {
	
    private int explosionRadius = 3;
	public EntityLaser(World world) {
		super(world);
	}

	public EntityLaser(World world, double par2, double par3, double par4) {
		super(world, par2, par3, par4);
	}
	public EntityLaser(World world, EntityLivingBase entityLivingBase) {
		super(world, entityLivingBase);
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

}
