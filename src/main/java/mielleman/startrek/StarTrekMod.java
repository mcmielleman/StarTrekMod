package mielleman.startrek;

import mielleman.startrek.entities.ModEntities;
import mielleman.startrek.items.ModItems;
import mielleman.startrek.proxies.CommonProxy;
import mielleman.startrek.reference.References;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class StarTrekMod {
	
	
	/*
	 * Creating the instance of the mod here, this is used in registering renderers, etc...
	 */
	@Mod.Instance(References.MODID)
	public static StarTrekMod instance;
	
	/*
	 * Registering the proxies here.
	 */
	@SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.SERVERPROXY)
	public static CommonProxy proxy;

	/*
	 * PriInit, registering sounds, renderers, items (and blocks).
	 */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.initSounds();
    	proxy.initRenderers();
    	ModItems.init();

    }

    /*
     * Init, registering entities.
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    	ModEntities.init();
    }

    /*
     * PostInit, doing compatibility with other mods here.
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}


