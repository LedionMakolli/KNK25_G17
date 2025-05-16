package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Payments;
import repository.PaymentsRepository;
import services.PaymentsService;
import services.SessionManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PaymentsController extends BaseController{
    @FXML
    private TableView<Payments> paymentsTable;

    @FXML
    private TableColumn<Payments,Integer> idColumn;

    @FXML
    private TableColumn<Payments,Integer> idReservation;

    @FXML
    private  TableColumn<Payments, String> typeColumn;

    @FXML
    private  TableColumn<Payments, Integer> promocodeColumn;

    @FXML
    private  TableColumn<Payments, BigDecimal> totalDiscountColumn;

    @FXML
    private  TableColumn<Payments, BigDecimal> totalFinalColumn;

    @FXML
    private TableColumn<Payments, LocalDateTime> dateColumn;

    private PaymentsService paymentsService;

    @FXML
    public void initialize(){
        try{
            this.paymentsService = new PaymentsService();
            super.initialize();
            loadPayments();
            setupTableColumns();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setupTableColumns(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idReservation.setCellValueFactory(new PropertyValueFactory<>("idReservation"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        promocodeColumn.setCellValueFactory(new PropertyValueFactory<>("promoCodeId"));
        totalDiscountColumn.setCellValueFactory(new PropertyValueFactory<>("totalNoDiscount"));
        totalFinalColumn.setCellValueFactory(new PropertyValueFactory<>("totalFinal"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private void loadPayments(){
        try{
            List <Payments> payments = paymentsService.checkRole();

            ObservableList<Payments> data = FXCollections.observableArrayList(payments);
            paymentsTable.setItems(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
