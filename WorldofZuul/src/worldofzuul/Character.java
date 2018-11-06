/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package worldofzuul;


public class Character {
private int level = 1;
private int bonus = 0;

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



}
