package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Monster monster;
    private Curse curse;
    
    private boolean containsMonster = false;
    private boolean containsCurse = false;
    
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        if(containsMonster){
        return "You are " + description + ". In here you meet "+ getMonster().getName()+ "\nLevel: " +getMonster().getLevel()+ "\nDescription: "+ getMonster().getDescription()+ "\nBad Stuff: " + getMonster().getBadStuff() + "\n" + getExitString();
        }
        else if(containsCurse) {
        return "You are " + description + ". In this room you are getting hit by a curse "+ getCurse().getName() + "\nDescription: "+getCurse().getDescription()+ "\nBad Stuff: " + getCurse().getBadStuff() + "\n" + getExitString();
    }
        else{
            return "You are " + description +"\n" + getExitString();
        }
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
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

    public void setContainsMonster(boolean containsMonster) {
        this.containsMonster = containsMonster;
    }
    public void setContainsCurse(boolean containsCurse) {
        this.containsCurse = containsCurse;
    }
    
}

