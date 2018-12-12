/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bonuses;

/**
 *
 * @author Patrick
 */
public class RightHand extends Item implements Comparable<Item> {

    public RightHand(String name, int bonus, String imgPath) {
        super(name, bonus, "Right hand weapon", 5, imgPath);
    }

}
