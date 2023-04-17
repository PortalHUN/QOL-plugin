package com.portalhun.qol;

import com.portalhun.qol.Commands.SetSpawnCommand;
import com.portalhun.qol.Commands.SpawnCommand;
import com.portalhun.qol.Events.OnPlayerDeathEvent;
import com.portalhun.qol.Events.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class QOL extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerDeathEvent(this), this);

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
    }
}
