/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.Random;

public class Die {

    private int die;

    public int roll() {
        Random random = new Random();
        die = random.nextInt(6) + 1;
        return die;
    }

    public int getDieResult() {
        return die;
    }

    public void setDie(int die) {
        this.die = die;
    }

}
