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
 * @author aalsc
 */
public class ShowCardController implements Initializable {
    @FXML
    private ImageView imgShowCard;
    @FXML
    private Button btnCloseWindow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgShowCard.setPreserveRatio(true);
        if (game.getCurrentRoom().isContainsMonster()) {
            imgShowCard.setImage(new Image(game.getCurrentRoom().getMonster().getImagePath()));
        } else if(game.getCurrentRoom().isContainsCurse()){
            imgShowCard.setImage(new Image(game.getCurrentRoom().getCurse().getImagePath()));
        } else if(game.getCurrentRoom().isContainsItem()){
            imgShowCard.setImage(new Image(game.getCurrentRoom().getItem().getImgPath()));
        }
    }    

    @FXML
    private void handleCloseWindowButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnCloseWindow.getScene().getWindow();
        stage.close();
    }
    
}
