package ApplicationUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RoomAvailability_controller
{
    Hostel hostel = new Hostel();
    Main m = new Main();
    @FXML
    private TextField room_id;
    @FXML
    private Label seat1;
    @FXML
    private Label seat2;
    @FXML
    private Label seat3;
    @FXML
    private Button button;

    @FXML
    private Button rbutton;

    public void check_room_availability()
    {
        int room[] = new int[]{1,1,1};
        if (room_id.getText().isEmpty() || room_id.getText() == null) {

        }
        else
        {
            int id = Integer.parseInt(room_id.getText());
           room = hostel.check_room_availability(id);
           if(room[0] == 0)
           {
               seat1.setText("Seat 1 is free");
           }
           if(room[1] == 0)
           {
               seat2.setText("Seat 2 is free");
           }
           if(room[2] == 0)
           {
               seat3.setText("Seat 3 is free");
           }
           if (room[0] == 1)
               seat1.setText("");
           if (room[1] == 1)
               seat2.setText("");
           if (room[2] == 1)
               seat3.setText("");

        }
    }
    public void return_back(ActionEvent event) throws IOException
    {
        m.changeScene("welcome.fxml");
    }
}
