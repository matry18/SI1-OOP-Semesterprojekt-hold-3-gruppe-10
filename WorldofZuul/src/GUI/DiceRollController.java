/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.GUILaunch.game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    game.getDie().roll();   
    setDiePicture();
    for (long i=0 ; i<1000000000 ; i++) {}
    /*Stage stage = (Stage) imgShowDiceRoll.getScene().getWindow();
    stage.close();*/
        
    }
private void setDiePicture() {
    if(game.getDie().getDie()==1) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\1.png"));
    } else if(game.getDie().getDie()==2) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\2.png"));
    } else if(game.getDie().getDie()==3) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\3.png"));
    } else if(game.getDie().getDie()==4) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\4.png"));
    } else if(game.getDie().getDie()==5) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\5.png"));
    } else if(game.getDie().getDie()==6) {
        imgShowDiceRoll.setImage(new Image("\\Pictures\\Dice\\6.png"));
    }
}
}
