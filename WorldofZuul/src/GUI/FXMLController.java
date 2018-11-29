/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Commands.CommandWord;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static jdk.nashorn.tools.ShellFunctions.input;
import worldofzuul.Game;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class FXMLController implements Initializable {
    @FXML
    private ImageView imgHeadgear;
    @FXML
    private ImageView imgArmor;
    @FXML
    private ImageView imgLeftHand;
    @FXML
    private ImageView imgRightHand;
    @FXML
    private ImageView imgFootgear;
    @FXML
    private ImageView imgOneTimeUse;
    @FXML
    private VBox VBoxAttackLevelOneTimeUseHelpQuit;
    @FXML
    private Label lblAttack;
    @FXML
    private TextField lblAttackLevel;
    @FXML
    private Label lblLevel;
    @FXML
    private TextField txtPlayerLevel;
    @FXML
    private Button btnOneTimeUse;
    @FXML
    private Button btnHelp;
    @FXML
    private Button btnQuit;
    @FXML
    private GridPane GridPaneCompass;
    @FXML
    private Button btnGoEast;
    @FXML
    private Button btnGoNorth;
    @FXML
    private Button btnGoWest;
    @FXML
    private Button btnGoSouth;
    @FXML
    private ImageView imgCompass;
    @FXML
    private GridPane GridPaneFightFleeLoot;
    @FXML
    private TextField txtFight;
    @FXML
    private Button btnFight;
    @FXML
    private TextField txtFlee;
    @FXML
    private Button bthFlee;
    @FXML
    private TextField txtLoot;
    @FXML
    private Button btnLoot;
    @FXML
    private VBox VBoxOutput;
    @FXML
    private TextArea txtOutput;
    @FXML
    private TextArea txtAreaHelp;
    @FXML
    private ImageView imgRoomView;
        /**
     * Initializes the controller class.
     */   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleOneTimeUseButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleHelpButtonAction(ActionEvent event) {
               try{
                   Parent root = FXMLLoader.load(getClass().getResource("HelpWindow.fxml"));
                   Stage stage = new Stage();
                   stage.setTitle("Help");
                   stage.setScene(new Scene(root));
                   
                   
                   stage.show();
               }
               catch(Exception e) {
                   System.err.println(e.getMessage());
               }
    }

    @FXML
    private void handleQuitButtonAction(ActionEvent event) {
       System.exit(0);
    }

    @FXML
    private void handleGoEastButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleGoNorthButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleGoWestButtonAction(ActionEvent event) {
        //GUILaunch.game.getCurrentRoom().getExit("west");
    }

    @FXML
    private void handleGoSouthButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleFightButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleFleeButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleLootButtonAction(ActionEvent event) {
    }  
}
