package com.spikemeister.prank;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/***
 * Implements the "toolswitch" prank. Whenever the user tries to use their
 * equipped item, it moves into the first empty slot of their inventory.
 * 
 * @author Andrew
 * 
 */
public class ToolPrank implements Listener {
	private final ConfigurationManager config = ConfigurationManager
			.getConfigurationManager();

	/**
	 * Whenever the user clicks a mouse button (interacts), switch their
	 * equipped item into the first empty slot.
	 */
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		boolean beingPranked = config.checkPrank(p.getName(), "toolswitch");

		if (beingPranked) {
			Inventory i = p.getInventory();
			ItemStack itemUsed = event.getItem();

			if (itemUsed != null) {
				int emptySlot = i.firstEmpty();
				System.out.println(emptySlot);

				// Don't do anything if the user has a full inventory
				if (!(emptySlot < 0)) {
					p.setItemInHand(null);
					i.setItem(emptySlot, itemUsed);
				}
			}
		}
	}
}