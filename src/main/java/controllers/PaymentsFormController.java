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
import models.enums.PaymentEnum;
import repository.PaymentsRepository;
import repository.PromoCodeRepository;
import services.PaymentsService;
import services.SceneManager;
import utils.SceneLocator;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class PaymentsFormController extends BaseController{
    @FXML private TextField txtFieldReservationId;
    @FXML private ComboBox cbPaymentType;
    @FXML private TextField txtFieldPromocodeId;
    @FXML private TextField txtFieldTotalNoDiscount;

    @FXML private DatePicker dpDate;
    @FXML private Button btnSave;
    @FXML private Button btnCancel;

    @FXML
    public void initialize() {
        cbPaymentType.getItems().addAll(PaymentEnum.values());
    }

    @FXML
    private void handleSaveClick() {

        String reservationIdTxt = txtFieldReservationId.getText();
        String paymentType  = cbPaymentType.getSelectionModel().getSelectedItem().toString();
        String promocodeIdTxt = txtFieldPromocodeId.getText();
        String totalNodiscountTxt = txtFieldTotalNoDiscount.getText();
        LocalDate dateDp = dpDate.getValue();

        if (reservationIdTxt.isEmpty()|| paymentType.isEmpty() || totalNodiscountTxt.isEmpty() || dateDp == null) {
            showAlert(Alert.AlertType.ERROR, "warning.title", "warning.emptyFields");
            return;
        }

        int reservationId = Integer.parseInt(reservationIdTxt);
        BigDecimal totalNodiscount = new BigDecimal(totalNodiscountTxt);
         LocalDateTime dateTime = dateDp.atStartOfDay();

         Integer promocodeId = null;
         if(promocodeIdTxt !=null && !promocodeIdTxt.trim().isEmpty()){
             promocodeId = Integer.parseInt(promocodeIdTxt);
         }
         try{

            Payments payments = new Payments(0,reservationId, paymentType, promocodeId, totalNodiscount,null,  dateTime);
             PaymentsService paymentsService = new PaymentsService();

             paymentsService.calculateTotalAmount(payments);

             Payments saved = paymentsService.save(payments);


            if(saved  != null){
                SceneManager.load(SceneLocator.HOME_PAGE); //spo di ku duhna me qit
                showAlert(Alert.AlertType.INFORMATION, "success", "success");
            }else{
                showAlert(Alert.AlertType.ERROR, "fail", "fail");
            }
        }catch (Exception e){
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "fail", "fail");
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
