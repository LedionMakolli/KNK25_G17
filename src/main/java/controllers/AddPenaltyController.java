package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Dto.CreatePenaltyDto;
import models.Penalties;
import services.PenaltyService;
import services.SceneManager;
import utils.SceneLocator;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddPenaltyController extends BaseController {
    @FXML private TextField txtFieldReservationId;
    @FXML private TextField txtFieldReason;
    @FXML private TextField txtFieldAmount;
    @FXML private DatePicker dpDate;
    @FXML private CheckBox cbPaid;

    private PenaltyService penaltyService;

    @FXML
    public void initialize() throws SQLException {
        super.initialize();
        try {
            this.penaltyService = new PenaltyService();
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.initService");
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

            Penalties penalty = penaltyService.addPenalty(dto);
            if (penalty != null) {
                showAlertBasedOnLanguage(AlertType.INFORMATION, "alert.success", "penalty.added");
                clearForm();
                SceneManager.load(SceneLocator.HOME_PAGE);
            } else {
                showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "penalty.failedAdd");
            }

        } catch (NumberFormatException e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.invalidNumbers");
        } catch (IllegalArgumentException e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.validation");
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.savingPenalty");
        }
    }

    @FXML
    private void handleCancelClick() {
        try {
            clearForm();
            SceneManager.load(SceneLocator.HOME_PAGE);
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.navigateHome");
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
