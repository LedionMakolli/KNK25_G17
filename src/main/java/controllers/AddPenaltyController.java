package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import models.Dto.CreatePenaltyDto;
import models.Penalties;
import repository.PenaltiesRepository;
import services.SceneManager;
import utils.SceneLocator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddPenaltyController extends BaseController {
    @FXML private TextField txtFieldReservationId;
    @FXML private TextField txtFieldReason;
    @FXML private TextField txtFieldAmount;
    @FXML private DatePicker dpDate;
    @FXML private CheckBox cbPaid;
    @FXML private Button btnSave;
    @FXML private Button btnCancel;

    @FXML
    public void initialize() {
        super.initialize();
    }

    @FXML
    private void handleSaveClick() {
        String reservationIdTxt = txtFieldReservationId.getText();
        String reason = txtFieldReason.getText();
        String amountTxt = txtFieldAmount.getText();
        LocalDate dateDp = dpDate.getValue();
        boolean paid = cbPaid.isSelected();

        if (reservationIdTxt.isEmpty() || reason.isEmpty() || amountTxt.isEmpty() || dateDp == null) {
            showAlert(Alert.AlertType.ERROR, "Warning", "Please fill all required fields");
            return;
        }

        try {
            int reservationId = Integer.parseInt(reservationIdTxt);
            BigDecimal amount = new BigDecimal(amountTxt);
            LocalDateTime dateTime = dateDp.atStartOfDay();

            CreatePenaltyDto penaltyDto = new CreatePenaltyDto(
                    reservationId,
                    reason,
                    amount,
                    paid
            );
            penaltyDto.setDate(dateTime);

            PenaltiesRepository penaltyRepository = new PenaltiesRepository();
            Penalties penalty = penaltyRepository.create(penaltyDto);

            if (penalty != null) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Penalty added successfully");
                clearForm();
                SceneManager.load(SceneLocator.HOME_PAGE);
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to add penalty");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Reservation ID and Amount must be valid numbers");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while saving the penalty");
        }
    }

    @FXML
    private void handleCancelClick() {
        try {
            clearForm();
            SceneManager.load(SceneLocator.HOME_PAGE);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to navigate to homepage");
        }
    }

    private void clearForm() {
        txtFieldReservationId.clear();
        txtFieldReason.clear();
        txtFieldAmount.clear();
        dpDate.setValue(LocalDate.now());
        cbPaid.setSelected(false);
    }
}