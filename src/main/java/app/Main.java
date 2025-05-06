package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource("create_client.fxml")
        );
        Locale locale=new Locale("sq", "Kosova", "");
        ResourceBundle resources=ResourceBundle.getBundle("languages.messages", locale);
        fxmlLoader.setResources(resources);
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Create Client");
        stage.setScene(scene);
        stage.show();
    }
}
