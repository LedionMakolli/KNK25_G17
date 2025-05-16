package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Reservations;
import models.enums.ReservationStatusEnum;
import services.ReservationService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationsController extends BaseController{
    @FXML
    private TableView<Reservations> reservationsTable;

    @FXML
    private TableColumn<Reservations,Integer> idColumn;

    @FXML
    private TableColumn<Reservations,Integer> ClientColumn;

    @FXML
    private TableColumn<Reservations,Integer> CarColumn;

    @FXML
    private TableColumn<Reservations,LocalDateTime> startDateColumn;

    @FXML
    private TableColumn<Reservations,LocalDateTime> endDateColumn;

    @FXML
    private TableColumn<Reservations, ReservationStatusEnum> reservationStatusColumn;

    @FXML
    private TableColumn<Reservations,LocalDateTime> createdAtColumn;

    private ReservationService reservationService;

    public void initialize(){
        try{
            this.reservationService = new ReservationService();
            loadReservations();
            setupTableColumns();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    private void setupTableColumns(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ClientColumn.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        CarColumn.setCellValueFactory(new PropertyValueFactory<>("idCar"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        reservationStatusColumn.setCellValueFactory(new PropertyValueFactory<>("reservationStatus"));
        createdAtColumn.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
    }

    private void loadReservations(){
        try{
            List<Reservations> reservations = reservationService.getRole();

            ObservableList<Reservations> data = FXCollections.observableArrayList(reservations);
            reservationsTable.setItems(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
