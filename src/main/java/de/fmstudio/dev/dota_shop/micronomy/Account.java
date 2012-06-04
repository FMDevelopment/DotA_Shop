/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fmstudio.dev.dota_shop.micronomy;

/**
 *
 * @author Max
 */
public class Account {
    int gold;
    String name;
    public void Account(){
        
  }
    public void increaseGold(){
        gold++;
    }
    public int getGold(){
        return gold;
    }
    public void addGold(int g){
        synchronized(this){
        gold = gold + g;}
    }
    public void removeGold(int g){
        synchronized(this){
        gold = gold - g;}
    }
}
