package worldofmunchkin;

import Bonuses.Item;
import java.util.Set;
import java.util.HashMap;

public class Room {

    private String description;
    private HashMap<String, Room> exits;
    private Monster monster;
    private Curse curse;
    private Item item;

    private boolean containsMonster = false;
    private boolean containsCurse = false;
    private boolean containsItem = false;

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

    public String getExitString() {
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

    public boolean isContainsItem() {
        return containsItem;
    }

    public void setContainsMonster(boolean containsMonster) {
        this.containsMonster = containsMonster;
    }

    public void setContainsCurse(boolean containsCurse) {
        this.containsCurse = containsCurse;
    }

    public void setContainsItem(boolean containsItem) {
        this.containsItem = containsItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getExits() {
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            return exit;
        }
        return "";
    }
}
