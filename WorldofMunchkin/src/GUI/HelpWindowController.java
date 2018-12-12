/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class HelpWindowController implements Initializable {
    @FXML
    private TextArea txtAreaHelp;
    @FXML
    private Button btnCloseWindow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCloseWindow.setStyle("-fx-padding: 5;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 0;" + 
                      "-fx-border-radius: 3;" + 
                      "-fx-border-color: rgb("+86+","+23+","+26+");"+
                      "-fx-background-color: rgb(" + 223 + ", "+ 196 +", "+169+");");
        txtAreaHelp.setText("You are lost. You are alone. You wander around in the dungeon.\n"+
                "The rules are: You win the game by reaching level 10 or more.\n"+
                "You lose the game if you reach level 0 or below.\nYou go up a level by defeating a monster."
                + "\nAfter defeating a monster you can loot the room for goods.\n"+
                "When fighting a monster you have to be stronger than the monster."
                + "\nYour strength is your level and your bonuses combined which is your attack level."
                + "\nAny card you see can be enlargened if you click on it. To close it again you just have to click on the new window."
                + "\nSome item cards may only be used once and thereafter they will disapear."
                + "\nYou can choose to use the \"usable once only\" items by pressing the \"Scroll\" button in a fight."
                + "\nWhen encountering a monster instead of fighting it you may flee by pressing the flee button."
                + "\nYou flee for free if you roll 5 or 6 on a die."
                + "\nIf you roll anything else you will suffer from the bad stuff of the monster (lose levels).");
    }    

    @FXML
    private void handleCloseWindowButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnCloseWindow.getScene().getWindow();
        stage.close();
    }
}
