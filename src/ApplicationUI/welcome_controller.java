package ApplicationUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class welcome_controller {

    Main m = new Main();
    @FXML
    private Button button;

    @FXML
    void Register_Student_Screen(ActionEvent event) throws IOException {
        m.changeScene("Register_Student.fxml");
    }

}
