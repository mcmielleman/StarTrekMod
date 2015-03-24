package mielleman.startrek.proxies;

import mielleman.startrek.client.renderers.RenderEntityLaser;
import mielleman.startrek.entities.EntityLaser;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void initSounds() {
		
	}

	@Override
	public void initRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderEntityLaser());
	}

}
