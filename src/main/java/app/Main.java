package app;

import javafx.application.Application;
import javafx.stage.Stage;
import services.SceneManager;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager manager = SceneManager.getInstance();

        stage.setScene(manager.getScene());
        stage.setTitle("Rent a Car");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
