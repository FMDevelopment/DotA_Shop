/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fmstudio.dev.dota_shop.util;

import com.orange451.UltimateArena.UltimateArena;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import com.orange451.UltimateArena.UltimateArenaAPI;
import org.bukkit.entity.Player;

/**
 *
 * @author Max
 */
public class ArenaPlayerListener{
    private UltimateArena ua;
    public void ArenaPlayerListener(Player player){
        Plugin tester = Bukkit.getPluginManager().getPlugin("UltimateArena");
        try {
            ua = (UltimateArena)tester;
        }
        catch(ClassCastException ex) {
            player.sendMessage("There's a plugin disguised as Ultimate Arena! It's not the one I was expecting!");
        }
    }
    public boolean isInArena(Player player){
        if (ua.isInArena(player)){
                return true;
        }
        return false;
    }
}
