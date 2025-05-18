package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import services.UpdateTablesService;

import java.sql.SQLException;

public class UpdateTablesController extends BaseController {

    @FXML private ComboBox<String> txtChooseTable;
    @FXML private TextField txtId;
    @FXML private CheckBox btnApprove;
    @FXML private Button btnUpdate;

    private UpdateTablesService updateTablesService;

    @FXML
    public void initialize() throws SQLException {
        super.initialize();
        ObservableList<String> tables = FXCollections.observableArrayList("Penalties", "SpecialRequests");
        txtChooseTable.setItems(tables);
        try {
            this.updateTablesService = new UpdateTablesService();
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
        String selectedTable = txtChooseTable.getValue();
        String idStr          = txtId.getText();
        boolean isApproved    = btnApprove.isSelected();

        if (selectedTable == null || idStr.isEmpty()) {
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
            boolean updated = false;
            if ("Penalties".equals(selectedTable)) {
                updated = updateTablesService.updatePenalties(id, isApproved);
            } else if ("SpecialRequests".equals(selectedTable)) {
                updated = updateTablesService.updateSpecialRequests(id, isApproved);
            }

            if (updated) {
                showAlertBasedOnLanguage(
                        AlertType.INFORMATION,
                        "alert.success",
                        "update.success"
                );
                resetFields();
            } else {
                showAlertBasedOnLanguage(
                        AlertType.INFORMATION,
                        "alert.info",
                        "update.notFound"
                );
            }
        } catch (Exception e) {
            showAlertBasedOnLanguage(
                    AlertType.ERROR,
                    "alert.error",
                    "error.database"
            );
        }
    }

    private void resetFields() {
        txtChooseTable.getSelectionModel().clearSelection();
        txtId.clear();
        btnApprove.setSelected(false);
    }
}
