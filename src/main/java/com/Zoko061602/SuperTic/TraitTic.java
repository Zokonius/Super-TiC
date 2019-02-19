package com.Zoko061602.SuperTic;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitTic extends AbstractTrait {
	Material material;

	public TraitTic(Material m) {
		super("trait_supertic_"+m.getIdentifier(), 0x3A8998);
		material =m;
	}

	@Override
	public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
		super.onHit(tool, player, target, damage, isCritical);
		  int id = Config.id_eff.get(material.getIdentifier());
		  if(id==0)return;
		  int r=new Random().nextInt(Config.id_prob.get(material.getIdentifier()));
		   if(r==0)
			   if(id>0) target.addPotionEffect(new PotionEffect(Potion.getPotionById(id),Config.id_dur.get(material.getIdentifier()),Config.id_amp.get(material.getIdentifier())));
			   else player.addPotionEffect(new PotionEffect(Potion.getPotionById(id*-1),Config.id_dur.get(material.getIdentifier()),Config.id_amp.get(material.getIdentifier())));
	}

	@Override
	public String getLocalizedDesc() {
		return "Tool has a chance to add a predefined Potion effect to either the player or a entity";
	}

	@Override
	public String getLocalizedName() {
		return "Super";
	}

}
