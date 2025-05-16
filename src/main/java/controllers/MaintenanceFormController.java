package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Cars;
import models.Dto.CreateMaintenanceDto;
import models.Staff;
import models.enums.StaffPositionEnum;
import models.enums.StatusMaintenanceEnum;
import repository.CarRepository;
import repository.MaintenanceRepository;
import repository.StaffRepository;
import services.SessionManager;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MaintenanceFormController extends BaseController{
    @FXML
    private ComboBox<Cars> comboCar;

    @FXML
    private TextArea txtDescription;

    @FXML
    private DatePicker dateStart;

    @FXML
    private DatePicker dateFinish;

    @FXML
    private TextField txtCost;

    @FXML
    private ComboBox<StatusMaintenanceEnum> comboStatus;

    @FXML
    private ComboBox<Staff> comboStaff;

    @FXML
    private Label labelStaff;

    CarRepository carRepository;
    MaintenanceRepository maintenanceRepository;
    StaffRepository staffRepository;

    public void initialize() throws SQLException {
        this.carRepository = new CarRepository();
        this.maintenanceRepository = new MaintenanceRepository();
        this.staffRepository = new StaffRepository();

        List<Cars> allCars = carRepository.getAll();

        List<Staff> allStaff = staffRepository.getAll();

        comboCar.setItems(FXCollections.observableArrayList(allCars));
        comboStaff.setItems(FXCollections.observableArrayList(allStaff));

        // e rregullon me dal modelet e makinave ne drop liste
        comboCar.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Cars car, boolean empty) {
                super.updateItem(car, empty);
                setText(empty || car == null ? null : car.getModel());
            }
        });

        // e rregullon qe me dal modeli pasi te selektohet
        comboCar.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Cars car, boolean empty) {
                super.updateItem(car, empty);
                setText(empty || car == null ? null : car.getModel());
            }
        });

        comboStaff.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Staff staff, boolean empty) {
                super.updateItem(staff, empty);
                setText(empty || staff == null ? null : staff.getUsername());
            }
        });

        comboStaff.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Staff staff, boolean empty) {
                super.updateItem(staff, empty);
                setText(empty || staff == null ? null : staff.getUsername());
            }
        });

        comboStatus.setItems(FXCollections.observableArrayList(StatusMaintenanceEnum.values()));

        if (StaffPositionEnum.STAFF.equals(SessionManager.getInstance().getCurrentStaff().getPosition())) {
            comboStaff.setVisible(false);
            comboStaff.setManaged(false);
            labelStaff.setVisible(false);
            labelStaff.setManaged(false);
        }
    }


    @FXML
    private void handleSaveMaintenance(){
        try{
            Cars selectedCar = comboCar.getValue();
            String description = txtDescription.getText();
            Date start = Date.valueOf(dateStart.getValue());
            Date finish = Date.valueOf(dateFinish.getValue());
            BigDecimal cost = new BigDecimal(txtCost.getText());
            Staff staff = comboStaff.getValue();

            if (description.isEmpty()|| start == null || finish == null) {
                showAlert(Alert.AlertType.ERROR, "warning.title", "warning.emptyFields");
                return;
            }
            if (start.after(finish)){
                showAlert(Alert.AlertType.WARNING,"warning.title", "warning.emptyFields");
            }
            if(StaffPositionEnum.STAFF.equals(SessionManager.getInstance().getCurrentStaff().getPosition())){
                maintenanceRepository.create(new CreateMaintenanceDto(
                        selectedCar.getId(),
                        start,
                        description,
                        finish,
                        cost,
                        comboStatus.getValue(),
                        SessionManager.getInstance().getCurrentStaff().getId()
                ));
            }else{
                maintenanceRepository.create(new CreateMaintenanceDto(
                        selectedCar.getId(),
                        start,
                        description,
                        finish,
                        cost,
                        comboStatus.getValue(),
                        staff.getId()
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
