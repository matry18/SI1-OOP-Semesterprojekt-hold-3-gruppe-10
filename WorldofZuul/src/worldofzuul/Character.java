/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package worldofzuul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Character {
private int level = 1;
private int bonus = 0;
//HashMap<Item, Integer> hm = new HashMap<>();
ArrayList<Item> inventory = new ArrayList<>();

    public Character() {
        
    }
    public Character(int level, int bonus) {
        this.level = level;
        this.bonus = bonus;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void addItem(Item item){
        int wear = 0;
        if (item instanceof Headgear){ //Checks if the item is a headgear
            for(Item gear : inventory/*Map.Entry gear : hm.entrySet()*/){
                if(gear instanceof Headgear){
                    wear++;
                }
            }
            if(wear > 0){ //If the player is already wearing a headgear
                System.out.println("Character already wears headgear.");
            }
            else { //If the player is not already wearing a headgear
                //hm.put(item, item.getBonus());
                inventory.add(item);
                System.out.println("The Player puts on "+item);
            }
        }
        else if (item instanceof Armor){
            for(Item gear : inventory/*Map.Entry gear : hm.entrySet()*/){
                if(gear instanceof Armor){
                    wear++;
                }
            }
            if(wear > 0){ 
                System.out.println("Character already wears headgear.");
            }
            else { 
                //hm.put(item, item.getBonus());
                inventory.add(item);
                System.out.println("The Player puts on "+item);
            }
        }
        else if (item instanceof OneHand){
            for(Item gear : inventory/*Map.Entry gear : hm.entrySet()*/){
                if(gear instanceof OneHand){
                    wear++;
                }
                if (gear instanceof TwoHand){ //Checks if there is a two hander
                    wear += 2;
                }
            }
            if(wear > 1){ //If the player has more than one equipped
                System.out.println("Character already wears headgear.");
            }
            else { 
                //hm.put(item, item.getBonus());
                inventory.add(item);
                System.out.println("The Player puts on "+item);
            }
        }
        else if (item instanceof TwoHand){
            for(Item gear : inventory/*Map.Entry gear : hm.entrySet()*/){
                if(gear instanceof TwoHand || gear instanceof OneHand){
                    wear++;
                }
            }
            if(wear > 0){ 
                System.out.println("Character already has a weapon.");
            }
            else { 
                //hm.put(item, item.getBonus());
                inventory.add(item);
                System.out.println("The Player equips "+item);
            }
        }

        //hm.put(item, item.getBonus());
    }
    
    public String stringInventory(){
        String total = "";
        for(Item gear : inventory/*Map.Entry<Item, Integer> gear : hm.entrySet()*/){
            total += "Item Name: "+gear.getName()+" | Item Bonus: "+gear.getBonus();
            //total += "Item name: "+gear.getKey().getName()+" | Item bonus: "+gear.getKey().getBonus()+"\n";
        }
        return total;
    }

}