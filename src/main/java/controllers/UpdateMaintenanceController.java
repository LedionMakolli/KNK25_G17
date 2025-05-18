package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import services.UpdateMaintenanceService;

public class UpdateMaintenanceController extends BaseController {

    @FXML private TextField txtId;
    @FXML private ComboBox<String> txtChooseStatus;
    @FXML private Button btnUpdate;

    private UpdateMaintenanceService updateMaintenanceService;

    @FXML
    public void initialize() {
        try {
            super.initialize();
            this.updateMaintenanceService = new UpdateMaintenanceService();
            txtChooseStatus.getItems().addAll("PLANED", "IN_PROCESS", "FINISHED", "CANCELED");
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.initService"
            );
        }
    }

    @FXML
    private void updateSpecificTable() {
        String idStr = txtId.getText();
        String status = txtChooseStatus.getValue();

        if (idStr.isEmpty() || status == null) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.fillAllFields"
            );
            return;
        }

        if (!idStr.matches("\\d+")) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.invalidId"
            );
            return;
        }

        int id = Integer.parseInt(idStr);

        try {
            boolean updated = updateMaintenanceService.updateMaintenanceStatus(id, status);
            if (updated) {
                showAlertBasedOnLanguage(
                        AlertType.INFORMATION,
                        "alert.success",
                        "maintenance.updated"
                );
                resetFields();
            } else {
                showAlertBasedOnLanguage(
                        AlertType.INFORMATION,
                        "alert.info",
                        "maintenance.notFound"
                );
            }
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.database:" + e.getMessage()
            );
        }
    }

    private void resetFields() {
        txtId.clear();
        txtChooseStatus.getSelectionModel().clearSelection();
    }
}
