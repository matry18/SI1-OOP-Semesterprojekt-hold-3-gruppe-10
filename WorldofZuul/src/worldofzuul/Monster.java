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
    private int level;
    private int badStuffEffect;
    private String imagePath;

    //Constructor
    public Monster(String name, int level, int badStuffEffect, String imagePath) {
        this.name = name;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getImagePath() {
        return imagePath;
    }
}
