/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import Bonuses.*;
import java.util.ArrayList;
import java.util.Collections;

public class Character {

    private int level = 1;
    private int bonus = 0;
    private int temporaryBonus = 0;
    ArrayList<Item> inventory = new ArrayList<>();

    public Character() {
    }

    public Character(int level, int bonus) {
        this.level = level;
        this.bonus = bonus;
    }

    public Character(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addLevel() {
        this.level++;
    }
    
    public void addBonusHelp() {
        this.bonus++;
    }

    public void removeLevel(int level) {
        this.level = this.level + level;
    }

    public void addTemporaryBonus(int temporaryBonus) {
        this.temporaryBonus += temporaryBonus;
    }

    public void resetTemporaryBonus() {
        this.temporaryBonus = 0;
    }
    
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
    
    public OneTimeUse getOneTimeUse() {
        for(Item item : inventory){
            if(item instanceof OneTimeUse){
                return (OneTimeUse)item;
            }
        }
        return null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    
    

    public void addItem(Item item) { //Adds an item to the inventory. Always use a subclass to Item.
            if(item instanceof LeftHand || item instanceof RightHand){
                System.out.println("The Player equips "+item.getName());
            }
            else{
                System.out.println("The Player puts on the "+item.getDataType()+" "+item.getName());
            }
            inventory.add(item);
        
    }

    public String stringInventory() { //Returns the inventory in a string. Headgear printet first, then armor and so on.
        Collections.sort(inventory); //Sorts the inventory (ArrayList) after the int dataNum.
        String total = "";
        int counter = 0;
        for (Item gear : inventory) {
            counter++;
            total += gear.getDataType()+": " + gear.getName() + " | Item Bonus: " + gear.getBonus() + "\n";
        }
        if(counter == 0){
            return "Inventory:\nYou have no items!\n";
        } else {
            return "Inventory:\n"+total+"\n";
        }
    }

    public int totalAttackValue() { //Adds the player level with the combined bonus of all items.
        int totalValue = 0;
        for (Item gear : inventory) {
            if(gear instanceof OneTimeUse){
                continue;
            }
            totalValue += gear.getBonus();
        }
        return totalValue + level + bonus + temporaryBonus;
    }
    
    
}
