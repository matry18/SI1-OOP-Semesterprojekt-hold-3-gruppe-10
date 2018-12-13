/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofmunchkin;

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
        level++;
    }

    public void addBonusHelp() {
        bonus++;
    }

    public void removeLevel(int level) {
        this.level += level;
    }

    public void addTemporaryBonus(int temporaryBonus) {
        this.temporaryBonus += temporaryBonus;
    }

    public void resetTemporaryBonus() {
        temporaryBonus = 0;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public OneTimeUse getOneTimeUse() {
        for (Item item : inventory) {
            if (item instanceof OneTimeUse) {
                return (OneTimeUse) item;
            }
        }
        return null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) { //Adds an item to the inventory. Always use a subclass to Item.
        inventory.add(item);
    }

    public int totalAttackValue() { //Adds the player level with the combined bonus of all items.
        int totalValue = 0;
        for (Item gear : inventory) {
            if (gear instanceof OneTimeUse) {
                continue;
            }
            totalValue += gear.getBonus();
        }
        return totalValue + level + bonus + temporaryBonus;
    }
}
