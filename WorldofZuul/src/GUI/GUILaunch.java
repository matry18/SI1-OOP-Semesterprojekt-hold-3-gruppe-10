package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import worldofzuul.Game;
import worldofzuul.Multiplayer;

public class GUILaunch extends Application {

    static Multiplayer multiplayer = new Multiplayer();
    static Game game = new Game(false);

    //game.play();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("World of Munchkin");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
