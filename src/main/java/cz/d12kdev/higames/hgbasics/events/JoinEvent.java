package cz.d12kdev.higames.hgbasics.events;

import cz.d12kdev.higames.hgbasics.Hgbasics;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    Hgbasics vnsh;

    public JoinEvent(Hgbasics vnsh) {
        this.vnsh = vnsh;
    }

    @EventHandler
    public void PlayerJoined(PlayerJoinEvent e){
        Player plr = e.getPlayer();
        for(int i = 0; i < vnsh.vplrs.size(); i++){
            if(!plr.hasPermission("hgb.vnshsee")){
                plr.hidePlayer(vnsh, vnsh.vplrs.get(i));
            }
        }
    }
}
