package cz.d12kdev.higames.hgbasics.events;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import static cz.d12kdev.higames.hgbasics.PlugConf.prefix;

public class ControlPlayerEvent implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand(); // gets the item in the player's main hand
        NBTItem used = new NBTItem(item);
        String targetname = used.getString("plr");
        String action = used.getString("act");
        Player target = Bukkit.getPlayerExact(targetname);
        if(target == null){
            player.sendMessage(prefix + " §cTarget Player not found");
            player.sendActionBar("§c§lError! §r Look into chat");
        } else {
            if(action == "xforward"){
                Vector add = new Vector(0.5,0,0);
                Vector direction = target.getLocation().getDirection().add(add);
                target.setVelocity(direction);
            }
        }
    }
}
