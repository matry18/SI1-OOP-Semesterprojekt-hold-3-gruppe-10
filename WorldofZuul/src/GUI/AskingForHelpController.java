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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class AskingForHelpController implements Initializable {
    @FXML
    private Button btnYes;
    @FXML
    private Button btnNo;
    @FXML
    private TextField txtAreaWillYouHelp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Button[] buttons = {btnYes, btnNo};
        for (Button button: buttons) {
            setBtnStyle(button);
        }
        txtAreaWillYouHelp.setText("Will you help out the other player in the current fight?"
                + "\nYou can assist by adding your character level to the other players attack level."
                + "\nThe other player will gain a level by defeating the monster\n"
                + "and you will gain a permanent 1+ bonus.");
    }    

    @FXML
    private void handleYesButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleNoButtonAction(ActionEvent event) {
    }
 private void setBtnStyle(Button b){
        b.setStyle("-fx-padding: 5;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 0;" + 
                      "-fx-border-radius: 3;" + 
                      "-fx-border-color: rgb("+86+","+23+","+26+");"+
                      "-fx-background-color: rgb(" + 223 + ", "+ 196 +", "+169+");");
    }   
}
