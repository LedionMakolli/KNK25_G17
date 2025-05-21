package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Contract;
import services.ContractService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SeeContractsController extends BaseController {
    @FXML
    private TableView<Contract> contractsTable;

    @FXML
    private TableColumn<Contract,Integer> idColumn;

    @FXML
    private TableColumn<Contract, Integer> paymenIdColumn;

    @FXML
    private TableColumn<Contract,Integer> reservationIdColumn;

    @FXML
    private TableColumn<Contract, BigDecimal> amountColumn;

    @FXML
    private TableColumn<Contract, LocalDateTime> dateColumn;


    private ContractService contractService;

    @FXML
    public void initialize(){
        try{
            this.contractService = new ContractService();
            super.initialize();
            setupTableColumns();
            loadContracts();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void setupTableColumns(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        paymenIdColumn.setCellValueFactory(new PropertyValueFactory<>("idPayment"));
        reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("idReservation"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private void loadContracts(){
        try{
            List<Contract> contracts = contractService.checkRole();

            ObservableList<Contract> data = FXCollections.observableArrayList(contracts);
            contractsTable.setItems(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
