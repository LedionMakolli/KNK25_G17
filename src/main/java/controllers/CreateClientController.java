package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import models.Clients;
import models.Dto.CreateClientDto;
import services.ClientService;
import services.PasswordHasher;
import services.SceneManager;
import services.LanguageManager;
import utils.SceneLocator;

public class CreateClientController extends BaseController {

    @FXML private TextField txtFirstName;
    @FXML private TextField txtLastName;
    @FXML private TextField txtAge;
    @FXML private TextField txtPersonalNumber;
    @FXML private TextField txtEmail;
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private PasswordField txtConfirmPassword;
    @FXML private TextField txtTelephoneNumber;

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
        cleanFields();
        SceneManager.load(SceneLocator.LOGIN_PAGE);
    }

    @FXML
    private void handleSaveClick() {
        try {
            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();
            String confirmPassword = txtConfirmPassword.getText().trim();

            if (!password.equals(confirmPassword)) {
                showAlertBasedOnLanguage(AlertType.ERROR, "error.title", "error.passwordMismatch");
                return;
            }

            if(username.length()<4){
                showAlertBasedOnLanguage(AlertType.ERROR, "error.title", "error.usernameValidation");
                return;
            }

            if(!isPasswordValid(password)){
                showAlertBasedOnLanguage(AlertType.ERROR, "error.title", "error.passwordValid");
                return;
            }

            Clients client = clientService.create(getClientInputData());
            showAlertBasedOnLanguage(AlertType.INFORMATION, "success.title", "success.clientRegistered");
            cleanFields();
            SceneManager.load(SceneLocator.LOGIN_PAGE);

        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            if ("Username is already taken".equals(msg)) {
                showAlertBasedOnLanguage(AlertType.ERROR, "error.title", "error.usernameTaken");
            } else if ("Client data is not valid!".equals(msg)) {
                showAlertBasedOnLanguage(AlertType.WARNING, "warning.title", "warning.emptyFields");
            } else {
                showAlertBasedOnLanguage(AlertType.ERROR, "error.title", "error.registrationFailed");
            }
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
        String firstName=txtFirstName.getText().trim();
        String lastName=txtLastName.getText().trim();
        int age=Integer.parseInt(txtAge.getText().trim());
        String personalNumber=txtPersonalNumber.getText().trim();
        String email=txtEmail.getText().trim();
        String username=txtUsername.getText().trim();
        String password=txtPassword.getText().trim();
        String salt=PasswordHasher.generateSalt();
        String telephoneNumber= txtTelephoneNumber.getText().trim();
        return new CreateClientDto(firstName, lastName, age, personalNumber, email, username, password, salt, telephoneNumber);
    }
}
