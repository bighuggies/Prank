package com.spikemeister.prank;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/***
 * Every time a player receives fall damage, they will also be struck by
 * lightning.
 * 
 * @author Andrew
 * 
 */
public class ShockingFallPrank implements Listener {
	private final ConfigurationManager config = ConfigurationManager
			.getConfigurationManager();

	/**
	 * Respond to damage events.
	 */
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		Entity e = event.getEntity();

		if (e instanceof Player) {
			Player p = (Player) e;
			boolean beingPranked = config.checkPrank(p.getName(),
					"shockingfall");

			if (beingPranked) {
				if (EntityDamageEvent.DamageCause.FALL == event.getCause()) {
					p.getWorld().strikeLightning(p.getLocation());
				}
			}
		}
	}
}