package mielleman.startrek.client.renderers;

import org.lwjgl.opengl.GL11;

import mielleman.startrek.reference.References;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityLaser extends Render {
	
	/*
	 * This is the class that handels the rendering of the laser entity.
	 */
	
	/*
	 * Defining the model here.
	 */
	private ModelEntityLaser model;
	
	/*
	 * The resource location of the texture of the entity.
	 * TODO: Make this actually work.
	 */
	private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/models/LaserEntity.png");
	
	/*
	 * Constructor, defining the model and setting the shadow size to zero.
	 */
	public RenderEntityLaser() {
	   model = new ModelEntityLaser();
	   shadowSize = 0.0F;
	}
	
	/*
	 * This is where it starts rendering the entity, it passes the rendering of the specific parts
	 * to the model class.
	 */
	public void renderEntity(Entity entity, double x, double y, double z, float yaw, float partialTickTime){
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1F, -1F, 1F);
		
		model.render(entity, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		GL11.glPopMatrix();
	} 

	/*
	 * This gets called by forge, then it passes the parameters through to renderEntity().
	 */
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		renderEntity(entity, x, y, z, yaw, partialTickTime);
		
	}

	/*
	 * Returning the texture of the entity.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
