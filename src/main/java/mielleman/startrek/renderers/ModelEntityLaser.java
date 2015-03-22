package mielleman.startrek.renderers;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEntityLaser extends ModelBase{
    private ArrayList<ModelRenderer> parts;
    
    public ModelEntityLaser(){
    	parts = new ArrayList<ModelRenderer>();
    	
    	ModelRenderer main = new ModelRenderer(this);
    	main.addBox(-5, -5, -5, 5, 0, 100);
    	main.setRotationPoint(0, 0, 0);
    	parts.add(main);
    }
    
    @Override
    public void render(Entity entity, float par1, float par2, float par3, float par4, float par5, float mult) {
    	for (ModelRenderer part : parts){
    		part.render(mult);
    	}
    }
}
