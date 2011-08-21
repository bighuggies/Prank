package me.spike.prank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/***
 * A singleton which handles the configuration of the plugin by keeping track
 * of a Properties instance. Properties persist by being written to prank.cfg.
 * Configuration options include turning pranks on and off for a player and
 * checking whether or not a player is being pranked.
 * @author Andrew
 *
 */
public class ConfigurationManager {
	private static final ConfigurationManager instance = new ConfigurationManager();

	private final Properties prop = new Properties();
	private final File cfg = new File("plugins" + File.separator + "prank.cfg");

	private ConfigurationManager(){}

	public static ConfigurationManager getConfigurationManager(){
		return instance;
	}

	/**
	 * Saves configuration to disk in a file called prank.cfg. If no 
	 * configuration file exists, one is created.
	 */
	private void saveConfiguration() {
		try {
			FileOutputStream cfgWriter = new FileOutputStream(cfg);
			prop.store(cfgWriter, "Be careful when manually editing this file!");
			cfgWriter.flush();
			cfgWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load the configuration from disk. If no configuration file exists, one is
	 * created.
	 */
	public void loadConfiguration() {
		try {
			FileInputStream cfgReader = new FileInputStream(cfg);
			prop.load(cfgReader);
			cfgReader.close();
		} catch (FileNotFoundException e) {
			saveConfiguration();
			loadConfiguration();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Turns the given prank on for a given player by setting the property to
	 * "true".
	 * @param player The player to be pranked
	 * @param prankType The prank to be applied to the player
	 */
	public void turnPrankOn(String player, String prankType) {
		prop.setProperty(player + "." + prankType, "true");
		saveConfiguration();
	}

	/**
	 * Turns the given prank off for a given player by setting the property to
	 * "false".
	 * @param player The player to stop being pranked
	 * @param prankType The prank to be turned off for the player
	 */
	public void turnPrankOff(String player, String prankType) {
		prop.setProperty(player + "." + prankType, "false");
		saveConfiguration();
	}

	/**
	 * Checks whether the given player is being pranked with the given prank.
	 * @param player The player to be checked
	 * @param prankType The prank type to be checked
	 * @return Whether or not the player is being pranked
	 */
	public boolean checkPrank(String player, String prankType) {
		if (prop.getProperty(player + "." + prankType).equals("true")) return true;
		return false;
	}
}
