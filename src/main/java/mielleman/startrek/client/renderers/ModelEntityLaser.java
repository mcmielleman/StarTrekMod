package mielleman.startrek.client.renderers;

import java.util.ArrayList;

import mielleman.startrek.entities.EntityLaser;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

public class ModelEntityLaser extends ModelBase{
    
	/*
	 * In this class we define the model of the entity.
	 */
	
	/*
	 * The list of parts the model has.
	 */
	private ArrayList<ModelRenderer> parts;
    
	/*
	 * Constructor, initializing the list of parts and the renderer,
	 * and adding the parts.
	 */
    public ModelEntityLaser(){
    	parts = new ArrayList<ModelRenderer>();
    	
    	ModelRenderer main = new ModelRenderer(this);
    	main.addBox(-5, -5, -5, 0, 0, 0);
    	main.setRotationPoint(0, 0, 0);
    	parts.add(main);
    }
    
    /*
     * Rendering the parts here.
     */
    @Override
    public void render(Entity entity, float par1, float par2, float par3, float par4, float par5, float mult) {
    	for (ModelRenderer part : parts){
    		part.render(mult);
    	}
    }
}
