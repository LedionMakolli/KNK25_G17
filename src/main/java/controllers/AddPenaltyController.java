package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Dto.CreatePenaltyDto;
import models.Penalties;
import services.PenaltyService;
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

    private PenaltyService penaltyService;

    @FXML
    public void initialize() {
        super.initialize();
        try {
            this.penaltyService = new PenaltyService();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to initialize service");
        }
    }

    @FXML
    private void handleSaveClick() {
        try {
            int reservationId = Integer.parseInt(txtFieldReservationId.getText());
            String reason = txtFieldReason.getText();
            BigDecimal amount = new BigDecimal(txtFieldAmount.getText());
            LocalDateTime dateTime = dpDate.getValue().atStartOfDay();
            boolean paid = cbPaid.isSelected();

            CreatePenaltyDto dto = new CreatePenaltyDto(reservationId, reason, amount, paid);
            dto.setDate(dateTime);

            PenaltyService penaltyService = new PenaltyService();
            Penalties penalty = penaltyService.addPenalty(dto);

            if (penalty != null) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Penalty added successfully");
                clearForm();
                SceneManager.load(SceneLocator.HOME_PAGE);
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to add penalty");
            }

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Reservation ID and Amount must be valid numbers");
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", e.getMessage());
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
