package com.Zoko061602.SuperTic;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.common.config.Configuration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

public class Config {

	  public static Map<String, Material> materials;

      public static HashMap<String, Integer> id_eff = new HashMap<String,Integer>();
      public static HashMap<String, Integer> id_dur = new HashMap<String,Integer>();
      public static HashMap<String, Integer> id_amp = new HashMap<String,Integer>();
      public static HashMap<String, Integer> id_prob = new HashMap<String,Integer>();

      private static Configuration mainconf;
      private static Configuration idconf;

   	  public static void idConfig(File f){
   	   reflect();
   	    idconf = new Configuration(f);
        idconf.load();
    	 for(Material m:materials.values()) {
          id_eff.put(m.getIdentifier(), idconf.getInt("Effect", m.getIdentifier(), 0, -255, 255,"Effect id (if negative gets applied to player)"));
          id_dur.put(m.getIdentifier(), idconf.getInt("Duration", m.getIdentifier(), 200, 1, Integer.MAX_VALUE,""));
          id_amp.put(m.getIdentifier(), idconf.getInt("Amplifier", m.getIdentifier(), 1, 1, Integer.MAX_VALUE,"")-1);
          id_prob.put(m.getIdentifier(),idconf.getInt("Probability", m.getIdentifier(), 1, 1, Integer.MAX_VALUE,"Chance effect gets applied 1 in X"));
	     }
    	idconf.save();
    	}

   	  public static void mainConfig(File f){
   		  mainconf = new Configuration(f);
   		  mainconf.load();
   		  mainconf.save();
   	  }

   	  private static void reflect(){
   		  try {
   			  Field f = TinkerRegistry.class.getDeclaredField("materials");
   			  f.setAccessible(true);
   			  materials = (Map<String, Material>) f.get(Map.class);
   		  }
   		  catch(Exception ex){
   			  ex.printStackTrace();
   		  }
   	  }
}

