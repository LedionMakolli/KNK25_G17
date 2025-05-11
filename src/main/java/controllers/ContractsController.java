package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Contract;
import repository.ContractRepository;
import services.SessionManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ContractsController {
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

    private ContractRepository contractRepository;

    @FXML
    private void initialize(){
        try{
            this.contractRepository = new ContractRepository();
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
            List<Contract> contracts;

            String role = SessionManager.getInstance().getCurrentRole();

            if ("client".equals(role)){
                int clientId = SessionManager.getInstance().getCurrentClient().getId();
                contracts = contractRepository.getByClientId(clientId);
            }else{
                contracts = contractRepository.getAll();
            }

            ObservableList<Contract> data = FXCollections.observableArrayList(contracts);
            contractsTable.setItems(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
