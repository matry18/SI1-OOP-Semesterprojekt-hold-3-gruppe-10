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
public class LosingController implements Initializable {
    @FXML
    private TextArea txtAreaLosing;
    @FXML
    private Button btnQuitFromLosinge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtAreaLosing.setText("You have reached level 0 or below and you are dead! Better luck next time.\n" +
"Thank you for playing. Good bye.");
    }    

    @FXML
    private void handleQuitButtonAction(ActionEvent event) {
        System.exit(0);
    }
    
}
