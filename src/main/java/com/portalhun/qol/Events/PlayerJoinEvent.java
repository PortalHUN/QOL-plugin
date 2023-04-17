package com.portalhun.qol.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    @EventHandler
    public void OnPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e){
        e.setJoinMessage(e.getPlayer().getDisplayName()+", hello!");
    }
}
