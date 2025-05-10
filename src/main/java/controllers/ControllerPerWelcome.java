package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import services.SceneManager;
import utils.SceneLocator;
//TA DINI QE QIKJO VEQ PROVE PER BUTON
public class ControllerPerWelcome {
    @FXML
    private Button btnContracts;


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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
