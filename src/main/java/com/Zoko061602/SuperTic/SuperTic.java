package com.Zoko061602.SuperTic;

import java.io.File;
import java.io.IOException;

import com.Zoko061602.SuperTic.compat.Compat;
import com.google.common.io.Files;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=SuperTic.ModId,name=SuperTic.ModName,version=SuperTic.Version,dependencies="required-after:TConstruct;after:ExtraTic;after:TGregworks;after:Thaumcraft;after:AWWayofTime")
public class SuperTic {
    
	public static final String ModId = "SuperTic";
	public static final String ModName = "SuperTic";
	public static final String Version = "1.2.0";
	
	@Instance
	public static SuperTic Instace = new SuperTic();
    public static File idConfigFile;
    public static File mainConfigFile;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {          	
    	idConfigFile= new File(e.getModConfigurationDirectory(),"/SuperTiC/effects.cfg");
    	mainConfigFile = new File(e.getModConfigurationDirectory(),"/SuperTiC/main.cfg");
    	
    	File config_old= e.getSuggestedConfigurationFile();
    	if(config_old.exists())
			try {
				Files.move(config_old, idConfigFile);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
    	
    	MinecraftForge.EVENT_BUS.register(new SuperEventHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e){   	
    	Config.idConfig(idConfigFile);
    	Config.mainConfig(mainConfigFile);
    	if(Loader.isModLoaded("AWWayofTime")&&Config.BM)
    		Compat.bloody();
    	if(Loader.isModLoaded("Thaumcraft")&&Config.TC&&false)
    		Compat.thaumic();
    }
}
