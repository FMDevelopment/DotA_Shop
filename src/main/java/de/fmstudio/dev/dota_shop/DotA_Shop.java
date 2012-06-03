/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fmstudio.dev.dota_shop;

/**
 *
 * @author Max
 */ 
import com.esotericsoftware.yamlbeans.*;
import de.fmstudio.dev.dota_shop.micronomy.AccountManager;
import java.util.logging.*;
import java.io.*;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.orange451.UltimateArena.*;
public class DotA_Shop extends JavaPlugin {
    public Logger out;
    private String arena;
    private File config = new File("plugins/DotaShop","config.yml");
    @Override
    public void onEnable(){
        out = this.getLogger();
        out.info("DotA Shop for Ultimate Arena 0.1.1 Enabled");
        boolean checkconf = (config.exists());
        if(checkconf)
        {
            try{
                YamlReader in = new YamlReader(new FileReader(config));
                Map conf = (Map)in.read();
                arena = conf.get("arena").toString();
                out.info("DotA Shop Config Loaded");
            }
            catch(Exception e){}
        }
        else{
            File f = new File("plugins/DotaShop","config.yml");
            try {
                f.createNewFile();
                BufferedWriter write = new BufferedWriter(new FileWriter(f));
                write.write("arena: none");
                write.newLine();
                write.append("initial-amount: 600");
                write.close();
                out.info("Config File successfully created");
                out.info("Please specify your DotA Arena with '/dshop arena [arena name]'");
            } catch (IOException ex) {}
        }
        
}
    
    
    @Override
    public void onDisable(){
        out.info("Dota Shop for Ultimate Arena 0.1.1 Disabled");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        Player player = null;
        if(sender instanceof Player){
        player = (Player) sender;
    if(args.length==2){
        if(cmd.getName().equalsIgnoreCase("dota")&&(args[1].equalsIgnoreCase("j")||args[1].equalsIgnoreCase("join"))){ 
            new AccountManager().start();
        }
    }
        if(cmd.getName().equals("dota")&&args[1].equalsIgnoreCase("arena")){
            try {
                arena = args[2];
                YamlReader in = new YamlReader(new FileReader(config));
                Map conf = (Map)in.read();
                String save = conf.get("initial-value").toString();
                conf.put("arena", args[2]);
                conf.put("initial-value", save);
                YamlWriter writer = new YamlWriter(new FileWriter(config));
                writer.write(conf);
                writer.close();
            } 
            catch (IOException ex){return false;}
        }
    } else {
            sender.sendMessage("You must be a Player!");
            return false;
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
