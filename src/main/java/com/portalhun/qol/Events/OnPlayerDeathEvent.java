package com.portalhun.qol.Events;

import com.portalhun.qol.QOL;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class OnPlayerDeathEvent implements Listener {

    private final QOL pl;

    public OnPlayerDeathEvent(QOL pl) {
        this.pl = pl;
    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Location loc = (Location) pl.getConfig().get("spawn");

        if(loc!= null && !e.isBedSpawn()){
            e.setRespawnLocation(loc);
        }
    }
}
