package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import services.ChangePasswordService;
import services.LanguageManager;
import services.SceneManager;
import utils.SceneLocator;


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
            super.initialize();
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
            showAlertBasedOnLanguage(Alert.AlertType.WARNING, "warning.title", "warning.emptyFields");
            return;
        }

        if(!newPassword.equals(confirmPassword)){
            showAlertBasedOnLanguage(Alert.AlertType.ERROR, "error.title", "error.passwordValidation");
            return;
        }

        if(!isPasswordValid(newPassword)){
            showAlertBasedOnLanguage(Alert.AlertType.ERROR, "error.title", "error.passwordValid");
            return;
        }

        try{
            boolean success = changePasswordService.changePassword(oldPassword, newPassword);
            if(success){
                showAlertBasedOnLanguage( Alert.AlertType.INFORMATION, "success.title", "success.passwordChanged");
            }else {
                showAlertBasedOnLanguage(Alert.AlertType.ERROR, "error.title", "error.wrongOldPassword");
            }
        }catch (Exception e){
            showAlertBasedOnLanguage(Alert.AlertType.ERROR, "error.title", "error.changingPassword");
        }
    }
    @FXML
    private void handleCancelNewPassword(){
        try {
            SceneManager.load(SceneLocator.HOME_PAGE);  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
