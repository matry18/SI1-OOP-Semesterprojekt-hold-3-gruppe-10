/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import Commands.Command;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author Yourk
 */
public class Multiplayer {
    
    Game game = new Game();
    Game gane = new Game();
    private final int maxLevel = 10;
    private final int minLevel = 0;
    private Game currentGame = game;
    private Command command;
    
    public void play(){
        game.printWelcome();

        boolean finished = false;
        while (!finished && game.player.getLevel() < maxLevel && game.player.getLevel() > minLevel) {
            if (currentGame == game) {
                System.out.println("Player 1's TURN!");
                command = game.getParser().getCommand();
                finished = game.processCommand(command);
                currentGame = gane;
            } else if (currentGame == gane) {
                System.out.println("Player 2's TURN! ");
                command = gane.getParser().getCommand();
                finished = gane.processCommand(command);
                currentGame = game;
            } else {
                System.out.println("Wow");
            }
        }
        if (game.player.getLevel() >= maxLevel) {
            System.out.println("Hurra!!! You have won the game! Go celebrate...");
        } else if (game.player.getLevel() <= minLevel) {
            System.out.println("You have reached level "+game.player.getLevel()+" and you are dead! Better luck next time.");
        }
        System.out.println("Thank you for playing.  Good bye.");

    }
}
