package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.LanguageManager;
import services.SceneManager;
import services.SessionManager;
import utils.SceneLocator;

import java.sql.SQLException;
import java.util.Locale;

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

    public void SignOut(){
        try{
            SceneManager.load(SceneLocator.LOGIN_PAGE);
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadLogin.header",
                    "error.loadLogin.content"
            );
        }
    }
    public void seeContracts(){
        try{
            SceneManager.load(SceneLocator.SEE_CONTRACTS);
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadContracts.header",
                    "error.loadContracts.content"
            );
        }
    }

    public void goToHomepage(){
        try{
            SceneManager.load(SceneLocator.HOME_PAGE);
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadHomepage.header",
                    "error.loadHomepage.content"
            );
        }
    }

    public void handleChangePassword(){
        try{
            SceneManager.load(SceneLocator.CHANGE_PASSWORD_PAGE);
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadChangePassword.header",
                    "error.loadChangePassword.content"
            );
        }
}

    public void handleAddContract(){
        try{
            SceneManager.load(SceneLocator.CONTRACT_FORM);
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadContractForm.header",
                    "error.loadContractForm.content"
            );
        }
    }

    public void handleAddMaintenance(){
        try{
            SceneManager.load(SceneLocator.MAINTENANCE_FORM);
        }catch (Exception e){
            e.printStackTrace();
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadMaintenanceForm.header",
                    "error.loadMaintenanceForm.content"
            );
        }
    }

    public void handleAddPayment(){
        try{
            SceneManager.load(SceneLocator.PAYMENT_FORM);
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadPaymentForm.header",
                    "error.loadPaymentForm.content"
            );
        }
    }

    public void seeDocuments() {
        try {
            SceneManager.load(SceneLocator.DOCUMENTS);
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadDocuments.header",
                    "error.loadDocuments.content"
            );
        }
    }

    public void seePayments() {
        try {
            SceneManager.load(SceneLocator.SEE_PAYMENTS);
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadPayments.header",
                    "error.loadPayments.content"
            );
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void seeReservations() {
        try{
            SceneManager.load(SceneLocator.SEE_RESERVATIONS);
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadReservations.header",
                    "error.loadReservations.content"
            );            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void seePenalties() {
        try {
            SceneManager.load(SceneLocator.SEE_PENALTIES);
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadPenalties.header",
                    "error.loadPenalties.content"
            );
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
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadAboutProgram.header",
                    "error.loadAboutProgram.content"
            );            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void seeReviews() {
        try {
            SceneManager.load(SceneLocator.REVIEW_FORM);
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadReviews.header",
                    "error.loadReviews.content"
            );
            e.printStackTrace();
        }
    }

    @FXML
    public void seeMaintenance(){
        try{
            SceneManager.load(SceneLocator.SEE_MAINTENANCE);
        }catch(Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadMaintenances.header",
                    "error.loadMaintenances.content"
            );
            e.printStackTrace();
        }
    }

    public void Offers(){
        try{
            SceneManager.load(SceneLocator.OFFERS_FORM);
        }catch (Exception e){
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.loadOffers.header",
                    "error.loadOffers.content"
            );
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
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.handleUpdateTable.header",
                    "error.handleUpdateTable.content"
            );
        }
    }

    public void handleAddPenalty() {
        try {
            SceneManager.load(SceneLocator.ADD_PENALTY);
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.handlePenalty.header",
                    "error.handlePenalty.content"
            );
        }
    }

    public void handleUpdateMaintenance() {
        try {
            SceneManager.load(SceneLocator.UPDATE_MAINTENANCE);
        } catch(Exception e) {
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.handleUpdateMaintenance.header",
                    "error.handleUpdateMaintenance.content"
            );
        }
    }

    public void handleAddOffer() {
        try {
            SceneManager.load(SceneLocator.ADD_OFFER);
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    Alert.AlertType.ERROR,
                    "error.handleAddOffer.header",
                    "error.handleAddOffer.content"
            );
        }
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
        }
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
}
