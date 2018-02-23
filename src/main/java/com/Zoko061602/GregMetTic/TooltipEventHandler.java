package com.Zoko061602.GregMetTic;

import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import tconstruct.library.util.IToolPart;

public class TooltipEventHandler {

	 private static TooltipEventHandler INSTANCE = new TooltipEventHandler();

	  
	  public static TooltipEventHandler getInstance(){
	    return INSTANCE;
	  }
	  
	public void addTooltips(ItemTooltipEvent event){
      Item item = event.itemStack.getItem(); 
      int id = 0;
	   if(item instanceof IToolPart){
	    id = Config.eff.get(((IToolPart)item).getMaterialID(event.itemStack));		       
		 if(id<0)id*=-1;
		 if(id>0)
		  event.toolTip.add("§3"+StatCollector.translateToLocal(new PotionEffect(id,1).getEffectName()));
	     }
				
    }      	
	
}