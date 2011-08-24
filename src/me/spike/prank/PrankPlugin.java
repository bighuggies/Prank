package me.spike.prank;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/***
 * Main plugin class which registers with the plugin manager.
 * @author Andrew
 *
 */
public class PrankPlugin extends JavaPlugin {
	// Get a command executor and configuration manager to execute pranks
	private final PrankCommand prankExecutor = PrankCommand.getPrankExecutor();
	private final ConfigurationManager config = ConfigurationManager.getConfigurationManager();

	/**
	 * Executed when the plugin is enabled
	 */
	public void onEnable() {
		// Get a pluginmanager
		PluginManager pm = getServer().getPluginManager();
		config.loadConfiguration();
		
		pm.registerEvent(Event.Type.PLAYER_INTERACT, new ToolPrank(), Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_MOVE, new CreeperPrank(), Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, new ShockingFallPrank(), Event.Priority.Normal, this);
		
		// Get a command executor
		getCommand("prank").setExecutor(prankExecutor);
		getCommand("unprank").setExecutor(prankExecutor);

		// Shutdown message
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	}

	/**
	 * Executed when the plugin is disabled
	 */
	public void onDisable() {		
		// Startup message
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled!" );
	}
}
