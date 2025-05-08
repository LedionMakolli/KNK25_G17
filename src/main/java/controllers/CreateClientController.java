package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Clients;
import models.Dto.CreateClientDto;
import services.ClientService;
import services.PasswordHasher;
import services.SceneManager;
import services.LanguageManager;
import utils.SceneLocator;

public class CreateClientController {

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtPersonalNumber;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private TextField txtTelephoneNumber;

    private ClientService clientService;

    public CreateClientController() {
        try {
            this.clientService = new ClientService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancelClick() throws Exception {
        this.cleanFields();
        SceneManager.load(SceneLocator.LOGIN_PAGE);
    }

    @FXML
    private void handleSaveClick() {
        try {
            String password = txtPassword.getText().trim();
            String confirmPassword = txtConfirmPassword.getText().trim();

            if (!password.equals(confirmPassword)) {
                showAlert(AlertType.ERROR, "error.title", "error.passwordMismatch");
                return;
            }

            Clients client = this.clientService.create(this.getClientInputData());
            showAlert(AlertType.INFORMATION, "success.title", "success.clientRegistered");
            this.cleanFields();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "error.title", "error.registrationFailed");
        }
    }

    private void cleanFields() {
        txtFirstName.clear();
        txtLastName.clear();
        txtAge.clear();
        txtPersonalNumber.clear();
        txtEmail.clear();
        txtUsername.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
        txtTelephoneNumber.clear();
    }

    private CreateClientDto getClientInputData() {
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        int age = Integer.parseInt(txtAge.getText().trim());
        String personalNumber = txtPersonalNumber.getText().trim();
        String email = txtEmail.getText().trim();
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();
        String saltedHash = PasswordHasher.generateSalt();
        String telephoneNumber = txtTelephoneNumber.getText().trim();
        System.out.println("Salt is: " + saltedHash);
        return new CreateClientDto(firstName, lastName, age, personalNumber, email, username, password, saltedHash, telephoneNumber);
    }

    private void showAlert(AlertType alertType, String titleKey, String messageKey) {
        String title = LanguageManager.getInstance().getResourceBundle().getString(titleKey);
        String message = LanguageManager.getInstance().getResourceBundle().getString(messageKey);
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
