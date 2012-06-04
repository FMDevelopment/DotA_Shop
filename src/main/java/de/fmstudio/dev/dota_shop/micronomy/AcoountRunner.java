/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fmstudio.dev.dota_shop.micronomy;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Vector;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Max
 */
public class AcoountRunner extends Thread {
    int gold;
    String name;
    public void run(String n){
                name = n;
            try{
                Yaml yaml = new Yaml();
                Map conf = (Map)yaml.load(new FileInputStream(new File("plugins/DotaShop","config.yml")));
                gold = Integer.parseInt(conf.get("initial-amount").toString());
            }
            catch(Exception e){}
        Account money = new Account();
        money.gold=gold;
        money.name=name;
        while(true){
            money.increaseGold();
            
        }
    }
}

