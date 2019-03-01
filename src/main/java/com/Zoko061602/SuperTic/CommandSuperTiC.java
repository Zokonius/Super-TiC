package com.Zoko061602.SuperTic;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;

public class CommandSuperTiC extends CommandBase {

	private final ArrayList<String> aliases;

    public CommandSuperTiC(){
        aliases = new ArrayList<String>();
        aliases.add("supertic");
    }

	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "supertic";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "supertic";
	}

	@Override
	public List<String> getAliases() {
		return aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		 if (args.length == 0) {
		      sender.sendMessage(new TextComponentTranslation("§3Invalid arguments", new Object[0]));
		      sender.sendMessage(new TextComponentTranslation("§3Use /supertic help to get help", new Object[0]));
		      return;
		    }

		    if (args[0].equalsIgnoreCase("reload")) {
				ConfigHandler.readConfig(SuperTic.xmlConfigFile);
			      sender.sendMessage(new TextComponentTranslation("§3Success!", new Object[0]));
		      }

		    else if (args[0].equalsIgnoreCase("help")) {
		        sender.sendMessage(new TextComponentTranslation("§3Use this to reload the config.", new Object[0]));
		        sender.sendMessage(new TextComponentTranslation("  /supertic reload", new Object[0]));
		        sender.sendMessage(new TextComponentTranslation("§3Use this to get a list of all materials", new Object[0]));
		        sender.sendMessage(new TextComponentTranslation("  /supertic materials", new Object[0]));
		      }

		    else if (args[0].equalsIgnoreCase("materials")) {
		        sender.sendMessage(new TextComponentTranslation("§3===Materials===", new Object[0]));
		        for(String s:SuperEventHandler.materials)
			        sender.sendMessage(new TextComponentTranslation(s, new Object[0]));

		      }

		    }

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

}
