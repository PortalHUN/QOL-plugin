package com.portalhun.qol.Commands;

import com.portalhun.qol.QOL;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final QOL pl;

    public SpawnCommand(QOL pl){
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof  Player p){
            Location loc = (Location) pl.getConfig().get("spawn");

            if(loc == null){
                p.sendRawMessage(ChatColor.RED+"You need to set spawn location first.");
            }else {
                Location player = p.getLocation();
                double distance = player.distance(loc);
                double cost = pl.getConfig().getDouble("xp-cost");
                if(cost == 0.0) return true;
                int all = (int) Math.floor(distance*cost);
                if(p.getTotalExperience()-all <0) p.sendRawMessage(ChatColor.RED+"You don't have enough xp.");
                else{
                    p.giveExp(-all);
                    p.sendRawMessage("Cost: "+all);
                    p.teleport(loc);
                    p.sendRawMessage(ChatColor.BLUE+"Teleported to spawn");
                }
            }
        }else sender.sendMessage(ChatColor.RED+"You don't have permission to do this.");
        return true;
    }
}
