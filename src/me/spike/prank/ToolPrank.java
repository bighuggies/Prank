package me.spike.prank;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ToolPrank extends PlayerListener {
	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();		
		Inventory i = p.getInventory();
		ItemStack itemUsed = event.getItem();
		
		if (itemUsed != null) {
			int emptySlot = i.firstEmpty();
			int slotUsed = i.first(itemUsed);

			i.clear(slotUsed);
			i.setItem(emptySlot, itemUsed);
		}
		
		super.onPlayerInteract(event);
	}

}
