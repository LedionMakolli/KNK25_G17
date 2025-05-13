package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import services.ChangePasswordService;
import services.LanguageManager;
import services.SceneManager;


public class ChangePasswordController extends BaseController {
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
            showAlert(Alert.AlertType.WARNING, "warning.title", "warning.emptyFields");
            return;
        }
        if(!newPassword.equals(confirmPassword)){
            showAlert(Alert.AlertType.ERROR, "error.title", "error.passwordMismatch");
            return;
        }

        try{
            boolean success = changePasswordService.changePassword(oldPassword, newPassword);
            if(success){
                showAlert( Alert.AlertType.INFORMATION, "success.title", "success.passwordChanged");
            }else {
                showAlert(Alert.AlertType.ERROR, "error.title", "error.wrongOldPassword");
            }
        }catch (Exception e){
            showAlert(Alert.AlertType.ERROR, "error.title", "error.changingPassword");
        }
    }
    @FXML
    private void handleCancelNewPassword(){
        try {
            SceneManager.load("/views/welcome.fxml");  //veq prove o qikjo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
