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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class ShowLeftHandController implements Initializable {

    @FXML
    private ImageView imgShowLeftHand;
    @FXML
    private Button btnCloseWindow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgShowLeftHand.setPreserveRatio(true);
        imgShowLeftHand.setImage(new Image(getClass().getResourceAsStream(FXMLController.findInventoryItem("Left hand weapon"))));
    }

    @FXML
    private void handleCloseWindowButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnCloseWindow.getScene().getWindow();
        stage.close();
    }

}
