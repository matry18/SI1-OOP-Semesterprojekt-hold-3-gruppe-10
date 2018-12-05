/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class HelpWindowController implements Initializable {
    @FXML
    private TextArea txtAreaHelp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtAreaHelp.setText("You are lost. You are alone. You wander around in the dungeon.\n"+
                "The rules are: You win the game by reaching level 10 or more.\n"+
                "You lose the game if you reach level 0 or below.\nYou go up a level by defeating a monster.\nAfter defeating a monster you can loot the room for goods.\n"+
                "When fighting a monster you have to be stronger than the monster.\nYour strength is your level and your bonuses combined which is your attack level.");
    }    
    
}
