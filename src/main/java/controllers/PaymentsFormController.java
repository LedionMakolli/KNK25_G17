package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import models.Dto.CreatePaymentsDto;
import models.Payments;
import models.PromoCode;
import models.Reservations;
import models.enums.PaymentEnum;
import repository.PaymentsRepository;
import repository.PromoCodeRepository;
import services.PaymentsService;
import services.SceneManager;
import utils.SceneLocator;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class PaymentsFormController extends BaseController{
    @FXML private TextField txtFieldReservationId;
    @FXML private ComboBox cbPaymentType;
    @FXML private TextField txtFieldPromocodeId;
    @FXML private DatePicker dpDate;
    @FXML private Button btnSave;
    @FXML private Button btnCancel;

    private final PaymentsService paymentsService;

     public PaymentsFormController() {
         try {
             this.paymentsService = new PaymentsService();
         } catch (SQLException e) {
             throw new RuntimeException("Failed to initialize PaymentsService", e);
         }
     }

    @FXML
    public void initialize() {
        cbPaymentType.getItems().addAll(PaymentEnum.values());
    }
    private boolean validateDate(LocalDate dateDp){
LocalDate today = LocalDate.now();

   if(dateDp.isBefore(today)){
    showAlertBasedOnLanguage(Alert.AlertType.ERROR, "error.title", "error.dateNotAccepted");
    return false;
   }
   if(dateDp.isAfter(today)){
       showAlertBasedOnLanguage(Alert.AlertType.ERROR, "error.title", "error.dateNotAccepted");
       return false;
   }
   return true;
    }

    @FXML
    private void handleSaveClick() {

        String reservationIdTxt = txtFieldReservationId.getText();
        String paymentType  = cbPaymentType.getSelectionModel().getSelectedItem().toString();
        String promocodeIdTxt = txtFieldPromocodeId.getText();
        LocalDate dateDp = dpDate.getValue();

        if (reservationIdTxt.isEmpty()|| paymentType.isEmpty() || dateDp == null) {
            showAlert(Alert.AlertType.ERROR, "warning.title", "warning.emptyFields");
            return;
        }
        if(!validateDate(dateDp)){
            return;
        }
        int reservationId = Integer.parseInt(reservationIdTxt);
         LocalDateTime dateTime = dateDp.atStartOfDay();
         Integer promocodeId = null;
         if(promocodeIdTxt !=null && !promocodeIdTxt.trim().isEmpty()){
             promocodeId = Integer.parseInt(promocodeIdTxt);
         }

         try{
             Reservations reservations = paymentsService.getReservationById(reservationId);
             Payments payments = new Payments(0,reservationId, paymentType, promocodeId, null,null,  dateTime);
             paymentsService.calculateTotalNoDiscount(payments, reservations);
             paymentsService.calculateTotalAmount(payments);
             
             Payments saved = paymentsService.save(payments);


            if(saved  != null){
                SceneManager.load(SceneLocator.SEE_PAYMENTS);
                showAlert(Alert.AlertType.INFORMATION, "success.title", "success.paymentForm");
            }else{
                showAlert(Alert.AlertType.ERROR, "error.title", "error.paymentForm");
            }
        }catch (Exception e){
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "error.title", "error.paymentProcess");
        }
    }

    @FXML
    private void handleCancelClick(){
        try{
            SceneManager.load(SceneLocator.HOME_PAGE);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
