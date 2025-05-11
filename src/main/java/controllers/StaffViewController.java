package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.SceneManager;
import utils.SceneLocator;

public class StaffViewController extends BaseController{
    @FXML
    private Button btnPenalties;

    @FXML
    private Button btnContracts;

    @FXML
    public void seePenalties() {
        try {
            SceneManager.load(SceneLocator.SEE_PENALTIES);
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Unable to load Penalties Page",
                    "An error occurred while trying to load the penalties page.");
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