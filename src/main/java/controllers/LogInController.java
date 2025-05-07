package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Dto.LoginResponse;
import services.LogInService;
import services.SceneManager;
import utils.SceneLocator;

public class LogInController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    private LogInService logInService;

    public LogInController() {
        try {
            this.logInService = new LogInService();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Nuk u inicializua LogInService.");
        }
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Kujdes", "Ju lutem plotësoni të gjitha fushat!");
            return;
        }

        try {
            LoginResponse response = logInService.login(username, password);

            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Jeni kyçur si " + response.getRole());

            if ("client".equals(response.getRole())) {
                SceneManager.load("/views/welcome.fxml");// veq test
            } else if ("staff".equals(response.getRole())) {
                SceneManager.load("/views/staff_dashboard.fxml");
            }

        } catch (RuntimeException e) { // kqyre qitu noshta prej qisaj po del gabimi
            showAlert(Alert.AlertType.ERROR, "Gabim", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Nuk mund të ndërroni skenën.");
        }
    }

    @FXML
    private void handleSignUpFromLogIn() {
        try {
            SceneManager.load(SceneLocator.SIGNUP_PAGE);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Nuk mund të hapet faqja për regjistrim.");
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
