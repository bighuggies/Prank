package me.spike.prank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationManager {
	private static final ConfigurationManager instance = new ConfigurationManager();
	
	private final Properties prop = new Properties();
	private final File cfg = new File("plugins" + File.separator + "prank.cfg");
	
	private ConfigurationManager(){}
	
	public static ConfigurationManager getConfigurationManager(){
		return instance;
	}
	
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
	
	public void turnPrankOn(String player, String prankType) {
		prop.setProperty(player + "." + prankType, "true");
		saveConfiguration();
	}
	
	public void turnPrankOff(String player, String prankType) {
		prop.setProperty(player + "." + prankType, "false");
		saveConfiguration();
	}
}
