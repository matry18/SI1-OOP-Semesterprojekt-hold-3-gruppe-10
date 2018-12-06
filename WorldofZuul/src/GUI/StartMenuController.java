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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        imgStartMenu.setImage(new Image("\\pictures\\background\\munchkinwelcome vers 2.jpg"));
    }    

    @FXML
    private void handleStartGameButtonAction(ActionEvent event) {
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
    
}
