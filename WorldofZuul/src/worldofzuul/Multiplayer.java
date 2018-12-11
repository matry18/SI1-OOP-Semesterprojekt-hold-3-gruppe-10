/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import Commands.Command;

/**
 *
 * @author Yourk
 */
public class Multiplayer {
    
    Game player1 = new Game(true);
    Game player2 = new Game(true);
    private Game currentGame = player1;

    private void changePlayer() {
        if (getCurrentGame().getChangePlayer()) {
            if (currentGame == player1) {
                currentGame.setChangePlayer(false);
                currentGame = player2;
            } else {
                currentGame.setChangePlayer(false);
                currentGame = player1;
            }
        }
    }
    
    public void getChangePlayer(){
        changePlayer();
    }
    
    public Game getCurrentGame() {
        return currentGame;
    }

    public void helpPlayer() {
        if (currentGame == player1) {
            currentGame.getPlayer().addTemporaryBonus(player2.getPlayer().getLevel());
        } else {
            currentGame.getPlayer().addTemporaryBonus(player1.getPlayer().getLevel());
        }
    }
}
