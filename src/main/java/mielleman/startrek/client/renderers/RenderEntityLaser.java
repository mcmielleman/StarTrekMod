package mielleman.startrek.client.renderers;

import org.lwjgl.opengl.GL11;

import mielleman.startrek.reference.References;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityLaser extends Render {
	
	private ModelEntityLaser model;
	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/models/LaserEntity.png");
	public RenderEntityLaser() {
	   model = new ModelEntityLaser();
	   shadowSize = 0.0F;
	}
	
	public void renderEntity(Entity entity, double x, double y, double z, float yaw, float partialTickTime){
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1F, -1F, 1F);
		
		model.render(entity, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		GL11.glPopMatrix();
	} 

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		renderEntity(entity, x, y, z, yaw, partialTickTime);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
