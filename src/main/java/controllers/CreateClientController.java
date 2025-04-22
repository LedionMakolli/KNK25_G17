package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
    private TextField txtPassword;

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
            Clients client = this.clientService.create(this.getClientInputData());
            System.out.println("Client inserted successfully!");
            System.out.println("Client Id: " + client.getId());
            this.cleanFields();
        } catch (Exception e) {
            System.out.println("Error inserting client: " + e.getMessage());
        }
    }

    private void cleanFields() {
        this.txtFirstName.setText("");
        this.txtLastName.setText("");
        this.txtAge.setText("");
        this.txtPersonalNumber.setText("");
        this.txtEmail.setText("");
        this.txtUsername.setText("");
        this.txtPassword.setText("");
        this.txtTelephoneNumber.setText("");
    }

    private CreateClientDto getClientInputData() {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String personalNumber = txtPersonalNumber.getText();
        String email = txtEmail.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String telephoneNumber = txtTelephoneNumber.getText();

        return new CreateClientDto(firstName, lastName, age, personalNumber, email, username, password, telephoneNumber);
    }
}
