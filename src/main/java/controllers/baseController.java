package controllers;

import javafx.scene.control.Alert;
import services.LanguageManager;
import services.SceneManager;

import java.util.Locale;

public class baseController {
    protected SceneManager sceneManager = SceneManager.getInstance();
    private LanguageManager languageManager = LanguageManager.getInstance();

    public void setAlbanianLanguage() {
        try{
            languageManager.setLocale(new Locale("sq"));
            SceneManager.reload();
        }catch (Exception e){
            showErrorAlert("Error while changing language", e.getMessage());
        }
    }

    public void setEnglishLanguage() {
        try{
            languageManager.setLocale(new Locale("en"));
            SceneManager.reload();
        }catch (Exception e){
            showErrorAlert("Error while changing language", e.getMessage());
        }
    }


    protected void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    protected void showErrorAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Gabim");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
