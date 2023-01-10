package cz.d12kdev.higames.hgbasics.features;

import cz.d12kdev.higames.hgbasics.Hgbasics;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
                   //NBT 1
                   NBTItem nw1 = new NBTItem(w1);
                   nw1.setString("act", "xforward");
                   nw1.setString("plr", targetplr.getName());
                   nw1.applyNBT(w1);
                   ItemMeta w1m = w1.getItemMeta();
                   w1m.setDisplayName(ChatColor.RESET + "X Forward");
                   w1.setItemMeta(w1m);

                   ItemStack w2 = new ItemStack(Material.BLAZE_ROD);
                   //NBT 2
                   NBTItem nw2 = new NBTItem(w2);
                   nw2.setString("act", "xback");
                   nw2.setString("plr", targetplr.getName());
                   nw2.applyNBT(w2);
                   ItemMeta w2m = w2.getItemMeta();
                   w2m.setDisplayName(ChatColor.RESET + "X Back");
                   w2.setItemMeta(w2m);
                   plr.getInventory().addItem(w2);

                   ItemStack w3 = new ItemStack(Material.STICK);
                   //NBT 3
                   NBTItem nw3 = new NBTItem(w3);
                   nw3.setString("act", "zforward");
                   nw3.setString("plr", targetplr.getName());
                   nw3.applyNBT(w3);
                   ItemMeta w3m = w3.getItemMeta();
                   w3m.setDisplayName(ChatColor.RESET + "Z Forward");
                   w3.setItemMeta(w2m);
                   plr.getInventory().addItem(w3);
               }
           }
       }
       return true;
    }
}
