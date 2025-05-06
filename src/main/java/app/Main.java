package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("/views/create_client.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Create Client");
        stage.setScene(scene);
        stage.show();
    }
}
