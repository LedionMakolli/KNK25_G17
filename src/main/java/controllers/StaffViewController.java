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

public class StaffViewController {
    @FXML
    private Button btnPenalties;

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

    private void showErrorAlert(String header, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}