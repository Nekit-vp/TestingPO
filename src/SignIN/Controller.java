package SignIN;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField log;
    @FXML
    private TextField pas;

    @FXML
    void initialize() throws IOException {
        User.addAllUsers();
    }

    @FXML
    public void OnClickButtonSignIn(ActionEvent event) {
        if (User.check(log.getText(), pas.getText())){
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Successfully!");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wrong login or password");
            alert.showAndWait();
        }
    }
}
