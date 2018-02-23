package com.Zoko061602.GregMetTic;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;
import tconstruct.library.TConstructRegistry;

public class Config {
	
      public static	HashMap<Integer, Integer> eff = new HashMap<Integer,Integer>();
      public static	HashMap<Integer, Integer> dur = new HashMap<Integer,Integer>();
      public static	HashMap<Integer, Integer> amp = new HashMap<Integer,Integer>();
      
      static Configuration conf;
      
      
	public static void Configurate(File file) {		
     	conf = new Configuration(file);
     	conf.load();
     	for(int i=0;!(i==3000);i++)
            if(TConstructRegistry.toolMaterials.get(i)!=null){    		
            	eff.put(i, conf.getInt("Effect", TConstructRegistry.toolMaterials.get(i).materialName, 0, -255, 255,"Effect id (if negative gets applied to player)"));
            	dur.put(i, conf.getInt("Duration", TConstructRegistry.toolMaterials.get(i).materialName, 200, 1, Integer.MAX_VALUE,""));
            	amp.put(i, conf.getInt("Amplifier", TConstructRegistry.toolMaterials.get(i).materialName, 1, 1, Integer.MAX_VALUE,"")-1);
	}
     	conf.save();
	}
	}
	
