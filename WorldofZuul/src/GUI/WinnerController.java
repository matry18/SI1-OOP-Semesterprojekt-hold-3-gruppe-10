package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class WinnerController implements Initializable {
    @FXML
    private TextArea txtAreaWinning;
    @FXML
    private Button btnQuitFromWinning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnQuitFromWinning.setStyle("-fx-padding: 5;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 0;" + 
                      "-fx-border-radius: 3;" + 
                      "-fx-border-color: rgb("+86+","+23+","+26+");"+
                      "-fx-background-color: rgb(" + 223 + ", "+ 196 +", "+169+");");
        txtAreaWinning.setText("Hurray!!! You have won the game! Go celebrate...\n" +
"Thank you for playing. Good bye.");
    }   
    @FXML
    private void handleQuitButtonAction(ActionEvent event) {
        System.exit(0);
    }
    
}
