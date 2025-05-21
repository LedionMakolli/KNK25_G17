package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Insurance;
import services.InsuranceService;

import java.util.Date;
import java.util.List;

public class SeeInsuranceController extends BaseController {

    @FXML private TableView<Insurance> insuranceTable;
    @FXML private TableColumn<Insurance, Integer> idColumn;
    @FXML private TableColumn<Insurance, Integer> carIdColumn;
    @FXML private TableColumn<Insurance, String> companyColumn;
    @FXML private TableColumn<Insurance, Date> startDateColumn;
    @FXML private TableColumn<Insurance, Date> endDateColumn;
    @FXML private TableColumn<Insurance, Double> costColumn;

    private final InsuranceService insuranceService;

    public SeeInsuranceController() {
        try {
            this.insuranceService = new InsuranceService();
            super.initialize();
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.initInsuranceRepo");
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize() {
        try {
            super.initialize();
            setupTableColumns();
            refreshInsurance();
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.initInsuranceView");
        }
    }

    private void setupTableColumns() {
        try {
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            carIdColumn.setCellValueFactory(new PropertyValueFactory<>("idCar"));
            companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
            startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
            endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
            costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.columnSetup");
        }
    }

    @FXML
    private void refreshInsurance() {
        try {
            List<Insurance> insurances = insuranceService.getAllInsurances();
            insuranceTable.getItems().setAll(insurances);
        } catch (Exception e) {
            showAlertBasedOnLanguage(AlertType.ERROR, "alert.error", "error.loadInsurance");
        }
    }
}
