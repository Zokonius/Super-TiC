package com.Zoko061602.SuperTic;

import java.util.ArrayList;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.events.MaterialEvent.MaterialRegisterEvent;

@EventBusSubscriber
public class SuperEventHandler {

	public static ArrayList<String> materials = new ArrayList<>();

	@SubscribeEvent
	public static void registerMaterial(MaterialRegisterEvent event){
	  materials.add(event.material.getIdentifier());
      event.material.addTrait(new TraitTic(event.material));
	}

}
