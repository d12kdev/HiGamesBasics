package cz.d12kdev.higames.hgbasics;

import cz.d12kdev.higames.hgbasics.events.ControlPlayerEvent;
import cz.d12kdev.higames.hgbasics.events.JoinEvent;
import cz.d12kdev.higames.hgbasics.features.ControlPlayer;
import cz.d12kdev.higames.hgbasics.features.EnderSee;
import cz.d12kdev.higames.hgbasics.features.InvSee;
import cz.d12kdev.higames.hgbasics.features.Vanish;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static cz.d12kdev.higames.hgbasics.PlugConf.prefix;

public final class Hgbasics extends JavaPlugin {

    public ArrayList<Player> vplrs = new ArrayList<>();

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(prefix + "Waking up...");
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new ControlPlayerEvent(), this);
        getCommand("vanish").setExecutor(new Vanish(this));
        getCommand("invsee").setExecutor(new InvSee());
        getCommand("esee").setExecutor(new EnderSee());
        getCommand("controlplayer").setExecutor(new ControlPlayer());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(prefix + "Laying into bed...");

    }
}
