package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Contract;
import models.Dto.CreateContractDto;
import repository.ContractRepository;
import services.ContractService;
import services.SceneManager;
import utils.SceneLocator;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class ContractsFormController extends BaseController{
    @FXML
    private TextField txtFieldReservationId;

    @FXML
    private TextField txtFieldPaymentId;

    @FXML
    private TextField txtFieldAmount;

    @FXML
    private DatePicker dpDate;

    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;

    private ContractService contractService;

    @Override
    public void initialize() throws SQLException {
        super.initialize();
        try{
            this.contractService = new ContractService();
        }catch(SQLException e){
            e.printStackTrace();
            showAlertBasedOnLanguage(Alert.AlertType.ERROR, "error.title", "error.contractFormError");
        }
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
    private void handleSaveClick(){
        String reservationIdTxt = txtFieldReservationId.getText();
        String paymentIdTxt = txtFieldPaymentId.getText();
        String amountTxt = txtFieldAmount.getText();
        LocalDate dateDp = dpDate.getValue();

        if(reservationIdTxt.isEmpty() || paymentIdTxt.isEmpty() || amountTxt.isEmpty() || dateDp == null){
            showAlertBasedOnLanguage(Alert.AlertType.ERROR, "warning.title", "warning.emptyFields");
            return;
        }
        if(!validateDate(dateDp)){
            return;
        }
        int reservationId = Integer.parseInt(reservationIdTxt);
        int paymentId = Integer.parseInt(paymentIdTxt);
        double amount = Double.parseDouble(amountTxt);
        Date date = Date.valueOf(dateDp);

        try{
            CreateContractDto contractDto = new CreateContractDto(paymentId, reservationId, amount, date);
            Contract contract = contractService.createContract(contractDto);

            if(contract != null){
                showAlertBasedOnLanguage(Alert.AlertType.INFORMATION, "success.title", "success.contractForm");
                seeContracts();
            }else {
                showAlert(Alert.AlertType.ERROR, "error.title", "error.contractForm");
            }
        }catch(Exception e){
            e.printStackTrace();
            showAlertBasedOnLanguage(Alert.AlertType.ERROR, "error.title", "error.contractProcess");
        }
    }
}
