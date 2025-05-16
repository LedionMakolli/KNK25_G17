package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.enums.UserTypeEnum;
import services.LanguageManager;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

import java.util.Locale;
import java.util.ResourceBundle;

public class BaseController {
    protected SceneManager sceneManager = SceneManager.getInstance();
    protected LanguageManager languageManager = LanguageManager.getInstance();

    @FXML protected RadioMenuItem txtShqip;
    @FXML protected RadioMenuItem txtEnglish;
    @FXML protected MenuItem seeDocuments;
    @FXML protected MenuItem seeContract;
    @FXML protected MenuItem seePayments;
    @FXML protected MenuItem gotoHomepage;
    @FXML protected MenuItem changePassword;
    @FXML protected MenuItem SignOut;
    @FXML protected MenuItem addContract;
    @FXML protected MenuItem menuAdd;
    @FXML protected MenuItem addPayment;
    @FXML protected MenuItem aboutProgram;
    @FXML protected MenuItem updateTable;
    @FXML protected Menu update;


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

    public void handleAddPayment(){
        try{
            SceneManager.load(SceneLocator.PAYMENT_FORM);
        }catch (Exception e){
            showErrorAlert("Unable to load Payment Form", "An error occured while trying to load the PaymentForm page");
        }
    }

    public void seeDocuments() {
        try {
            SceneManager.load(SceneLocator.DOCUMENTS);
        } catch (Exception e) {
            showErrorAlert("Unable to load Document Form", "An error occured while trying to load the Documents page");
        }
    }

    public void seePayments() {
        try {
            SceneManager.load(SceneLocator.SEE_PAYMENTS);
        } catch (Exception e) {
            showErrorAlert("Unable to load Document Form", "An error occured while trying to load the Documents page");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void seePenalties() {
        try {
            SceneManager.load(SceneLocator.SEE_PENALTIES);
        } catch (Exception e) {
            showErrorAlert("Unable to load Penalties Form", "An error occured while trying to load the Penalties page");
        }
    }

    public void handleAddPenalty() {
        try {
            SceneManager.load(SceneLocator.ADD_PENALTY);
        } catch (Exception e) {
            showErrorAlert("Unable to load Penalties Form", "An error occured while trying to load the Penalties page");
        }
    }

    public void seeAboutProgram(){
        try{
            if("staff".equals(SessionManager.getInstance().getCurrentRole())) {
                SceneManager.load(SceneLocator.SEE_ABOUT_STAFF);
            }else{
                SceneManager.load(SceneLocator.SEE_ABOUT);
            }
        }catch (Exception e){
            showErrorAlert("Unable to load About Program view", "An error occured while trying to load the About page");
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("hello4");
        }
    }


    public void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showErrorAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Gabim");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void handleUpdateTable() {
        try {
            SceneManager.load(SceneLocator.UPDATE_PENALTY_REQUESTS);
        } catch (Exception e) {
            showErrorAlert("Unable to load update Form", "An error occured while trying to load the Update page");
        }
    }

//    protected void showAlerts(Alert.AlertType type, String key, Object... args) {
//        ResourceBundle rb = LanguageManager.getInstance().getResourceBundle();
//        Alert alert = new Alert(type);
//        alert.setTitle(rb.getString("alert.title"));
//        alert.setHeaderText(null);
//        alert.setContentText(String.format(rb.getString(key), args));
//        alert.showAndWait();
//    }

    @FXML
    public void initialize() {
        if (txtShqip != null && txtEnglish != null) {
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

        String role = services.SessionManager.getInstance().getCurrentRole();
        if ("client".equals(role)) {
            if (addContract != null) addContract.setVisible(false);
            if (menuAdd != null) menuAdd.setVisible(false);
            if (seeDocuments != null) seeDocuments.setVisible(false);
            if(addPayment != null) addContract.setVisible(false);
            if(updateTable != null) updateTable.setVisible(false);
            if(update != null) update.setVisible(false);
        }

    }

}
