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
    @FXML
    private Button btnShowCard;
    @FXML
    private Button btnShowHeadGear;
    @FXML
    private Button btnShowArmor;
    @FXML
    private Button btnShowLeftHand;
    @FXML
    private Button btnShowRightHand;
    @FXML
    private Button btnShowFootGear;
    @FXML
    private Button btnShowOneTimeUse;

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
        Image compass = new Image("\\pictures\\background\\compass.png");
        imgCompass.setImage(compass);
        Image noItem = new Image("\\pictures\\items\\default.png");
        imgHeadgear.setImage(noItem);
        imgArmor.setImage(noItem);
        imgLeftHand.setImage(noItem);
        imgRightHand.setImage(noItem);
        imgFootgear.setImage(noItem);
        imgOneTimeUse.setImage(noItem);
        setLevel();
        setAttackLevel();
    }

    @FXML
    private void handleOneTimeUseButtonAction(ActionEvent event) {
        command("useitem");
        imgOneTimeUse.setImage(null);
        setAttackLevel();
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
        removeCurse();
        command("go east");
        roomSettings();
    }

    @FXML
    private void handleGoNorthButtonAction(ActionEvent event) {
        removeCurse();
        command("go north");
        roomSettings();
    }

    @FXML
    private void handleGoWestButtonAction(ActionEvent event) {
        removeCurse();
        command("go west");
        roomSettings();
    }

    @FXML
    private void handleGoSouthButtonAction(ActionEvent event) {
        removeCurse();
        command("go south");
        roomSettings();
    }

    @FXML
    private void handleFightButtonAction(ActionEvent event) {
        command("fight");
        checkForWinning();
        setImgMonsterCurseItem();
        setLevel();
    }

    @FXML
    private void handleFleeButtonAction(ActionEvent event) {
        game.getDie().roll();
        setDiePicture();
        for (long i=0 ; i<1000000000 ; i++) {}
        command("flee");
        checkForLosing();
        if (lost) {
            ((Node) event.getSource()).getScene().getWindow().hide();
        } else {
            roomSettings();
        }
        setAttackLevel();
        setLevel();
    }

    @FXML
    private void handleLootButtonAction(ActionEvent event) {
        if (game.isBattleMode()) {
            txtOutput.setText("You are in battle mode you can only fight or flee!");
            return;
        }
        setInventory();
        command("loot");
        setImgMonsterCurseItem();
        setAttackLevel();
    }

    @FXML
    private void handleShowCardButtonAction(ActionEvent event) {
        if (game.getCurrentRoom().isContainsItem() || game.getCurrentRoom().isContainsMonster() || game.getCurrentRoom().isContainsCurse()) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("ShowCard.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Big card view");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @FXML
    private void handleShowHeadGearButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShowHeadGear.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Show Head Gear");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void handleShowArmorButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShowArmor.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Show Armor");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void handleShowLeftHandButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShowLeftHand.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Show Left Hand Weapon");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void handleShowRightHandButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShowRightHand.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Show Right Hand Weapon");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void handleShowFootGearButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShowFootGear.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Show Foot Gear");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void handleShowOneTimeUseButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ShowOneTimeUse.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Show One Time Use Items");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
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

    private void setImgRoom() {
        imgRoomView.setImage(new Image(game.getCurrentRoom().getShortDescription()));
    }

    private void setImgMonsterCurseItem() {
        if (game.getCurrentRoom().isContainsMonster()) {
            imgMonsterCurseItem.setImage(new Image(game.getCurrentRoom().getMonster().getImagePath()));
        } else if (game.getCurrentRoom().isContainsCurse()) {
            imgMonsterCurseItem.setImage(new Image(game.getCurrentRoom().getCurse().getImagePath()));
            setInventory();
            setAttackLevel();
        } else if (game.getCurrentRoom().isContainsItem()) {
            imgMonsterCurseItem.setImage(new Image(game.getCurrentRoom().getItem().getImgPath()));
        } else {
            imgMonsterCurseItem.setImage(null);
        }
    }

    private void roomSettings() {
        txtOutput.setText(game.getCurrentRoom().getLongDescription());
        if (game.isBattleMode()) {
            txtOutput.setText("You are in battle mode you can only fight or flee!");
        }
        if (GUILaunch.game.isNoDoor()) {
            txtOutput.setText("There is no door!");
        } else {
            setImgRoom();
            setImgMonsterCurseItem();
        }
    }

    private void setInventory() {
        if (game.getCurrentRoom().getItem().getDataNum() == 1) {
            imgHeadgear.setImage(new Image(game.getCurrentRoom().getItem().getImgPath()));
        } else if (game.getCurrentRoom().getItem().getDataNum() == 2) {
            imgArmor.setImage(new Image(game.getCurrentRoom().getItem().getImgPath()));
        } else if (game.getCurrentRoom().getItem().getDataNum() == 3) {
            imgFootgear.setImage(new Image(game.getCurrentRoom().getItem().getImgPath()));
        } else if (game.getCurrentRoom().getItem().getDataNum() == 4) {
            imgLeftHand.setImage(new Image(game.getCurrentRoom().getItem().getImgPath()));
        } else if (game.getCurrentRoom().getItem().getDataNum() == 5) {
            imgRightHand.setImage(new Image(game.getCurrentRoom().getItem().getImgPath()));
        } else if (game.getCurrentRoom().getItem().getDataNum() == 6) {
            imgOneTimeUse.setImage(new Image(game.getCurrentRoom().getItem().getImgPath()));
        }
    }

    private void setAttackLevel() {
        lblAttackLevel.setText(Integer.toString(game.getPlayer().totalAttackValue()));
    }

    private void setLevel() {
        txtPlayerLevel.setText(Integer.toString(game.getPlayer().getLevel()));
    }

    private void removeCurse() {
        if (game.getCurrentRoom().isContainsCurse()) {
            game.getCurrentRoom().setContainsCurse(false);//Removes curse after getting hit
        }
    }

    protected static String findInventoryItem(String dataType) {
        for (Item item : game.getPlayer().getInventory()) {
            if (item.getDataType().equals(dataType)) {
                return item.getImgPath();
            }
        }
        return null;
    }
    private void setDiePicture() {
        System.out.println(game.getDie().getDie());
        imgMonsterCurseItem.setImage(null);
       Image Dice1 = new Image("\\Pictures\\Dice\\1.png");
       Image Dice2 = new Image("\\Pictures\\Dice\\2.png");
       Image Dice3 = new Image("\\Pictures\\Dice\\3.png");
       Image Dice4 = new Image("\\Pictures\\Dice\\4.png");
       Image Dice5 = new Image("\\Pictures\\Dice\\5.png");
       Image Dice6 = new Image("\\Pictures\\Dice\\6.png");
        if (game.getDie().getDie() == 1) {
            imgMonsterCurseItem.setImage(Dice1);
        } else if (game.getDie().getDie() == 2) {
            imgMonsterCurseItem.setImage(Dice2);
        } else if (game.getDie().getDie() == 3) {
            imgMonsterCurseItem.setImage(Dice3);
        } else if (game.getDie().getDie() == 4) {
            imgMonsterCurseItem.setImage(Dice4);
        } else if (game.getDie().getDie() == 5) {
            imgMonsterCurseItem.setImage(Dice5);
        } else if (game.getDie().getDie() == 6) {
            imgMonsterCurseItem.setImage(Dice6);
        } else {
            System.out.println("tilfældigt");
        }
    }
}
