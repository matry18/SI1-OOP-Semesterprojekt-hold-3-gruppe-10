/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author Patrick
 */
public class Footgear extends Item implements Comparable<Item> {
    
    public Footgear(String name, int bonus) {
        super(name, bonus,"Footgear",3);
    }
    
}
