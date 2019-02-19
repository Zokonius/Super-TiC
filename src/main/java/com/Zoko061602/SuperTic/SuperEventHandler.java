package com.Zoko061602.SuperTic;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.events.MaterialEvent.MaterialRegisterEvent;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.ITrait;

@EventBusSubscriber
public class SuperEventHandler {

	@SubscribeEvent
	public static void registerMaterial(MaterialRegisterEvent event){
      event.material.addTrait(new TraitTic(event.material));


	}

}
