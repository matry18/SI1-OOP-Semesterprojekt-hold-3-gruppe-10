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
import Commands.*;
import Bonuses.*;
import static GUI.GUILaunch.game;
import javafx.scene.Node;
import javafx.scene.image.Image;
import worldofzuul.*;

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
    private Button btnFight;
    @FXML
    private Button bthFlee;
    @FXML
    private Button btnLoot;
    @FXML
    private VBox VBoxOutput;
    @FXML
    private TextArea txtOutput;
    @FXML
    private ImageView imgRoomView;
    private boolean lost = false;
    @FXML
    private ImageView imgMonsterCurseItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("\\pictures\\background\\entrance.png");
        imgRoomView.setFitHeight(338);
        imgRoomView.setPreserveRatio(false);
        imgRoomView.setImage(image);
    }

    @FXML
    private void handleOneTimeUseButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleHelpButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HelpWindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Help");
            stage.setScene(new Scene(root));

            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void handleQuitButtonAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleGoEastButtonAction(ActionEvent event) {
        command("go east");
        roomSettings();
    }

    @FXML
    private void handleGoNorthButtonAction(ActionEvent event) {
        command("go north");
        roomSettings();
    }

    @FXML
    private void handleGoWestButtonAction(ActionEvent event) {
        command("go west");
        roomSettings();
    }

    @FXML
    private void handleGoSouthButtonAction(ActionEvent event) {
        command("go south");
        roomSettings();
    }

    @FXML
    private void handleFightButtonAction(ActionEvent event) {
        command("fight");
        checkForWinning();
        
    }

    @FXML
    private void handleFleeButtonAction(ActionEvent event) {
        command("flee");
        checkForLosing();
        if (lost) {
            ((Node)event.getSource()).getScene().getWindow().hide();
        }
    }

    @FXML
    private void handleLootButtonAction(ActionEvent event) {
        command("loot");
        if (game.isBattleMode()) {
            txtOutput.setText("You are in battle mode you can only fight or flee!");
        }
    }
    
    public void checkForWinning() {
        if (game.getPlayer().getLevel() == game.getMaxLevel()) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Winner.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Won the game");
            stage.setScene(new Scene(root));
            
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
           }
    public void checkForLosing() {
        if (game.getPlayer().getLevel() <= game.getMinLevel()) {
            try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Losing.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Lose the game");
            stage.setScene(new Scene(root));
            
            stage.show();
            lost = true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        }
    }

    private void command(String input) {
        Parser parser = new Parser();
        parser.setGUICommand(input);
        GUILaunch.game.processCommand(parser.getCommand());
    }
    
    private void roomSetImage(){
        imgRoomView.setImage(new Image(game.getCurrentRoom().getShortDescription()));
    }

    private void roomSettings() {
    txtOutput.setText(game.getCurrentRoom().getLongDescription());
        if (game.isBattleMode()) {
            txtOutput.setText("You are in battle mode you can only fight or flee!");
        }
        if (GUILaunch.game.isNoDoor()) {
            txtOutput.setText("There is no door!");
        } else {
            roomSetImage();
        }
    }
}
