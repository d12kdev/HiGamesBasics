package cz.d12kdev.higames.hgbasics.features;

import cz.d12kdev.higames.hgbasics.Hgbasics;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import static cz.d12kdev.higames.hgbasics.PlugConf.prefix;

public class Vanish implements CommandExecutor {


    Hgbasics vnsh;

    public Vanish(Hgbasics vnsh) {
        this.vnsh = vnsh;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(prefix + " §cOnly player can execute this command...");
            return true;
        } else {
            Player plr = (Player) sender;
            if(vnsh.vplrs.contains(plr)){
                for (Player ppls : Bukkit.getOnlinePlayers()){
                    ppls.showPlayer(vnsh, plr);
                }
                vnsh.vplrs.remove(plr);
                plr.sendActionBar("§cUnvanished. §fNow players can see you!");
                plr.sendMessage("§aUnvanished!");
            } else if(!vnsh.vplrs.contains(plr)){
                for (Player ppls : Bukkit.getOnlinePlayers()){
                    if(!ppls.hasPermission("hgb.vnshsee")){
                        ppls.hidePlayer(vnsh, plr);
                    }
                }
                vnsh.vplrs.add(plr);
                plr.sendActionBar("§aVanished. §fNow players can't see you!");
                plr.sendMessage("§aVanished!");
            }
        }
        return true;
    }
}
