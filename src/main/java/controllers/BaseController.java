package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.LanguageManager;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.NumberFormat;
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
    @FXML protected MenuItem addMaintenance;
    @FXML protected MenuItem gotoHomepage;
    @FXML protected MenuItem changePassword;
    @FXML protected MenuItem SignOut;
    @FXML protected MenuItem addContract;
    @FXML protected MenuItem menuAdd;
    @FXML protected MenuItem addPayment;
    @FXML protected MenuItem addPenalty;
    @FXML protected MenuItem aboutProgram;
    @FXML protected MenuItem updateTable;
    @FXML protected Menu update;
    @FXML protected MenuItem seeMaintenance;
    @FXML protected MenuItem updateMaintenance;
    @FXML protected MenuItem Offers;
    @FXML protected MenuItem addOffer;
    @FXML protected MenuItem addReview;
    @FXML protected MenuItem seeInsurance;

    public void setAlbanianLanguage() {
        try{
            languageManager.setLocale(new Locale("sq"));
            SceneManager.reload();
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.changeLanguage.header",
                    "error.changeLanguage.content"
            );
        }
    }

    public void setEnglishLanguage() {
        try{
            languageManager.setLocale(new Locale("en"));
            SceneManager.reload();
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.changeLanguage.header",
                    "error.changeLanguage.content"
            );
        }
    }
    protected void loadSceneWithErrorHandling(String fxmlPath, String errorHeaderKey, String errorContentKey) {
        try {
            SceneManager.load(fxmlPath);
        } catch (Exception e) {
            ResourceBundle rb = languageManager.getResourceBundle();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(rb.getString(errorHeaderKey));
            alert.setHeaderText(rb.getString(errorHeaderKey));
            alert.setContentText(rb.getString(errorContentKey));
            alert.showAndWait();

            e.printStackTrace();
        }
    }

    @FXML
    public void SignOut() {
        loadSceneWithErrorHandling(SceneLocator.LOGIN_PAGE, "error.loadLogin.header", "error.loadLogin.content");
    }
    @FXML
    public void seeContracts() {
        loadSceneWithErrorHandling(SceneLocator.SEE_CONTRACTS, "error.loadContracts.header", "error.loadContracts.content");
    }
    @FXML
    public void goToHomepage() {
        loadSceneWithErrorHandling(SceneLocator.HOME_PAGE, "error.loadHomepage.header", "error.loadHomepage.content");
    }
    @FXML
    public void handleChangePassword() {
        loadSceneWithErrorHandling(SceneLocator.CHANGE_PASSWORD_PAGE, "error.loadChangePassword.header", "error.loadChangePassword.content");
    }
    @FXML
    public void handleAddContract() {
        loadSceneWithErrorHandling(SceneLocator.CONTRACT_FORM, "error.loadContractForm.header", "error.loadContractForm.content");
    }
    @FXML
    public void handleAddMaintenance() {
        loadSceneWithErrorHandling(SceneLocator.MAINTENANCE_FORM, "error.loadMaintenanceForm.header", "error.loadMaintenanceForm.content");
    }
    @FXML
    public void handleAddPayment() {
        loadSceneWithErrorHandling(SceneLocator.PAYMENT_FORM, "error.loadPaymentForm.header", "error.loadPaymentForm.content");
    }
    @FXML
    public void seeDocuments() {
        loadSceneWithErrorHandling(SceneLocator.DOCUMENTS, "error.loadDocuments.header", "error.loadDocuments.content");
    }

    @FXML
    public void seePayments() {
        loadSceneWithErrorHandling(SceneLocator.SEE_PAYMENTS, "error.loadPayments.header", "error.loadPayments.content");
    }
    @FXML
    public void seeReservations() {
        loadSceneWithErrorHandling(SceneLocator.SEE_RESERVATIONS, "error.loadReservations.header", "error.loadReservations.content");
    }
    @FXML
    public void seePenalties() {
        loadSceneWithErrorHandling(SceneLocator.SEE_PENALTIES, "error.loadPenalties.header", "error.loadPenalties.content");
    }
    @FXML
    public void addReview() {
        loadSceneWithErrorHandling(SceneLocator.REVIEW_FORM, "error.loadReviews.header", "error.loadReviews.content");
    }

    @FXML
    public void seeMaintenance() {
        loadSceneWithErrorHandling(SceneLocator.SEE_MAINTENANCE, "error.loadMaintenances.header", "error.loadMaintenances.content");
    }
    @FXML
    public void Offers() {
        loadSceneWithErrorHandling(SceneLocator.OFFERS_FORM, "error.loadOffers.header", "error.loadOffers.content");
    }
    @FXML
    public void seeInsurance() {
        loadSceneWithErrorHandling(SceneLocator.SEE_INSURANCE, "error.loadInsurance.header", "error.loadInsurance.content");
    }
    @FXML
    public void seeAboutProgram(){
        try{
            if("staff".equals(SessionManager.getInstance().getCurrentRole())) {
                SceneManager.load(SceneLocator.SEE_ABOUT_STAFF);
            }else{
                SceneManager.load(SceneLocator.SEE_ABOUT);
            }
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadAboutProgram.header",
                    "error.loadAboutProgram.content"
            );            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    @FXML
    public void handleUpdateTable() {
        loadSceneWithErrorHandling(SceneLocator.UPDATE_PENALTY_REQUESTS, "error.handleUpdateTable.header", "error.handleUpdateTable.content");
    }
    @FXML
    public void handleAddPenalty() {
        loadSceneWithErrorHandling(SceneLocator.ADD_PENALTY, "error.handlePenalty.header", "error.handlePenalty.content");
    }
    @FXML
    public void handleUpdateMaintenance() {
        loadSceneWithErrorHandling(SceneLocator.UPDATE_MAINTENANCE, "error.handleUpdateMaintenance.header", "error.handleUpdateMaintenance.content");
    }
    @FXML
    public void handleAddOffer() {
        loadSceneWithErrorHandling(SceneLocator.ADD_OFFER, "error.handleAddOffer.header", "error.handleAddOffer.content");
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

    @FXML
    public void initialize() throws SQLException {
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
            if(seeMaintenance!=null) seeMaintenance.setVisible(false);
            if(updateMaintenance!=null) updateMaintenance.setVisible(false);
            if(addOffer!=null) addOffer.setVisible(false);
            if(seeInsurance!=null) seeInsurance.setVisible(false);
        } else if("staff".equals(role)) {
            if(addReview!=null) addReview.setVisible(false);
        }
    }

    protected boolean isPasswordValid(String password) {
        return password.length() >= 8 && password.matches(".*[^a-zA-Z0-9].*");
    }

    protected void showAlertBasedOnLanguage(Alert.AlertType alertType, String titleKey, String messageKey) {
        String title = LanguageManager.getInstance().getResourceBundle().getString(titleKey);
        String message = LanguageManager.getInstance().getResourceBundle().getString(messageKey);
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    protected void showAlertBasedOnLanguage(Alert.AlertType alertType, String titleKey, String messageKey,Object... params) {
        String title = LanguageManager.getInstance().getResourceBundle().getString(titleKey);
        ResourceBundle bundle = LanguageManager.getInstance().getResourceBundle();
        String pattern = bundle.getString(messageKey);

        String message = MessageFormat.format(pattern, params);
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
