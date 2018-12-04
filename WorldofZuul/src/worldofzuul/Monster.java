/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author patri
 */
public class Monster {

    //Attributes
    private String name;
    private String description;
    private String badStuff;
    private int level;
    private int badStuffEffect;
    private String imagePath;

    //Constructor
    public Monster(String name, String description, int level, String badStuff, int badStuffEffect, String imagePath) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.badStuff = badStuff;
        this.badStuffEffect = badStuffEffect;
        this.imagePath = imagePath;
    }

    //Accessors and modifiers
    public String getName() {
        return name;
    }

    public int getBadStuffEffect() {
        return badStuffEffect;
    }

    public void setBadStuffEffect(int badStuffEffect) {
        this.badStuffEffect = badStuffEffect;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBadStuff() {
        return badStuff;
    }

    public void setBadStuff(String badStuff) {
        this.badStuff = badStuff;
    }

    public String getImagePath() {
        return imagePath;
    }
}
