package cz.d12kdev.higames.hgbasics.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ControlPlayerEvent{
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand(); // gets the item in the player's main hand
        player.sendMessage("You used a " + item.getType() + "!");
    }
}
