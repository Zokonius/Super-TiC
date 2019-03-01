package com.Zoko061602.SuperTic;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitTic extends AbstractTrait {

	String material;

	public TraitTic(Material m) {
		super("trait_supertic_" + m.getIdentifier(), 0x3A8998);
		material = m.getIdentifier();
	}

	@Override
	public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
		super.onHit(tool, player, target, damage, isCritical);
        MaterialEffect[] eff = ConfigHandler.map.get(material);
        if(eff!=null&&eff.length!=0)
        for(MaterialEffect ef:eff){
        	int r = new Random().nextInt(ef.getChance());
        	if(r==0)
        	 if(ef.isPlayerEffect()) player.addPotionEffect(new PotionEffect(ef.getPotion(), ef.getDuration(), ef.getAmplifier()));
        	 else target.addPotionEffect(new PotionEffect(ef.getPotion(), ef.getDuration(), ef.getAmplifier()));
        }
	}

	@Override
	public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
		super.onBlock(tool, player, event);
        MaterialEffect[] eff = ConfigHandler.map.get(material);
        if(eff!=null&&eff.length!=0)
        for(MaterialEffect ef:eff){
        	int r = new Random().nextInt(ef.getChance());
        	if(r==0)
           	 if(ef.isPlayerEffect()) player.addPotionEffect(new PotionEffect(ef.getPotion(), ef.getDuration(), ef.getAmplifier()));
           	 else event.getEntityLiving().addPotionEffect(new PotionEffect(ef.getPotion(), ef.getDuration(), ef.getAmplifier()));
        }
	}

	@Override
	public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
		super.afterBlockBreak(tool, world, state, pos, player, wasEffective);
        MaterialEffect[] eff = ConfigHandler.map.get(material);
        if(eff!=null&&eff.length!=0)
        for(MaterialEffect ef:eff){
        	int r = new Random().nextInt(ef.getChance());
        	if(r==0)
        		if(ef.isPlayerEffect())player.addPotionEffect(new PotionEffect(ef.getPotion(), ef.getDuration(), ef.getAmplifier()));
        }
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
