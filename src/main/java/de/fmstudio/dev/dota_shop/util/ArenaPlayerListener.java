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

    public boolean isInArena(Player player){
        Plugin tester = Bukkit.getPluginManager().getPlugin("UltimateArena");
        try {
            UltimateArena ua = (UltimateArena)tester;        
            if (ua.isInArena(player)){
                return true;
        }
        }
        catch(ClassCastException ex) {
            player.sendMessage("There's a plugin disguised as Ultimate Arena! It's not the one I was expecting!");
        }

        return false;
    }
    public static boolean isInArena(String pn){            
        Player player = Bukkit.getPlayer(pn);
        Plugin tester = Bukkit.getPluginManager().getPlugin("UltimateArena");
        try {
            UltimateArena ua = (UltimateArena)tester;        

            if (ua.isInArena(player)){
                return true;
        }
        }
        catch(ClassCastException ex) {
            player.sendMessage("There's a plugin disguised as Ultimate Arena! It's not the one I was expecting!");
        }

            return false;
    }
        
    
}
