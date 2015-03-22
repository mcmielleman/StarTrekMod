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
	
	@Mod.Instance(References.MODID)
	public static StarTrekMod instance;
	
	@SidedProxy(clientSide = References.CLIENTPROXY, serverSide = References.SERVERPROXY)
	public static CommonProxy proxy;
	
	
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.initSounds();
    	proxy.initRenderers();
    	ModItems.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    	ModEntities.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}


