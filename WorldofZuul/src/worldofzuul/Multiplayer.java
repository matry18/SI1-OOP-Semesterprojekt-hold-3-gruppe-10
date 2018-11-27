/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import Commands.Command;
import Commands.CommandWord;

/**
 *
 * @author Yourk
 */
public class Multiplayer {
    
    Game player1 = new Game(true);
    Game player2 = new Game(true);
    private final int maxLevel = 10;
    private final int minLevel = 0;
    private int welcomeMessage = 0;
    private Game currentGame = player1;
    private Command command;
    
    
    public void play(){
      boolean finished = false;
        
        while (!finished && currentGame.player.getLevel() < maxLevel && currentGame.player.getLevel() > minLevel) {
            
            if (currentGame == player1) {
                if (welcomeMessage < 2) {
                    currentGame.printWelcome();
                    welcomeMessage++;
                }
                System.out.println("Player 1's TURN!");
                command = player1.getParser().getCommand();
                finished = player1.processCommand(command);
                if (currentGame.getChangePlayer()) {
                    changePlayer();
                    
                }
            } else if (currentGame == player2) {
                if (welcomeMessage < 2) {
                    currentGame.printWelcome();
                    welcomeMessage++;
                }
                System.out.println("Player 2's TURN! ");
                command = player2.getParser().getCommand();
                finished = player2.processCommand(command);
                if (currentGame.getChangePlayer()) {
                    changePlayer();
                }
            } else {
                System.out.println("Wow");
            }
        }
        if (currentGame.player.getLevel() >= maxLevel) {
            System.out.println("Hurra!!! You have won the game! Go celebrate...");
        } else if (currentGame.player.getLevel() <= minLevel) {
            System.out.println("You have reached level "+currentGame.player.getLevel()+" and you are dead! Better luck next time.");
        }
        System.out.println("Thank you for playing.  Good bye.");

    }
    
    private void changePlayer() {
        if (currentGame == player1) {
            currentGame.setChangePlayer(false);
            currentGame = player2;
        } else {
            currentGame.setChangePlayer(false);
            currentGame = player1;
        }
    }
    
}
