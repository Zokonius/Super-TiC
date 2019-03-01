package com.Zoko061602.SuperTic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid=SuperTic.ModId,name=SuperTic.ModName,version=SuperTic.Version,dependencies="required-after:tconstruct")
public class SuperTic {

	public static final String ModId = "supertic";
	public static final String ModName = "SuperTic";
	public static final String Version = "2.1.0";

	@Instance
	public static SuperTic Instance = new SuperTic();

    public static File xmlConfigFile;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) throws IOException {
    	new File(e.getModConfigurationDirectory(),"/SuperTic").mkdir();
    	xmlConfigFile= new File(e.getModConfigurationDirectory(),"/SuperTic/effects.xml");
    	if(xmlConfigFile.createNewFile()){
         BufferedWriter writer = new BufferedWriter(new FileWriter(xmlConfigFile, true));
         writer.write("<effects>\r\n"+"\r \n"+"</effects> ");
         writer.close();
    	}
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
     ConfigHandler.readConfig(xmlConfigFile);
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){
     event.registerServerCommand(new CommandSuperTiC());
    }

}

