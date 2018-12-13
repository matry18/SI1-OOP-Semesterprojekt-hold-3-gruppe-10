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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Commands.*;
import Bonuses.*;
import static GUI.GUILaunch.game;
import javafx.scene.Node;
import javafx.scene.image.Image;
import worldofmunchkin.Room;
import static GUI.GUILaunch.multiplayer;
import java.util.HashMap;
import worldofmunchkin.Game;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class FXMLController implements Initializable {

    @FXML
    private ImageView imgHeadgear, imgArmor, imgLeftHand, imgRightHand, imgFootgear, imgOneTimeUse, imgCompass, imgRoomView, imgMonsterCurseItem;
    @FXML
    private VBox VBoxAttackLevelOneTimeUseHelpQuit, VBoxOutput;
    @FXML
    private Label lblAttack, lblLevel;
    @FXML
    private TextField lblAttackLevel, txtPlayerLevel;
    @FXML
    private GridPane GridPaneCompass, GridPaneFightFleeLoot;
    @FXML
    private TextArea txtOutput;
    @FXML
    private Button btnShowCard, btnShowHeadGear, btnShowArmor, btnShowLeftHand, btnShowRightHand, btnShowFootGear, btnShowOneTimeUse, btnFlee, btnEndTurn, btnGoWest, btnGoNorth, btnGoEast, btnGoSouth,
            btnFight, btnLoot, btnQuit, btnHelp, btnOneTimeUse;
    private boolean lost = false;
    private static boolean isMultiplayer = false, attack = false;
    private Button[] buttons;
    private String[] datatypes;
    private HashMap<ImageView, String> imageInventory = new HashMap<>();
    private ImageView[] inventoryViews;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Preparing HashMap used for setInventory() so that it is easier to refer to an ImageView's 'datatype'.
        inventoryViews = new ImageView[]{imgHeadgear, imgArmor, imgLeftHand, imgRightHand, imgFootgear, imgOneTimeUse};
        datatypes = new String[]{"Headgear", "Armor", "Left hand weapon", "Right hand weapon", "Footgear", "Item"};
        for (int i = 0; i < inventoryViews.length; i++) {
            imageInventory.put(inventoryViews[i], datatypes[i]);
        }
        
        //Used instead of setting every button's style.
        buttons = new Button[]{btnOneTimeUse, btnFight, btnFlee, btnLoot, btnHelp, btnQuit, btnGoNorth, btnGoSouth, btnGoWest, btnGoEast, btnEndTurn};
        for (Button button : buttons) {
            setBtnStyle(button);
        }
        
        if (isIsMultiplayer()) {
            btnEndTurn.setOpacity(1);
        } else {
            btnEndTurn.setOpacity(0);
        }

        
        Image image = new Image(getClass().getResourceAsStream("/Pictures/BackGround/Entrance.png"));
        imgRoomView.setFitHeight(338);
        imgRoomView.setPreserveRatio(false);
        imgRoomView.setImage(image);
        Image compass = new Image(getClass().getResourceAsStream("/Pictures/BackGround/compass.png"));
        imgCompass.setImage(compass);
        Image noItem = new Image(getClass().getResourceAsStream("/Pictures/Items/default.png"));
        imgHeadgear.setImage(noItem);
        imgArmor.setImage(noItem);
        imgLeftHand.setImage(noItem);
        imgRightHand.setImage(noItem);
        imgFootgear.setImage(noItem);
        imgOneTimeUse.setImage(noItem);
        setLevel(); //This and line 102 refreshes textfields so that they are not empty at the start of the game.
        setAttackLevel();
        txtOutput.setText("Welcome to World of Munchkin\nUse the compass to move.\n" + getGame().getCurrentRoom().getExitString());
    }

    @FXML
    private void handleOneTimeUseButtonAction(ActionEvent event) {
        command("useitem");
        imgOneTimeUse.setImage(new Image(getClass().getResourceAsStream("/Pictures/Items/default.png")));
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
        removeCurse(getGame().getCurrentRoom()); //Curses always disappear after the player has been in the room.
        command("go east");
        roomSettings();
    }

    @FXML
    private void handleGoNorthButtonAction(ActionEvent event) {
        removeCurse(getGame().getCurrentRoom());
        command("go north");
        roomSettings();
    }

    @FXML
    private void handleGoWestButtonAction(ActionEvent event) {
        removeCurse(getGame().getCurrentRoom());
        command("go west");
        roomSettings();
    }

    @FXML
    private void handleGoSouthButtonAction(ActionEvent event) {
        removeCurse(getGame().getCurrentRoom());
        command("go south");
        roomSettings();
    }

    @FXML
    private void handleFightButtonAction(ActionEvent event) {
        command("fight");
        checkForWinning();
        setImgMonsterCurseItem(getGame().getCurrentRoom());
        setLevel();
        setAttackLevel();
        //Rest of handler is for checking the 'help other player' function. 
        if (!multiplayer.getCurrentGame().getCurrentRoom().isContainsMonster() && multiplayer.isHasAskedForHelp()) { //Gives the helping player a permanent bonus if the monster is defeated.
            multiplayer.bonusHelp();
        }
        resetAskedForHelp();
        if (isMultiplayer && getGame().getCurrentRoom().isContainsMonster() && !multiplayer.isHasAskedForHelp()) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("HelpFromOtherPlayer.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Begging for HELP!");
                stage.setScene(new Scene(root));

                stage.show();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @FXML
    private void handleFleeButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DiceRoll.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dice Roll");
            stage.setScene(new Scene(root));

            if (getGame().getCurrentRoom().isContainsMonster()) { //Only show die if theres's a monster in the room
                stage.show();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        command("flee");
        checkForLosing();
        if (lost) {
            ((Node) event.getSource()).getScene().getWindow().hide(); //Closes the game window.
        } else {
            roomSettings();
        }
        if (multiplayer.isHasAskedForHelp() && 5 > multiplayer.getCurrentGame().getDie().getDieResult()) { //Removes a level from also the helping player if the players lose to the monster.
            multiplayer.helpBadStuff();
        }
        resetAskedForHelp();
        setAttackLevel();
        setLevel();
    }

    @FXML
    private void handleLootButtonAction(ActionEvent event) {
        if (getGame().isBattleMode()) { //You cannot loot a room if there is a monster inside it.
            return;
        }
        command("loot");
        setInventory();
        setImgMonsterCurseItem(getGame().getCurrentRoom());
        setAttackLevel();
    }

    @FXML
    private void handleShowCardButtonAction(ActionEvent event) {
        if (getGame().getCurrentRoom().isContainsItem() || getGame().getCurrentRoom().isContainsMonster() || getGame().getCurrentRoom().isContainsCurse()) {
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

    @FXML
    private void handleEndTurnButtonAction(ActionEvent event) {
        if (!getGame().isBattleMode()) {
            command("endturn");
            multiplayer.getChangePlayer();
            checkForLosing();
            roomSettings();
            setInventory();
            setAttackLevel();
            setLevel();
        }
    }

    public void checkForWinning() {
        if (getGame().getPlayer().getLevel() == getGame().getMaxLevel()) {
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
        if (getGame().getPlayer().getLevel() <= getGame().getMinLevel()) {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("Losing.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Lost the game");
                stage.setScene(new Scene(root));

                stage.show();
                lost = true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void command(String input) { //Parser has been changed so it checks for a string instead of a scanner. This string is defined in every command handler.
        Parser parser = new Parser();
        parser.setGUICommand(input);
        getGame().processCommand(parser.getCommand());
        txtOutput.setText(getGame().getOutputDesc());
    }

    private void setImgRoom() {
        imgRoomView.setImage(new Image(getClass().getResourceAsStream(getGame().getCurrentRoom().getShortDescription())));
    }

    private void setImgMonsterCurseItem(Room room) { //Handles the main picture on the main screen. 
        if (room.isContainsMonster()) {
            imgMonsterCurseItem.setImage(new Image(getClass().getResourceAsStream(room.getMonster().getImagePath())));
        } else if (room.isContainsCurse()) {
            imgMonsterCurseItem.setImage(new Image(getClass().getResourceAsStream(room.getCurse().getImagePath())));
            setInventory();
            setAttackLevel();
        } else if (room.isContainsItem()) {
            imgMonsterCurseItem.setImage(new Image(getClass().getResourceAsStream(room.getItem().getImgPath())));
        } else {
            imgMonsterCurseItem.setImage(null);
        }
    }

    private void roomSettings() { //Loads the new room.
        if (!getGame().isNoDoor()) {
            setImgRoom();
            setImgMonsterCurseItem(getGame().getCurrentRoom());
        }
    }

    private void setInventory() { //Loads the cards in the inventory for the player.
        for (HashMap.Entry<ImageView, String> entry : imageInventory.entrySet()) {
            if (findInventoryItem(entry.getValue()) != null) {
                entry.getKey().setImage(new Image(getClass().getResourceAsStream(findInventoryItem(entry.getValue()))));
            } else {
                entry.getKey().setImage(new Image(getClass().getResourceAsStream("/Pictures/Items/default.png")));
            }
        }
    }

    protected void setAttackLevel() {
        lblAttackLevel.setText(Integer.toString(getGame().getPlayer().totalAttackValue()));
    }

    private void setLevel() {
        txtPlayerLevel.setText(Integer.toString(getGame().getPlayer().getLevel()));
    }

    private void removeCurse(Room room) {
        if (room.isContainsCurse()) {
            room.setContainsCurse(false);//Removes curse after getting hit
        }
    }

    protected static String findInventoryItem(String dataType) { //Searches the player's inventory for a specific item by the 'datatype'.
        for (Item item : getGame().getPlayer().getInventory()) {
            if (item.getDataType().equals(dataType)) {
                return item.getImgPath();
            }
        }
        return null;
    }

    private void setBtnStyle(Button b) {
        b.setStyle("-fx-padding: 5;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 0;"
                + "-fx-border-radius: 3;"
                + "-fx-border-color: rgb(" + 86 + "," + 23 + "," + 26 + ");"
                + "-fx-background-color: rgb(" + 223 + ", " + 196 + ", " + 169 + ");");
    }

    protected static void setIsMultiplayer(boolean state) {
        isMultiplayer = state;
    }

    public static boolean isIsMultiplayer() {
        return isMultiplayer;
    }

    protected static Game getGame() { //The Multiplayer class consists of two instances of Game, therefore this is necessary.
        if (isIsMultiplayer()) {
            return multiplayer.getCurrentGame();
        } else {
            return game;
        }
    }

    private void resetAskedForHelp() {
        if (isMultiplayer && multiplayer.isHasAskedForHelp() && !multiplayer.getCurrentGame().getCurrentRoom().isContainsMonster()) {
            multiplayer.getCurrentGame().getPlayer().resetTemporaryBonus();
            multiplayer.setHasAskedForHelp(false);
        }
    }
}
