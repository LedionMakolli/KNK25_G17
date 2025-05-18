package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Contract;
import models.Dto.CreateContractDto;
import repository.ContractRepository;
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



    @Override
    public void initialize() throws SQLException {
        super.initialize();
    }

    @FXML
    private void handleSaveClick(){
        String reservationIdTxt = txtFieldReservationId.getText();
        String paymentIdTxt = txtFieldPaymentId.getText();
        String amountTxt = txtFieldAmount.getText();
        LocalDate dateDp = dpDate.getValue();

        if(reservationIdTxt.isEmpty() || paymentIdTxt.isEmpty() || amountTxt.isEmpty() || dateDp == null){
            showAlert(Alert.AlertType.ERROR, "warning.title", "warning.emptyFields");
            return;
        }

        int reservationId = Integer.parseInt(reservationIdTxt);
        int paymentId = Integer.parseInt(paymentIdTxt);
        double amount = Double.parseDouble(amountTxt);
        Date date = Date.valueOf(dateDp);

        try{
            CreateContractDto contractDto = new CreateContractDto(paymentId, reservationId, amount, date);

            ContractRepository contractRepository = new ContractRepository();
            Contract contract = contractRepository.create(contractDto);

            if(contract != null){
                SceneManager.load(SceneLocator.SEE_CONTRACTS);
                showAlert(Alert.AlertType.INFORMATION, "success.title", "success.contractForm");
            }else {
                showAlert(Alert.AlertType.ERROR, "error.title", "error.contractForm");
            }
        }catch(Exception e){
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "error.title", "error.contractProcess");
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
