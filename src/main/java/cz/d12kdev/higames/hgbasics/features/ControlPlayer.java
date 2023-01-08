package cz.d12kdev.higames.hgbasics.features;

import cz.d12kdev.higames.hgbasics.Hgbasics;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static cz.d12kdev.higames.hgbasics.PlugConf.prefix;



public class ControlPlayer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        Map<Player, Inventory> savedInventories = new HashMap<>();
        if(!(sender instanceof Player)){
           sender.sendMessage(prefix + " §cOnly player can execute this command...");
           return true;
        } else {
           if(args.length == 0){
               sender.sendMessage(prefix + " §cNo arguments found. Need help fixing this error? /help controlplayer");
           } else {
               Player plr = (Player) sender;
               savedInventories.put(plr, plr.getInventory());
               Player targetplr = (Player) Bukkit.getPlayerExact(args[0]);
               if(targetplr == null){
                   plr.sendMessage(prefix + " §cThe player could not be found");
               } else {
                   World tarworld = targetplr.getWorld();
                   double tx = targetplr.getLocation().x();
                   double pty = targetplr.getLocation().y();
                   double tty = 10.0;
                   double ty = pty + tty;
                   double tz = targetplr.getLocation().z();
                   plr.getInventory().clear();
                   plr.teleport(new Location(tarworld, tx, ty, tz));
                   ItemStack w1 = new ItemStack(Material.BLAZE_ROD);
                   NBTItem nw1 = new NBTItem(w1);
                   nw1.setString("act", "forward");
                   nw1.setString("plr", targetplr.getName());
                   nw1.applyNBT(w1);
                   plr.getInventory().addItem(w1);
               }
           }
       }
       return true;
    }
}
