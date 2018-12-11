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

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class HelpFromOtherPlayerController implements Initializable {
    @FXML
    private Button btnBegForHelp;
    @FXML
    private TextArea txtAreaAskingForHelp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnBegForHelp.setStyle("-fx-padding: 5;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 0;" + 
                      "-fx-border-radius: 3;" + 
                      "-fx-border-color: rgb("+86+","+23+","+26+");"+
                      "-fx-background-color: rgb(" + 223 + ", "+ 196 +", "+169+");");
        txtAreaAskingForHelp.setText("You can ask the other player for help to fight the monster."
                + "\nThe character level of the other player will be added to your attack level in this current fight."
                + "\nYou will gain the level up by defeating the monsterS, but the other player will gain a permanent +1 bonus.");
    }    

    @FXML
    private void handleBegForHelpButtonAction(ActionEvent event) {
    }
    
}
