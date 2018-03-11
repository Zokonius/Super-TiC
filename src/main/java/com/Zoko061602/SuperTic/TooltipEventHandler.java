package com.Zoko061602.SuperTic;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.tools.ToolCore;
import tconstruct.library.tools.ToolMaterial;
import tconstruct.library.util.IToolPart;

public class TooltipEventHandler {

	 private static TooltipEventHandler INSTANCE = new TooltipEventHandler();

	  
	  public static TooltipEventHandler getInstance(){
	    return INSTANCE;
	  }
	
	  public void addTooltips(ItemTooltipEvent e){
		  addPartTooltips(e);
		  addPotionTooltips(e);
		  addGregTooltips(e);
		  
	  }
	
	public void addPartTooltips(ItemTooltipEvent e) {
		 if(e.itemStack==null)return;
		  if(e.itemStack.getItem()==null)return;		 
		   Item item = e.itemStack.getItem(); 
		      int id = 0;
		      if(item instanceof IToolPart){
			    id = Config.eff.get(((IToolPart)item).getMaterialID(e.itemStack));		       			 
				 if(id>0)
		    		 e.toolTip.add(EnumChatFormatting.DARK_AQUA+StatCollector.translateToLocal(new PotionEffect(id,1).getEffectName())+getLatin(Config.amp.get(id)));				 
		      }
     			 if(id<0){
					 id*=-1;
					 e.toolTip.add(EnumChatFormatting.AQUA+StatCollector.translateToLocal(new PotionEffect(id,1).getEffectName())+getLatin(Config.amp.get(id)));
				 }
	  }
	
	public void addPotionTooltips(ItemTooltipEvent e){
		if(e.itemStack==null)return; 
		if(e.itemStack.getItem()==null)return;
			  if(e.itemStack.getItem() instanceof ToolCore){
				  ToolCore core = (ToolCore)e.itemStack.getItem();
				  NBTTagCompound tags = e.itemStack.getTagCompound();
				  
				  
				  PotionEffect head = new PotionEffect(0,1) ;
				  PotionEffect handle = new PotionEffect(0,1); 
				  PotionEffect binding = new PotionEffect(0,1);
				  PotionEffect extra = new PotionEffect(0,1);
				  
				  try{
				  if(!(Config.eff.get(tags.getCompoundTag("InfiTool").getInteger("Head"))==0))
				  head = new PotionEffect(Config.eff.get(tags.getCompoundTag("InfiTool").getInteger("Head")), 1, Config.amp.get(tags.getCompoundTag("InfiTool").getInteger("Head")));
				  if(!(Config.eff.get(tags.getCompoundTag("InfiTool").getInteger("Handle"))==0))
				  handle = new PotionEffect(Config.eff.get(tags.getCompoundTag("InfiTool").getInteger("Handle")), 1, Config.amp.get(tags.getCompoundTag("InfiTool").getInteger("Handle"))); 
				  if(core.getPartAmount()>=3 && !(Config.eff.get(tags.getCompoundTag("InfiTool").getInteger("Accessory"))==0))
				  binding = new PotionEffect(Config.eff.get(tags.getCompoundTag("InfiTool").getInteger("Accessory")), 1, Config.amp.get(tags.getCompoundTag("InfiTool").getInteger("Accessory"))) ;
				  if(core.getPartAmount()==4 && !(Config.eff.get(tags.getCompoundTag("InfiTool").getInteger("Extra"))==0))
				  extra = new PotionEffect(Config.eff.get(tags.getCompoundTag("InfiTool").getInteger("Extra")), 1, Config.amp.get(tags.getCompoundTag("InfiTool").getInteger("Extra"))) ;
				  
				  //Head   
				  if (!(head.getPotionID()==0)){
				      if(head.getPotionID()<0){
				    	 int c=head.getAmplifier();
				    	  if(handle.getPotionID()==head.getPotionID()&&c<handle.getAmplifier())c=handle.getAmplifier();
				    	  if(binding.getPotionID()==head.getPotionID()&&c<binding.getAmplifier())c=binding.getAmplifier();
				    	  if(extra.getPotionID()==head.getPotionID()&&c<extra.getAmplifier())c=extra.getAmplifier();
				    	   e.toolTip.add(1,EnumChatFormatting.AQUA+StatCollector.translateToLocal(new PotionEffect(head.getPotionID()*(-1),1).getEffectName())+getLatin(c));
					      }
				      
				     else{
				    	 int c=head.getAmplifier();
				    	  if(handle.getPotionID()==head.getPotionID()&&c<handle.getAmplifier())c=handle.getAmplifier();
				    	  if(binding.getPotionID()==head.getPotionID()&&c<binding.getAmplifier())c=binding.getAmplifier();
				    	  if(extra.getPotionID()==head.getPotionID()&&c<extra.getAmplifier())c=extra.getAmplifier();
				    	   e.toolTip.add(1,EnumChatFormatting.DARK_AQUA+StatCollector.translateToLocal(new PotionEffect(head.getPotionID(),1).getEffectName())+getLatin(c));
					      }
				     }
				  //Handle
				  if (!(handle.getPotionID()==0)&&!(handle.getPotionID()==head.getPotionID())){
					 if(handle.getPotionID()<0){
					  int c=handle.getAmplifier();
					   if(binding.getPotionID()==handle.getPotionID()&&c<binding.getAmplifier())c=binding.getAmplifier();
					      if(extra.getPotionID()==handle.getPotionID()&&c<extra.getAmplifier())c=extra.getAmplifier();
					    	   e.toolTip.add(1,EnumChatFormatting.AQUA+StatCollector.translateToLocal(new PotionEffect(handle.getPotionID()*(-1),1).getEffectName())+getLatin(c));
						      }
					 
					     else{
					    	 int c=handle.getAmplifier();
					    	  if(binding.getPotionID()==handle.getPotionID()&&c<binding.getAmplifier())c=binding.getAmplifier();
					    	  if(extra.getPotionID()==handle.getPotionID()&&c<extra.getAmplifier())c=extra.getAmplifier();
					    	   e.toolTip.add(1,EnumChatFormatting.DARK_AQUA+StatCollector.translateToLocal(new PotionEffect(handle.getPotionID(),1).getEffectName())+getLatin(c));
						      }
					     }
				     //Binding
				     if(core.getPartAmount()>=3)
				     if (!(binding.getPotionID()==0)&&!(binding.getPotionID()==head.getPotionID())&&!(binding.getPotionID()==handle.getPotionID())){
					      if(binding.getPotionID()<0){
					    	 int c=binding.getAmplifier();
					    	  if(extra.getPotionID()==binding.getPotionID()&&c<extra.getAmplifier())c=extra.getAmplifier();
					    	   e.toolTip.add(1,EnumChatFormatting.AQUA+StatCollector.translateToLocal(new PotionEffect(binding.getPotionID()*(-1),1).getEffectName())+getLatin(c));
						      }
					     else{
					    	 int c=binding.getAmplifier();
					    	  if(extra.getPotionID()==binding.getPotionID()&&c<extra.getAmplifier())c=extra.getAmplifier();
					    	   e.toolTip.add(1,EnumChatFormatting.DARK_AQUA+StatCollector.translateToLocal(new PotionEffect(binding.getPotionID(),1).getEffectName())+getLatin(c));
						      }
					     }
				     //Extra
				     if(core.getPartAmount()==4)
					     if (!(extra.getPotionID()==0)&&!(extra.getPotionID()==head.getPotionID())&&!(extra.getPotionID()==handle.getPotionID())&&!(extra.getPotionID()==binding.getPotionID())){
					      if(extra.getPotionID()<0) e.toolTip.add(1,EnumChatFormatting.AQUA+StatCollector.translateToLocal(new PotionEffect(extra.getPotionID()*(-1),1).getEffectName())+getLatin(extra.getAmplifier()));
					      else e.toolTip.add(1,EnumChatFormatting.DARK_AQUA+StatCollector.translateToLocal(new PotionEffect(extra.getPotionID(),1).getEffectName())+getLatin(extra.getAmplifier()));
						     
					     }

			 } 
				  catch(Exception ex){}
			  }
			  }
				 
		
	public void addGregTooltips(ItemTooltipEvent e){
		 Item item = e.itemStack.getItem(); 
		 ToolMaterial mat = null;;
		 if(item instanceof IToolPart){
			   if(GameRegistry.findUniqueIdentifierFor(item).modId=="TGregworks"){
				    mat = TConstructRegistry.toolMaterials.get(((IToolPart) item).getMaterialID(e.itemStack));
			   if(mat.stonebound>0)e.toolTip.add("Stonebound: x"+mat.stonebound);
			   if(mat.stonebound<0)e.toolTip.add("Jagged: x"+mat.stonebound*-1);
			   if(mat.reinforced!=0) 
			   e.toolTip.add("Reinforced"+getLatin(mat.reinforced));
			  }		
	}		 

}  
	  
		public static String getLatin(int a){
		 String r;
		  switch(a){
		   case 0:r="";
		   case 1:r=" I";break;
		   case 2:r=" II";break;
		   case 3:r=" III";break;
		   case 4:r=" IV";break;
		   case 5:r=" V";break;
		   case 6:r=" VI";break;
		   case 7:r=" VII";break;
		   case 8:r=" VIII";break;
		   case 9:r=" IX";break;
		   case 10:r=" X";break;
		   default:r=" X+";break;
		  }
		  return r;
		} 		
  }
