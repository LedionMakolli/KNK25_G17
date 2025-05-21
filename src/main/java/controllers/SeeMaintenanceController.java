package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Maintenance;
import models.enums.StatusMaintenanceEnum;
import services.MaintenanceService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SeeMaintenanceController extends BaseController {
    @FXML
    private TableView<Maintenance> maintenanceTable;

    @FXML
    private TableColumn<Maintenance, Integer> idMaintenanceColumn;

    @FXML
    private TableColumn<Maintenance, Integer>  idCarColumn;

    @FXML
    private TableColumn<Maintenance, String> description;

    @FXML
    private TableColumn<Maintenance, Date> dateStartColumn;

    @FXML
    private TableColumn<Maintenance, Date> dateEndColumn;

    @FXML
    private TableColumn<Maintenance, BigDecimal> costColumn;

    @FXML
    private TableColumn<Maintenance, StatusMaintenanceEnum> maintenanceStatusColumn;
    @FXML
    private TableColumn<Maintenance, Integer> idStaffColumn;

    private MaintenanceService maintenanceService;
    @Override
    public void initialize() {
     try{
         super.initialize();
         this.maintenanceService = new MaintenanceService();
         loadMaintenance();
         setupTable();
     }catch(SQLException e){
         e.printStackTrace();
     }
    }

    private void setupTable(){
        idMaintenanceColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCarColumn.setCellValueFactory(new PropertyValueFactory<>("idCar"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateStartColumn.setCellValueFactory(new PropertyValueFactory<>("dateStart"));
        dateEndColumn.setCellValueFactory(new PropertyValueFactory<>("dateFinish"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        maintenanceStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        idStaffColumn.setCellValueFactory(new PropertyValueFactory<>("idStaff"));
    }

    private void loadMaintenance(){
        try{
            List<Maintenance> maintenances = maintenanceService.getMaintenanceByRole();
            ObservableList<Maintenance> data = FXCollections.observableArrayList(maintenances);
            maintenanceTable.setItems(data);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
