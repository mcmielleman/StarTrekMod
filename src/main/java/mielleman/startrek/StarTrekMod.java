package mielleman.startrek;

import mielleman.startrek.items.ModItems;
import mielleman.startrek.proxies.IProxy;
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
	public static IProxy proxy;
	
	
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	ModItems.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}


