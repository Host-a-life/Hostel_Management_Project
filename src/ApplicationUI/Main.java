package ApplicationUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;
    //static Hostel obj = new Hostel();

    public static Integer getStudid() {
        return studid;
    }

    public static void setStudid(Integer studid) {
        Main.studid = studid;
    }

    private static Integer studid = null;


    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("HMS");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Main.class.getResource(fxml));
        Scene scene = new Scene(pane,600,400);
        stg.setScene(scene);
        //stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
        //System.out.println("hello");
        //obj.mainfunction();
    }
}
