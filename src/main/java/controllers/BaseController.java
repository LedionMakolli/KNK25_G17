package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.LanguageManager;
import services.SceneManager;
import utils.SceneLocator;

import java.util.Locale;

public class BaseController {
    protected SceneManager sceneManager = SceneManager.getInstance();
    protected LanguageManager languageManager = LanguageManager.getInstance();

    @FXML protected RadioMenuItem txtShqip;
    @FXML protected RadioMenuItem txtEnglish;
    @FXML protected MenuItem seeDocuments;
    @FXML protected MenuItem seeContract;
    @FXML protected MenuItem gotoHomepage;
    @FXML protected MenuItem changePassword;
    @FXML protected MenuItem SignOut;
    @FXML protected MenuItem addContract;


    public void setAlbanianLanguage() {
        try{
            languageManager.setLocale(new Locale("sq"));
            SceneManager.reload();
        }catch (Exception e){
            showErrorAlert("Error while changing language", e.getMessage());
        }
    }



    public void setEnglishLanguage() {
        try{
            languageManager.setLocale(new Locale("en"));
            SceneManager.reload();
        }catch (Exception e){
            showErrorAlert("Error while changing language", e.getMessage());
        }
    }

    public void SignOut(){
        try{
            SceneManager.load(SceneLocator.LOGIN_PAGE);
        }catch (Exception e){
            showErrorAlert("Unable to load LogIn",
                    "An error occurred while trying to load the LogIn page.");
        }
    }
    public void seeContracts(){
        try{
            SceneManager.load(SceneLocator.SEE_CONTRACTS);
        }catch (Exception e){
            showErrorAlert("Unable to load Contracts",
                    "An error occurred while trying to load the contracts page.");
        }
    }

    public void goToHomepage(){
        try{
            SceneManager.load(SceneLocator.HOME_PAGE);
        }catch (Exception e){
            showErrorAlert("Unable to load Homepage",
                    "An error occured while trying to load the homepage");
        }
    }

    public void handleChangePassword(){
        try{
            SceneManager.load(SceneLocator.CHANGE_PASSWORD_PAGE);
        }catch (Exception e){
            showErrorAlert("Unable to load ChangePassword",
                    "An error occured while trying to load the ChangePassword page");
        }
}

    public void handleAddContract(){
        try{
            SceneManager.load(SceneLocator.CONTRACT_FORM);
        }catch (Exception e){
            showErrorAlert("Unable to load Contract Form", "An error occured while trying to load the ChangePassword page");
        }
    }

    public void seeDocuments() {
        try {
            SceneManager.load(SceneLocator.DOCUMENTS);
        } catch (Exception e) {
            showErrorAlert("Unable to load Document Form", "An error occured while trying to load the Documents page");
        }
    }

    protected void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    protected void showErrorAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Gabim");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        ToggleGroup languageToggleGroup = new ToggleGroup();
        txtShqip.setToggleGroup(languageToggleGroup);
        txtEnglish.setToggleGroup(languageToggleGroup);


        Locale currentLocale = LanguageManager.getInstance().getLocale();

        if (currentLocale.getLanguage().equals("sq")) {
            txtShqip.setSelected(true);
        } else {
            txtEnglish.setSelected(true);
        }
    }

}
