

package GUI;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import worldofzuul.Game;

public class GUILaunch  extends Application {

   static Game game = new Game();
    @Override
    public void start(Stage stage) throws Exception {
    
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                
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

