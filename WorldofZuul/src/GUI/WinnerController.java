package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author aalsc
 */
public class WinnerController implements Initializable {
    @FXML
    private TextArea txtAreaWinning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtAreaWinning.setText("Hurra!!! You have won the game! Go celebrate...\n" +
"Thank you for playing. Good bye.");
    }    
    
}
