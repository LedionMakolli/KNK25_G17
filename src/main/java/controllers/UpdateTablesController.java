package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.UpdateTablesService;

import java.sql.SQLException;

public class UpdateTablesController extends BaseController {

    @FXML
    private ComboBox<String> txtChooseTable;

    @FXML
    private TextField txtId;

    @FXML
    private CheckBox btnApprove;

    @FXML
    private Button btnUpdate;

    private UpdateTablesService updateTablesService;

    @FXML
    public void initialize() throws SQLException {
        super.initialize();
        ObservableList<String> tables = FXCollections.observableArrayList("Penalties", "SpecialRequests");
        txtChooseTable.setItems(tables);
        try {
            this.updateTablesService = new UpdateTablesService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateSpecificTable() {
        String selectedTable = txtChooseTable.getValue();
        String idStr = txtId.getText();
        boolean isApproved = btnApprove.isSelected();

        if (selectedTable == null || idStr.isEmpty()) {
            showAlert("Error", "Please fill all fields.");
            return;
        }

        if (!idStr.matches("\\d+")) {
            showAlert("Error", "ID must be a number.");
            return;
        }

        int id = Integer.parseInt(idStr);

        try {
            boolean updated = false;

            if (selectedTable.equals("Penalties")) {
                updated = this.updateTablesService.updatePenalties(id, isApproved);

            } else if (selectedTable.equals("SpecialRequests")) {
                updated = this.updateTablesService.updateSpecialRequests(id, isApproved);
            }

            if (updated) {
                showAlert("Success", selectedTable + " updated successfully.");
                this.resetFields();
            } else {
                showAlert("Info", selectedTable + " not found or update failed.");
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
        txtChooseTable.getSelectionModel().clearSelection();
        txtId.clear();
        btnApprove.setSelected(false);
    }
}
