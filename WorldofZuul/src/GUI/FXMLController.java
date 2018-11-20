/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class FXMLController implements Initializable {
    @FXML
    private TextField txtAttack;
    @FXML
    private TextField txtLevel;
    @FXML
    private Button btnOneTimeUse;
    @FXML
    private Button btnHelp;
    @FXML
    private Button btnQuit;
    @FXML
    private Button btnGoNorth;
    @FXML
    private Button btnGoWest;
    @FXML
    private Button btnGoEast;
    @FXML
    private Button btnGoSouth;
    @FXML
    private TextField txtFight;
    @FXML
    private TextField txtFlee;
    @FXML
    private TextField txtLoot;
    @FXML
    private Button btnFight;
    @FXML
    private Button bthFlee;
    @FXML
    private Button btnLoot;
    @FXML
    private ImageView imgRoll;
    @FXML
    private TextArea txtButtonactionStatement;
    @FXML
    private ImageView imgRoomView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
