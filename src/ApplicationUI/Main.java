package ApplicationUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;
    public static void make_admin()
    {
        Admin_DB db = new Admin_DB();
        db.write();
    }
    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("login_admin.fxml"));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("Host-A-Life");
            primaryStage.setScene(scene);
            primaryStage.show();
            root.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
