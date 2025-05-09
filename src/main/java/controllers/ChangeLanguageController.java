package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import services.LanguageManager;
import services.SceneManager;
import utils.SceneLocator;

import java.util.Locale;

public class ChangeLanguageController {
    @FXML
    private Button txtShqip;
    @FXML
    private Button txtEnglish;

    private SceneManager sceneManager;
    private LanguageManager languageManager;

    public ChangeLanguageController() {
        this.languageManager = LanguageManager.getInstance();
    }

    private SceneManager getSceneManager() {
        if (sceneManager == null) {
            sceneManager = SceneManager.getInstance();
        }
        return sceneManager;
    }

    public void setAlbanianLanguage() {
        try {
            languageManager.setLocale(new Locale("sq"));
            getSceneManager().load(SceneLocator.LOGIN_PAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setEnglishLanguage() {
        try {
            languageManager.setLocale(new Locale("en"));
            getSceneManager().load(SceneLocator.LOGIN_PAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
