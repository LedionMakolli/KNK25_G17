package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Clients;
import models.Dto.CreateClientDto;
import services.ClientService;

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
    private void handleCancelClick() {
        this.cleanFields();
    }

    @FXML
    private void handleSaveClick() {
        try {
            String password = txtPassword.getText().trim();
            String confirmPassword = txtConfirmPassword.getText().trim();

            if (!password.equals(confirmPassword)) {
                showAlert(AlertType.ERROR, "Password Mismatch", "Fjalëkalimi dhe konfirmimi nuk përputhen.");
                return;
            }

            Clients client = this.clientService.create(this.getClientInputData());
            showAlert(AlertType.INFORMATION, "Sukses", "Klienti u regjistrua me sukses!\n" +
                    "ID e klientit: " + client.getId());
            this.cleanFields();
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Gabim", "Gabim gjatë regjistrimit: " + e.getMessage());
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
        String telephoneNumber = txtTelephoneNumber.getText().trim();

        return new CreateClientDto(firstName, lastName, age, personalNumber, email, username, password, telephoneNumber);
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
