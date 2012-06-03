/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fmstudio.dev.dota_shop;

/**
 *
 * @author Max
 */ 
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class DotA_Shop extends JavaPlugin {
    public Logger out;
    private String arena;
    @Override
    public void onEnable(){
        out = this.getLogger();
        out.info("DotA Shop for Ultimate Arena 0.0.1 Enabled");
        boolean config = (new File("plugins/DotaShop","config.yml").exists());
        if(config)
        {
            try{
                FileInputStream in = new FileInputStream(new File("plugins/DotaShop","config.yml"));
                Properties prop = new Properties();
                prop.load(in);
                in.close();
                out.info("DotA Shop Config Loaded");
                arena = prop.getProperty("arena");
            }
            catch(Exception e){
              
            }
        }
        else{
            File f = new File("plugins/DotaShop","config.yml");
            try {
                f.createNewFile();
                out.info("Config File successfully created");
                out.info("Please specify your DotA Arena with '/dshop arena [arena name]'");
            } catch (IOException ex) {
                
            }
        }
        
}
    
    
    @Override
    public void onDisable(){
        out.info("Dota Shop for Ultimate Arena 0.0.1 Disabled");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        Player player = null;
        if(sender instanceof Player){
        player = (Player) sender;
    }
        if(cmd.getName().equalsIgnoreCase("ua")&&(args[1].equalsIgnoreCase("j")||args[1].equalsIgnoreCase("join"))&&args[2].equalsIgnoreCase(arena)){
            
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
