package com.Zoko061602.SuperTic;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class MaterialEffect {

	private final EnumEffectType type;
	private final int chance;
	private final PotionEffect potion;
	private final boolean player;

	public MaterialEffect(EnumEffectType type, int chance, PotionEffect potion, boolean playerEffect) {
		this.type=type;
		this.chance=chance;
		this.potion=potion;
		this.player=playerEffect;
	}

	public int getAmplifier() {
		return potion.getAmplifier();
	}

	public int getDuration() {
		return potion.getDuration();
	}

	public int getChance() {
		return chance;
	}

	public Potion getPotion() {
		return potion.getPotion();
	}

	public EnumEffectType getType() {
		return type;
	}

	public boolean isPlayerEffect() {
		return player;
	}

	public enum EnumEffectType {
		ATTACK,
		BLOCK,
		MINE
	}

}
