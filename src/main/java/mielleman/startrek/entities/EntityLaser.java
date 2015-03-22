package mielleman.startrek.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaser extends EntityThrowable {
	
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
		
	}

}
