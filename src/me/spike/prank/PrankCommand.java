package me.spike.prank;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/***
 * Command handler which takes care of handling user input.
 * @author Andrew
 *
 */
public class PrankCommand implements CommandExecutor {

	private final static PrankCommand instance = new PrankCommand();
	private final ConfigurationManager config = ConfigurationManager.getConfigurationManager();

	private PrankCommand(){}

	public static PrankCommand getPrankExecutor() {
		return instance;
	}

	/**
	 * Reacts to users commands. The first argument must always
	 * be "prank", with the subarguments specifying which prank
	 * is to be applied to which player.
	 * Commands handled:
	 * 		- creeper
	 * 		- toolswitch
	 */
	public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
		// If there is no prank and no player specified, do nothing
		if (split.length < 2) {
			return false;
		}
		
        String prank = split[0];
        String target = split[1];
        
        // Check that the player has permission to prank the target
        if (!checkPerm(sender, target) && !checkPerm(sender, "boss")) return true;
        
        // Creeper prank the player
        if (prank.equals("creeper")) {
        	if (!checkPerm(sender, "creeper")) return true;
        	config.turnPrankOn(target, "creeper");
        }
        
        // Tool switch prank the player
        if (prank.equals("toolswitch")) {
        	if (!checkPerm(sender, "toolswitch")) return true;
        	config.turnPrankOn(target, "toolswitch");
        }
        
		return false;
	}

	/**
	 * Check if the sender has permission to execute the given command.
	 * @param sender The sender of the command
	 * @param subnode The name of the permission
	 * @return If the user has permission, return true
	 */
	private boolean checkPerm(CommandSender sender, String subnode) {
		boolean permission = sender.hasPermission("prank." + subnode);
		if (!permission) {
			sender.sendMessage(ChatColor.RED + "You do not have permissions to do that.");
		}
		return permission;
	}

}
