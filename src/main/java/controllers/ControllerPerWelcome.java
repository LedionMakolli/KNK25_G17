package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import services.LanguageManager;
import services.SceneManager;
import utils.SceneLocator;

import java.util.Locale;

//TA DINI QE QIKJO VEQ PROVE PER BUTON
public class ControllerPerWelcome extends BaseController{

    private SceneManager sceneManager;

    private SceneManager getSceneManager() {
        if (sceneManager == null) {
            sceneManager = SceneManager.getInstance();
        }
        return sceneManager;
    }

    @FXML
    private void ClickOnChangePassword() {
        try {
            System.out.println("Kycja");
            SceneManager.load(SceneLocator.CHANGE_PASSWORD_PAGE);
        } catch (Exception e) {

            showAlert(Alert.AlertType.ERROR, "Gabim", "Ka ndodhur një problem gjatë ngarkimit të faqes së ndryshimit të fjalëkalimit.");
        }
    }

    @FXML
    public void seeContracts(){
        try{
            SceneManager.load(SceneLocator.SEE_CONTRACTS);
        }catch (Exception e){
            showErrorAlert("Unable to load Contracts",
                    "An error occurred while trying to load the contracts page.");
        }
    }
}
