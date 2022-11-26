package ApplicationUI;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class RegisterStudent_controller
{
    Main m = new Main();
    @FXML
    private Button button;

    @FXML
    private Button return_button;
    @FXML
    private TextField Roll_num;

    @FXML
    private Label error_label;

    @FXML
    private TextField name;

    public void register_student(javafx.event.ActionEvent actionEvent)throws IOException {
        if (name.getText().isEmpty() || Roll_num.getText().isEmpty())
        {
            error_label.setText("Error: Kindly enter details!");
        }
        else
        {
            Hostel hostel = new Hostel();
            hostel.register_student(name.getText(), Roll_num.getText(),0,0);
        }
        error_label.setText("");
    }
    public void return_back() throws IOException {
        m.changeScene("welcome.fxml");
    }
}
