/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fmstudio.dev.dota_shop;

/**
 *
 * @author Max
 */ 
import de.fmstudio.dev.dota_shop.micronomy.AcoountRunner;
import java.util.logging.*;
import java.io.*;
import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;
public class DotA_Shop extends JavaPlugin {
    private String arena;
    private AcoountRunner manager = new AcoountRunner();
    public File config = new File("plugins/DotaShop","config.yml");
    @Override
    public void onEnable(){
        System.out.println("DotA Shop for Ultimate Arena 0.2.1 Enabled");
        boolean checkconf = (config.exists());
        if(checkconf)
        {
            try{
                Yaml yaml = new Yaml();
                Map conf = (Map)yaml.load(new FileInputStream(config));
                arena = conf.get("arena").toString();
                System.out.println("DotA Shop Config Loaded");
            }
            catch(Exception e){}
        }
        else{
            try {
                config.createNewFile();
                BufferedWriter write = new BufferedWriter(new FileWriter(config));
                write.write("arena: none");
                write.newLine();
                write.append("initial-amount: 600");
                write.close();
                System.out.println("Config File successfully created");
                System.out.println("Please specify your DotA Arena with '/dota arena [arena name]'");
            } catch (IOException ex) {}
        }
        
}
    
    
    @Override
    public void onDisable(){
        System.out.println("Dota Shop for Ultimate Arena 0.2.1 Disabled");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        Player player = null;
        if(sender instanceof Player){
        player = (Player) sender;
    if(args.length==2){
        if(cmd.getName().equalsIgnoreCase("ua")&&(args[1].equalsIgnoreCase("j")||args[1].equalsIgnoreCase("join"))&&args[2].equals(arena)){ 
            
        }
    }
        if(cmd.getName().equals("dota")&&args[1].equalsIgnoreCase("arena")){
            if(args.length == 3) {
            try {
                arena = args[2];
                Yaml yaml = new Yaml();
                Map conf = (Map)yaml.load(new FileInputStream(config));
                String save = conf.get("initial-value").toString();
                conf.clear();
                conf.put("arena", args[2]);
                conf.put("initial-value", save);
                PrintWriter writer = new PrintWriter(new FileWriter(config));
                if(config.exists()){
                    config.delete();
                }
                config.createNewFile();
                writer.write(yaml.dump(conf).toString());
                writer.close();
                System.out.println("New Arena-Name Saved");
            } 
            catch (IOException ex){return false;}
        }
        }else{
            player.sendMessage("Too many or less Arguments (Correct usage: /dota arena [arenaname]");
            return false;
        }
     
    if(cmd.getName().equals("dota")&&(args[1].equals("gold")||args[1].equals("g")||args[1].equals("money"))){
        if(args.length == 2){
            Player p = (Player)sender;
            p.sendMessage("Sorry But this feature isnt completed yet");
        }
        else{
            player.sendMessage("Too many or less Arguments (Correct usage: /dota gold|g|money)");
            return false;
        }
    }
    }else {
            sender.sendMessage("You must be a Player!");

            return false;
        }
    return false;
    }
    /**
     * @param args the command line arguments
     */

}
