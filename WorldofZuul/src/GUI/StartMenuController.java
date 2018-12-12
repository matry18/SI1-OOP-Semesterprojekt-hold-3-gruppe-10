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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yourk
 */
public class StartMenuController implements Initializable {
    @FXML
    private Button btnStartGame;
    @FXML
    private ImageView imgStartMenu;
    @FXML
    private Button btnStartMultiplayer;
    @FXML
    private Button btnQuitGame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Button[] buttons = {btnStartGame, btnStartMultiplayer, btnQuitGame};
        for (Button button: buttons) {
            setBtnStyle(button);
        }
        imgStartMenu.setImage(new Image(getClass().getResourceAsStream("/Pictures/BackGround/MunchkinWelcomeVers2.jpg")));
    }    

    @FXML
    private void handleStartGameButtonAction(ActionEvent event)throws Exception{
        
            Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Stage stage = new Stage();
            stage.setTitle("World of Munchkin");
            stage.setScene(new Scene(root));
            
            stage.show();
        
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void handleStartMultiplayerButtonAction(ActionEvent event) {
        FXMLController.setIsMultiplayer(true);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Stage stage = new Stage();
            stage.setTitle("World of Munchkin");
            stage.setScene(new Scene(root));
            
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
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

    @FXML
    private void handleQuitGameButtonAction(ActionEvent event) {
        System.exit(0);
    }
}
