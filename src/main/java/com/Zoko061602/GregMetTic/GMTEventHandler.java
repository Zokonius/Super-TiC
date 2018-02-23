package com.Zoko061602.GregMetTic;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class GMTEventHandler {
	
	@SubscribeEvent
	public void PlayerAttack(AttackEntityEvent event){
		 PotionEventHandler.getInstance().applyEffects(event);	
	}

	@SubscribeEvent
	public void Tooltip(ItemTooltipEvent event){
		 TooltipEventHandler.getInstance().addTooltips(event);	
	}
	
}
