package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room {

    private String description;
    private HashMap<String, Room> exits;
    private Monster monster;
    private Curse curse;
    private Item item;

    private boolean containsMonster = false;
    private boolean containsCurse = false;
    private boolean containsItem = false;
    private boolean hadMonster = false;
    private boolean hadCurse = false;
    
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        if (containsMonster) {
            return description + "In here you meet the monster '" + getMonster().getName() + "'.\nLevel: " + getMonster().getLevel() + "\nDescription: " + getMonster().getDescription() + "\nBad Stuff: " + getMonster().getBadStuff();
        } else if (containsCurse) {
            return description + "In this room you are getting hit by the curse '" + getCurse().getName() + "'\nDescription: " + getCurse().getDescription() + "\nBad Stuff: " + getCurse().getBadStuff();
        } else if (hadMonster && containsItem){
            return description + "In here you met and defeated the monster '" + getMonster().getName() + "'." + "\nOn the ground you find '"+ getItem().getName() + "' with an attack bonus of "+ getItem().getBonus() + "\nTo loot the room type 'loot' or else leave the room.\n" + getExitString();
        } else if (hadCurse) {
            return description + "In here you met and got hit by the curse '" + getCurse().getName() + "'." + "\n" + getExitString();
        } else if (hadMonster) {
            return description + "In here you met and defeated the monster '" + getMonster().getName() + "'." + "\n" + getExitString();
        } else {
            return description + "\n" + getExitString();
        }
    }

    protected String getExitString() {
        String returnString = "Exit directions:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public Monster getMonster() {
        return monster;
    }

    public Curse getCurse() {
        return curse;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
        containsMonster = true;
    }

    public void setCurse(Curse curse) {
        this.curse = curse;
        containsCurse = true;
    }

    public boolean isContainsMonster() {
        return containsMonster;
    }

    public boolean isContainsCurse() {
        return containsCurse;
    }
    
    public boolean isContainsItem(){
        return containsItem;
    }

    public void setContainsMonster(boolean containsMonster) {
        this.containsMonster = containsMonster;
    }

    public void setContainsCurse(boolean containsCurse) {
        this.containsCurse = containsCurse;
    }
    
    public void setContainsItem(boolean containsItem){
        this.containsItem = containsItem;
    }

    public boolean isHadMonster() {
        return hadMonster;
    }

    public void setHadMonster(boolean hadMonster) {
        this.hadMonster = hadMonster;
    }

    public boolean isHadCurse() {
        return hadCurse;
    }

    public void setHadCurse(boolean hadCurse) {
        this.hadCurse = hadCurse;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
