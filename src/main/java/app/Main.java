package app;

import controllers.ChangeLanguageController;
import javafx.application.Application;
import javafx.stage.Stage;
import services.LanguageManager;
import services.SceneManager;
import java.util.Locale;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager manager = SceneManager.getInstance();

        stage.setScene(manager.getScene());
        stage.setTitle("Log In");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
