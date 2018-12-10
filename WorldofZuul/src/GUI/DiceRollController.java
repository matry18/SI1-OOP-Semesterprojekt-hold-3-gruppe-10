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
private void setDiePicture() {
    if(FXMLController.getGame().getDie().getDieResult()==1) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\1.png"));
    } else if(FXMLController.getGame().getDie().getDieResult()==2) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\2.png"));
    } else if(FXMLController.getGame().getDie().getDieResult()==3) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\3.png"));
    } else if(FXMLController.getGame().getDie().getDieResult()==4) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\4.png"));
    } else if(FXMLController.getGame().getDie().getDieResult()==5) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\5.png"));
    } else if(FXMLController.getGame().getDie().getDieResult()==6) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\6.png"));
    }
}

    @FXML
    private void handleCloseWindowButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnCloseWindow.getScene().getWindow();
        stage.close();
    }
}
