package cz.d12kdev.higames.hgbasics.features;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cz.d12kdev.higames.hgbasics.PlugConf.prefix;

public class EnderSee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + " §cOnly player can execute this command...");
            return true;
        } else {
            Player plr = (Player) sender;
            if(args.length == 0){
                plr.sendMessage(prefix + " §cNo arguments found. Need help fixing this error? /help esee");
                return true;
            } else {
                Player targetplr = Bukkit.getPlayerExact(args[0]);
                if(targetplr == null){
                    plr.sendMessage(prefix + " §cThe player could not be found");
                    return true;
                } else {
                    plr.openInventory(targetplr.getEnderChest());
                }
            }
        }
        return true;
    }
}
