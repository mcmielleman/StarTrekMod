package mielleman.startrek.renderers;

import java.util.ArrayList;

import mielleman.startrek.entities.EntityLaser;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

public class ModelEntityLaser extends ModelBase{
    private ArrayList<ModelRenderer> parts;
    
    public ModelEntityLaser(){
    	parts = new ArrayList<ModelRenderer>();
    	
    	ModelRenderer main = new ModelRenderer(this);
    	main.addBox(-5, -5, -5, 0, 0, 0);
    	main.setRotationPoint(0, 0, 0);
    	parts.add(main);
    }
    @Override
    public void render(Entity entity, float par1, float par2, float par3, float par4, float par5, float mult) {
    	for (ModelRenderer part : parts){
    		part.render(mult);
    	}
    	if(entity instanceof EntityLaser){
    	    EntityLaser laser = (EntityLaser)entity;
    	    EntityPlayer player = laser.getOwner();
    	    if(player != null){
                Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawing(GL11.GL_LINES);
   	            tessellator.setBrightness(5);
    	        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
   	            tessellator.addVertex(laser.posX, laser.posY, laser.posZ);
      	        tessellator.addVertex(player.getLookVec().xCoord, player.getLookVec().yCoord, player.getLookVec().zCoord);
                System.out.println("yeehaa");
    	    }
        }
    }
}
