/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fmstudio.dev.dota_shop;

/**
 *
 * @author Max
 */ 
import Spout.SpoutGoldUpdater;
import de.fmstudio.dev.dota_shop.micronomy.Account;
import de.fmstudio.dev.dota_shop.micronomy.AccountManager;
import java.io.*;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;
public class DotA_Shop extends JavaPlugin {
    private String arena;
    public static AccountManager manager = new AccountManager();
    public static Vector updatemanager = new Vector();
    public File config = new File("plugins/DotaShop","config.yml");
    @Override
    public void onEnable(){
        System.out.println("DotA Shop for Ultimate Arena 0.4.1 Enabled");
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
        System.out.println("Dota Shop for Ultimate Arena 0.4.1 Disabled");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        Player player = null;
        if(sender instanceof Player){
        player = (Player) sender;
    if(args.length==2){
        if(cmd.getName().equalsIgnoreCase("ua")&&(args[0].equalsIgnoreCase("j")||args[0].equalsIgnoreCase("join"))&&args[1].equals(arena)){ 
            manager.createAccount(player);
            SpoutGoldUpdater update = new SpoutGoldUpdater();
            update.startUpdating(player);
        }
    }
    else if(args.length==1){

    
if(cmd.getName().equals("dota")&&args[0].equalsIgnoreCase("arena")){
            if(args.length == 3) {
            try {
                arena = args[0];
                Yaml yaml = new Yaml();
                Map conf = (Map)yaml.load(new FileInputStream(config));
                String save = conf.get("initial-value").toString();
                conf.clear();
                conf.put("arena", args[0]);
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
            player.sendMessage("Too many or less arguments (Correct usage: /dota arena [arenaname]");
            return false;
        }
     
    if(cmd.getName().equals("dota")&&(args[0].equals("gold")||args[0].equals("g")||args[0].equals("money"))){
        if(args.length == 2){
            Player p = (Player)sender;
            Enumeration e = manager.accounts.elements();
            while(e.hasMoreElements()){
                Account acc = (Account)e;
                if(acc.getName().equals(p.getName())){
                    p.sendMessage("You current Gold amount is " + acc.getGold()); break;
                }
                else{
                    e.nextElement();
                }
            }
        }
        else{
            player.sendMessage("Too many or less arguments (Correct usage: /dota gold|g|money)");
            return false;
        }
    }
    else if(cmd.getName().equals("dota")){
            player.sendMessage("This is DotA Shop for Ultimate Arena!");
            player.sendMessage("|-----------------------------------|");
            player.sendMessage("|-------------Commands--------------|");
            player.sendMessage("|------/dota arena [arenaname]------|");
            player.sendMessage("|-----Usage: Set DotA Arena Name----|");
            player.sendMessage("|-----------------------------------|");
            player.sendMessage("|--------/dota gold/g/money---------|");
            player.sendMessage("|-Usage: Get Current Gold (in arena)|");
            player.sendMessage("|-----------------------------------|");
            player.sendMessage("|----DotA Shop by FM Development----|");
        }
    }}else {
            sender.sendMessage("You must be a Player!");

            return false;
        }
    return false;
    }
    /**
     * @param args the command line arguments
     */

}
