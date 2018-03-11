package com.Zoko061602.SuperTic;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=SuperTic.ModId,name=SuperTic.ModName,version=SuperTic.Version,dependencies="required-after:TConstruct;after:ExtraTic;after:TGregworks")
public class SuperTic {
    
	public static final String ModId = "SuperTic";
	public static final String ModName = "SuperTic";
	public static final String Version = "1.1.0";
	
	@Instance
	public static SuperTic Instace = new SuperTic();
	private File conf;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	conf = e.getSuggestedConfigurationFile();
    	
    	
    	MinecraftForge.EVENT_BUS.register(new SuperEventHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
    	Config.Configurate(conf);
    }
}
