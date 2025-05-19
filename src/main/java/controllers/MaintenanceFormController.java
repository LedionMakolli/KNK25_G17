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
import services.CarService;
import services.MaintenanceService;
import services.SessionManager;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaintenanceFormController extends BaseController{
    @FXML
    private ComboBox<String> comboCar;

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
    private ComboBox<String> comboStaff;

    @FXML
    private Label labelStaff;


    private CarService carService;
    private MaintenanceService maintenanceService;
    StaffRepository staffRepository;
    private Map<String, Cars> modelToCarMap = new HashMap<>();
    private Map<String, Staff> usernameToStaffMap = new HashMap<>();

    public void initialize() throws SQLException {
        this.carService = new CarService();
        this.maintenanceService = new MaintenanceService();
        this.staffRepository = new StaffRepository();

        List<Cars> allCars = carService.getAllCars();
        ObservableList<String> carModels = FXCollections.observableArrayList();

        for (Cars car : allCars) {
            modelToCarMap.put(car.getModel(), car);
            carModels.add(car.getModel());
        }

        List<Staff> allStaff = staffRepository.getAll();
        ObservableList<String> staffUsernames = FXCollections.observableArrayList();

        for (Staff staff: allStaff){
            usernameToStaffMap.put(staff.getUsername(),staff);
            staffUsernames.add(staff.getUsername());
        }

        comboCar.setItems(carModels);
        comboStaff.setItems(staffUsernames);

        comboStatus.setItems(FXCollections.observableArrayList(StatusMaintenanceEnum.values()));

        if (StaffPositionEnum.STAFF.equals(SessionManager.getInstance().getCurrentStaff().getPosition())) {
            comboStaff.setVisible(false);
            comboStaff.setManaged(false);
            labelStaff.setVisible(false);
            labelStaff.setManaged(false);
        }
    }


    @FXML
    private void handleSaveMaintenance() {
        try {
            String selectedModel = comboCar.getValue();
            Cars selectedCar = modelToCarMap.get(selectedModel);

            String description = txtDescription.getText();
            Date start = Date.valueOf(dateStart.getValue());
            Date finish = Date.valueOf(dateFinish.getValue());
            BigDecimal cost = new BigDecimal(txtCost.getText());
            StatusMaintenanceEnum status = comboStatus.getValue();
            Staff staff;


            if (StaffPositionEnum.STAFF.equals(SessionManager.getInstance().getCurrentStaff().getPosition())) {
                staff = SessionManager.getInstance().getCurrentStaff();
            } else {
                String Username = comboStaff.getValue();
                staff = usernameToStaffMap.get(Username);
            }

            this.createMaintenance(selectedCar, start, description, finish, cost, status, staff);

        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Eror saving maintennace: " + e.getMessage()).showAndWait();
        }
    }

    public void createMaintenance(Cars car,Date start,String description, Date finish, BigDecimal cost, StatusMaintenanceEnum status, Staff staff){

        if (car == null || start == null || description == null || finish == null || cost == null || status == null || staff == null){
            showAlertBasedOnLanguage(Alert.AlertType.WARNING,"error","fill all the fields");
        }

        LocalDate startDate = start.toLocalDate();
        LocalDate finishDate = finish.toLocalDate();
        LocalDate today = LocalDate.now();

        if(!startDate.isBefore(finishDate)){
            showAlertBasedOnLanguage(Alert.AlertType.WARNING,"error","fill all the fields");
        }
        if (startDate.isBefore(today) || finishDate.isBefore(today)){
            showAlertBasedOnLanguage(Alert.AlertType.WARNING,"error","fill all the fields");
        }
        if (cost.compareTo(BigDecimal.ZERO) < 0){
            showAlertBasedOnLanguage(Alert.AlertType.WARNING,"error","fill all the fields");
        }
        try {
            maintenanceService.createMaintenance(car, start, description, finish, cost, status, staff);
            new Alert(Alert.AlertType.INFORMATION, "Maintenance record saved successfully.").showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error saving maintenance: " + e.getMessage()).showAndWait();
        }
    }
}
