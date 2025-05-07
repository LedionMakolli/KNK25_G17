package app;

import javafx.application.Application;
import javafx.stage.Stage;
import repository.StaffRepository;
import services.PasswordHasher;
import services.SceneManager;

public class Main extends Application {
    public void start(Stage stage) {
        SceneManager sceneManager=SceneManager.getInstance();
        stage.setScene(sceneManager.getScene());
        stage.show();
    }
//    public static void main(String[] args) {
//        String salt = PasswordHasher.generateSalt();
//        String saltedPassword = PasswordHasher.generateSaltedHash("medimedi", salt);
//
//        boolean isValid = PasswordHasher.compareSaltedHash("medimedi", salt, saltedPassword);
//
//        System.out.println("Salti: " + salt);
//        System.out.println("Passwordi i kriposur: " + saltedPassword);

//        if (isValid) {
//            System.out.println("Fjalekalimi eshte i sakte.");
//        } else {
//            System.out.println("Fjalekalimi eshte gabim.");
//        }

//    }
}
