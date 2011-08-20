package me.spike.prank;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PrankCommand implements CommandExecutor {

	private static final PrankCommand instance = new PrankCommand();
	private static final ConfigurationManager config = ConfigurationManager.getConfigurationManager();

	private PrankCommand(){}

	public static PrankCommand getPrankExecutor() {
		return instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
		if (split.length < 2) {
			return false;
		}
		
        String subcommand = split[0];
        String target = split[1];
        
        // Check that the player has permission to prank the target
        if (!checkPerm(sender, target) && !checkPerm(sender, "boss")) return true;
        
        if (subcommand.equals("creeper")) {
        	if (!checkPerm(sender, "creeper")) return true;
        	config.turnPrankOn(target, "creeper");
        }
        
        if (subcommand.equals("toolswitch")) {
        	if (!checkPerm(sender, "toolswitch")) return true;
        	config.turnPrankOn(target, "toolswitch");
        }
        
		return false;
	}


	private boolean checkPerm(CommandSender sender, String subnode) {
		boolean ok = sender.hasPermission("prank." + subnode);
		if (!ok) {
			sender.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
		}
		return ok;
	}

}
