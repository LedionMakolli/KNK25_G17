package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Dto.UpdatePenaltyDto;
import models.Dto.UpdateSpecialRequestsDto;
import models.SpecialRequests;
import repository.PenaltiesRepository;
import repository.SpecialRequestsRepository;

import java.sql.*;

public class UpdateTablesController extends BaseController {

    @FXML
    private ComboBox<String> txtChooseTable;

    @FXML
    private TextField txtId;

    @FXML
    private CheckBox btnApprovement;

    @FXML
    private Button btnUpdate;

    @FXML
    public void initialize() {
        ObservableList<String> tables = FXCollections.observableArrayList("Penalties", "SpecialRequests");
        txtChooseTable.setItems(tables);
    }

    @FXML
    private void updateSpecificTable() {
        String selectedTable = txtChooseTable.getValue();
        String idStr = txtId.getText();
        boolean isApproved = btnApprovement.isSelected();

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
            if (selectedTable.equals("Penalties")) {
                UpdatePenaltyDto dto = new UpdatePenaltyDto(id, isApproved);
                PenaltiesRepository repo = new PenaltiesRepository();
                var result = repo.updatePaguar(dto);

                if (result != null) {
                    showAlert("Success", "Penalty updated successfully.");
                } else {
                    showAlert("Info", "Penalty not found.");
                }

            } else if (selectedTable.equals("SpecialRequests")) {
                SpecialRequestsRepository specialRequestsRepository = new SpecialRequestsRepository();
                SpecialRequests specialRequest = specialRequestsRepository.getById(id);

                if (specialRequest != null) {
                    UpdateSpecialRequestsDto dto = new UpdateSpecialRequestsDto(
                            specialRequest.getId(),
                            specialRequest.getIdReservation(),
                            specialRequest.getRequest(),
                            isApproved
                    );
                    var result = specialRequestsRepository.update(dto);
                    if (result != null) {
                        showAlert("Success", "Special request updated successfully.");
                    } else {
                        showAlert("Info", "Failed to update special request.");
                    }
                } else {
                    showAlert("Info", "Special request not found.");
                }
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
}
