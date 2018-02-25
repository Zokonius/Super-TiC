package com.Zoko061602.GregMetTic;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=GregMetTic.ModId,name=GregMetTic.ModName,version=GregMetTic.Version,dependencies="required-after:TConstruct;after:ExtraTic;after:TGregworks")
public class GregMetTic {
    
	public static final String ModId = "GregMetTic";
	public static final String ModName = "GregMetTic";
	public static final String Version = "sin(pi)";
	
	@Instance
	public static GregMetTic Instace = new GregMetTic();
	private File conf;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	conf = e.getSuggestedConfigurationFile();
    	
    	
    	MinecraftForge.EVENT_BUS.register(new GMTEventHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
    	Config.Configurate(conf);
    }
}
