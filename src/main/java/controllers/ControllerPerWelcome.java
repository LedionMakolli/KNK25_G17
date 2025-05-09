package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import services.SceneManager;
import utils.SceneLocator;
//TA DINI QE QIKJO VEQ PROVE PER BUTON
public class ControllerPerWelcome {
    @FXML
    private void ClickOnChangePassword() {
        try {
            System.out.println("Kycja");
            SceneManager.load(SceneLocator.CHANGE_PASSWORD_PAGE);
        } catch (Exception e) {

            showAlert(Alert.AlertType.ERROR, "Gabim", "Ka ndodhur një problem gjatë ngarkimit të faqes së ndryshimit të fjalëkalimit.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
