package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import services.ChangePasswordService;

public class ChangePasswordController {
    @FXML
    private PasswordField pwdFieldOld;

    @FXML
    private PasswordField pwdFieldNew;

    @FXML
    private PasswordField pwdFieldConfirm;

    private ChangePasswordService changePasswordService;

    private String currentUsername;
    private String currentRole;

    public ChangePasswordController(){
        try{
            this.changePasswordService = new ChangePasswordService();
        }catch(Exception e){
            e.printStackTrace();

        }
    }

    public void setUserInfo(String username, String role ){
        this.currentUsername = username;
        this.currentRole = role;
    }

    @FXML
    private void handleSaveNewPassword(){
        String oldPassword = pwdFieldOld.getText().trim();
        String newPassword = pwdFieldNew.getText().trim();
        String confirmPassword = pwdFieldConfirm.getText().trim();

        if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Kujdes", "Plotësoni të gjitha fushat.");
            return;
        }
        if(!newPassword.equals(confirmPassword)){
            showAlert(Alert.AlertType.ERROR, "Gabim", "Fjalekalimi i ri dhe konfirmimi nuk perputhen");
            return;
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
