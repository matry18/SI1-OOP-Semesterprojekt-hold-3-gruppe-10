/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.GUILaunch.game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class DiceRollController implements Initializable {

    @FXML
    private ImageView imgShowDiceRoll;
    @FXML
    private Button btnCloseWindow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgShowDiceRoll.setPreserveRatio(true);
        FXMLController.getGame().getDie().roll();
        setDiePicture();

    }

    private void setDiePicture() { //The die files are named 1.png, 2.png etc. This takes the number from the die and searches for the picture named the same number.
        String result = Integer.toString(FXMLController.getGame().getDie().getDieResult());
        imgShowDiceRoll.setImage(new Image(getClass().getResourceAsStream("/Pictures/Dice/" + result + ".png")));
    }

    @FXML
    private void handleCloseWindowButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnCloseWindow.getScene().getWindow();
        stage.close();
    }
}
