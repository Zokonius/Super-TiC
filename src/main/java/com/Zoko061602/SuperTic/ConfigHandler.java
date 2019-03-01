package com.Zoko061602.SuperTic;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.Zoko061602.SuperTic.MaterialEffect.EnumEffectType;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;;

public class ConfigHandler extends DefaultHandler {

	public static HashMap<String,MaterialEffect[]> map = new HashMap<>();

	ArrayList<MaterialEffect> list = new ArrayList<>();
	String materialName;
	MaterialEffect effect = null;
	EnumEffectType type = null;


	public static void readConfig(File file) {
	 map.clear();
	 SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	 try {
	  SAXParser saxParser = saxParserFactory.newSAXParser();
	  saxParser.parse(file, new ConfigHandler());
	 }
     catch(Exception ex){}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("effects"))return;

		if(qName.equals("material")) {
			materialName = attributes.getValue("name");
			return;
		}

		if(qName.equals("attack"))type=EnumEffectType.ATTACK;
		if(qName.equals("block"))type=EnumEffectType.BLOCK;
		if(qName.equals("mine"))type=EnumEffectType.MINE;
		if((effect=makeEffect(type, attributes))!=null)list.add(effect);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
      if(qName.equals("material"))
       if(!map.containsKey(materialName)){
    	MaterialEffect[] a = new MaterialEffect[list.size()];
    	 map.put(materialName, list.toArray(a));
    	 list.clear();
       }
	}

	private MaterialEffect makeEffect(MaterialEffect.EnumEffectType type,Attributes attributes){
		String pot = attributes.getValue("id");
		String amp = attributes.getValue("amp");
		String dur = attributes.getValue("dur");
		String cha = attributes.getValue("chance");
		String pla = attributes.getValue("player");

		Potion potion = null;
		int amplifier;
		int duration;
		int chance;
		boolean player;

		try {
		    amplifier = Integer.valueOf(amp);
		    duration = Integer.valueOf(dur);
		    chance = Integer.valueOf(cha);

		   if(pla==null)player=true;
		   else if(pla.equals("false"))player=false;
		   else player = true;
		}

		catch(Exception ex){
			 amplifier = 0;
			 duration = 0;
			 chance = 0;
			 player = true;

		}

		if(pot==null||amp==null||dur==null||cha==null)return null;

		if(Potion.getPotionFromResourceLocation(pot)!=null)
			potion = Potion.getPotionFromResourceLocation(pot);
		else if(Integer.getInteger(pot)!=null)
			potion = Potion.getPotionById(Integer.getInteger(pot));
		else return null;

		return new MaterialEffect(type, chance, new PotionEffect(potion, duration, amplifier-1), player);
	}

}