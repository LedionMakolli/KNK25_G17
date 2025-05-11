package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Dto.LoginResponse;
import services.LanguageManager;
import services.LogInService;
import services.SceneManager;
import utils.SceneLocator;

public class LogInController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    private LogInService logInService;

    public LogInController() {
        try {
            this.logInService = new LogInService();
        } catch (Exception e) {
            e.printStackTrace();
            showAlertWithKeys(Alert.AlertType.ERROR, "error.title", "error.loginServiceInitializationFailed");
        }
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlertWithKeys(Alert.AlertType.WARNING, "warning.title", "warning.emptyFields");
            return;
        }

        try {
            LoginResponse response = logInService.login(username, password);

            String roleKey = "role." + response.getRole();
            String roleTranslated = LanguageManager.getInstance().getResourceBundle().getString(roleKey);
            String loginMessage = LanguageManager.getInstance().getResourceBundle().getString("success.loginSuccessfulWithRole");

            showAlert(Alert.AlertType.INFORMATION,
                    LanguageManager.getInstance().getResourceBundle().getString("success.title"),
                    String.format(loginMessage, roleTranslated));

            if ("client".equals(response.getRole())) {
                SceneManager.load(SceneLocator.HOME_PAGE); // veq per test jon qito dyja niher
            } else if ("staff".equals(response.getRole())) {
                SceneManager.load(SceneLocator.HOME_PAGE); // momentale vetem per testim
            }

        } catch (RuntimeException e) {
            showAlertWithKeys(Alert.AlertType.ERROR, "error.title", "error.invalidCredentials");
        } catch (Exception e) {
            e.printStackTrace();
            showAlertWithKeys(Alert.AlertType.ERROR, "error.title", "error.sceneTransitionFailed");
        }
    }

    @FXML
    private void handleSignUpFromLogIn() {
        try {
            SceneManager.load(SceneLocator.SIGNUP_PAGE);
        } catch (Exception e) {
            e.printStackTrace();
            showAlertWithKeys(Alert.AlertType.ERROR, "error.title", "error.signUpPageFailed");
        }
    }

    private void showAlertWithKeys(Alert.AlertType alertType, String titleKey, String messageKey) {
        String title = LanguageManager.getInstance().getResourceBundle().getString(titleKey);
        String message = LanguageManager.getInstance().getResourceBundle().getString(messageKey);
        showAlert(alertType, title, message);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
