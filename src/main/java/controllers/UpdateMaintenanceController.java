package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.UpdateMaintenanceService;

public class UpdateMaintenanceController extends BaseController {

    @FXML
    private TextField txtId;

    @FXML
    private ComboBox<String> txtChooseStatus;

    @FXML
    private Button btnUpdate;

    private UpdateMaintenanceService updateMaintenanceService;

    @FXML
    public void initialize() {
        try {
            super.initialize();
            this.updateMaintenanceService = new UpdateMaintenanceService();
            txtChooseStatus.getItems().addAll("PLANED", "IN_PROCESS", "FINISHED", "CANCELED");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to initialize service: " + e.getMessage());
        }
    }

    @FXML
    private void updateSpecificTable() {
        String idStr = txtId.getText();
        String status = txtChooseStatus.getValue();

        if (idStr.isEmpty() || status == null) {
            showAlert("Error", "Please fill all fields.");
            return;
        }

        if (!idStr.matches("\\d+")) {
            showAlert("Error", "ID must be a number.");
            return;
        }

        int id = Integer.parseInt(idStr);

        try {
            boolean updated = updateMaintenanceService.updateMaintenanceStatus(id, status);

            if (updated) {
                showAlert("Success", "Maintenance status updated successfully.");
                resetFields();
            } else {
                showAlert("Info", "Maintenance record not found or update failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Database Error", e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void resetFields() {
        txtId.clear();
        txtChooseStatus.getSelectionModel().clearSelection();
    }
}