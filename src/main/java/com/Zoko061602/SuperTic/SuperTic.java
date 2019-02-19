package com.Zoko061602.SuperTic;

import java.io.File;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=SuperTic.ModId,name=SuperTic.ModName,version=SuperTic.Version,dependencies="required-after:tconstruct")
public class SuperTic {

	public static final String ModId = "supertic";
	public static final String ModName = "SuperTic";
	public static final String Version = "2.0.0";

	@Instance
	public static SuperTic Instance = new SuperTic();
    public static File idConfigFile;
    public static File mainConfigFile;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	idConfigFile= new File(e.getModConfigurationDirectory(),"/SuperTiC/effects.cfg");
    	mainConfigFile = new File(e.getModConfigurationDirectory(),"/SuperTiC/main.cfg");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
     Config.mainConfig(mainConfigFile);
     Config.idConfig(idConfigFile);
    }
}

