package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import services.LanguageManager;
import services.SceneManager;

import java.util.Locale;

public class BaseController {
    protected SceneManager sceneManager = SceneManager.getInstance();
    protected LanguageManager languageManager = LanguageManager.getInstance();

    @FXML private RadioMenuItem txtShqip;
    @FXML private RadioMenuItem txtEnglish;


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

    @FXML
    public void initialize() {
        ToggleGroup languageToggleGroup = new ToggleGroup();
        txtShqip.setToggleGroup(languageToggleGroup);
        txtEnglish.setToggleGroup(languageToggleGroup);


        Locale currentLocale = LanguageManager.getInstance().getLocale();

        if (currentLocale.getLanguage().equals("sq")) {
            txtShqip.setSelected(true);
        } else {
            txtEnglish.setSelected(true);
        }
    }
}
