/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game singleplayer = new Game(false);
        Multiplayer multiplayer2 = new Multiplayer();
        System.out.println("Singleplayer or Multiplayer?");
        System.out.print("Choose your gamemode: ");
        String gamemode = sc.next();
        if(gamemode.equals("singleplayer") || gamemode.equals("Singleplayer")){
            //singleplayer.play();
        } else if (gamemode.equals("multiplayer") || gamemode.equals("Multiplayer")) {
            multiplayer2.play();
        } else {
            System.out.println("Not valid: quitting");
            System.exit(0);
        }
    }

}
