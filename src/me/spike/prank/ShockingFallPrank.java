package me.spike.prank;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

/***
 * Every time a player receives fall damage, they will also be struck by
 * lightning.
 * @author Andrew
 *
 */
public class ShockingFallPrank extends EntityListener {
	private final ConfigurationManager config = ConfigurationManager.getConfigurationManager();

	/**
	 * Respond to damage events.
	 */
	public void onEntityDamage(EntityDamageEvent event) {
		Entity e = event.getEntity();

		if (e instanceof Player) {
			Player p = (Player) e;
			boolean beingPranked = config.checkPrank(p.getName(), "shockingfall");

			if (beingPranked) {
				if (EntityDamageEvent.DamageCause.FALL == event.getCause()) {
					p.getWorld().strikeLightning(p.getLocation());
				}
			}
		}

		super.onEntityDamage(event);
	}
}
