/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;
import java.util.Collections;

public class Character {

    private int level = 1;
    private int bonus = 0;
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

    public void removeLevel(int level) {
        this.level = this.level + level;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void addItem(Item item) {
        int wear = 0;
        if (item instanceof Headgear) { //Checks if the item is a headgear
            for (Item gear : inventory) {
                if (gear instanceof Headgear) {
                    wear++;
                }
            }
            if (wear > 0) { //If the player is already wearing a headgear
                System.out.println("Character already wears headgear.");
            } else { //If the player is not already wearing a headgear
                inventory.add(item);
                System.out.println("The Player puts on the headgear '" + item.getName() + "'.");
            }
        } else if (item instanceof Armor) {
            for (Item gear : inventory) {
                if (gear instanceof Armor) {
                    wear++;
                }
            }
            if (wear > 0) {
                System.out.println("Character already wears armor.");
            } else {
                inventory.add(item);
                System.out.println("The Player puts on the armor '" + item.getName() + "'.");
            } 
        } else if (item instanceof Footgear) {
            for (Item gear : inventory) {
                if (gear instanceof Footgear) {
                    wear++;
                }
            }
            if (wear > 0) {
                System.out.println("Character already wears footgear.");
            } else {
                inventory.add(item);
                System.out.println("The Player puts on the footgear '" + item.getName() + "'.");
            } 
        } else if (item instanceof OneHand) {
            for (Item gear : inventory) {
                if (gear instanceof OneHand) {
                    wear++;
                }
            }
            if (wear > 0) { //If the player has more than one equipped
                System.out.println("Character is already armed.");
            } else {
                inventory.add(item);
                System.out.println("The Player equips '" + item.getName() + "'.");
            }
        } else if (item instanceof TwoHand) {
            for (Item gear : inventory) {
                if (gear instanceof TwoHand) {
                    wear++;
                }
            }
            if (wear > 0) {
                System.out.println("Character is already armed.");
            } else {
                inventory.add(item);
                System.out.println("The Player equips '" + item.getName() + "'.");
            }
        }
    }

    public String stringInventory() {
        Collections.sort(inventory);
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

    public int totalAttackValue() {
        int totalValue = 0;
        for (Item gear : inventory) {
            totalValue += gear.getBonus();
        }
        return totalValue + level + bonus;
    }
}
