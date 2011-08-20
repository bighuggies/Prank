package me.spike.prank;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrankPlugin extends JavaPlugin {
	
	private static final PrankCommand prankExecutor = PrankCommand.getPrankExecutor();
	private static final ConfigurationManager config = ConfigurationManager.getConfigurationManager();

	@Override
	public void onEnable() {
		// Get a pluginmanager
		PluginManager pm = getServer().getPluginManager();
		config.loadConfiguration();
		
		ToolPrank tp = new ToolPrank();
		pm.registerEvent(Event.Type.PLAYER_INTERACT, tp, Event.Priority.Normal, this);

		
		// Get a command executor
		getCommand("prank").setExecutor(prankExecutor);

		// Shutdown message
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	}

	@Override
	public void onDisable() {		
		// Startup message
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled!" );
	}
}
