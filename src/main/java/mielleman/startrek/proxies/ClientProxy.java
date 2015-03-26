package mielleman.startrek.proxies;

import mielleman.startrek.client.renderers.RenderEntityLaser;
import mielleman.startrek.entities.EntityLaser;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
	/*
	 * CLient proxy, used for things that only need to happend on the client.
	 */
	
	/*
	 * Initing the sounds.
	 */
	@Override
	public void initSounds() {
		
	}

	/*
	 * Initing the renderers.
	 */
	@Override
	public void initRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderEntityLaser());
	}

}
