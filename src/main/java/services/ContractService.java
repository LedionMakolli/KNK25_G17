package services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Contract;
import repository.ContractRepository;

import java.sql.SQLException;
import java.util.List;

public class ContractService {
    ContractRepository contractRepository;

    public ContractService() throws SQLException {
        this.contractRepository = new ContractRepository();
    }

    public List<Contract> checkRole() throws SQLException {
        List<Contract> contracts;
        String role = SessionManager.getInstance().getCurrentRole();

        if ("client".equals(role)){
            int clientId = SessionManager.getInstance().getCurrentClient().getId();
            contracts = contractRepository.getByClientId(clientId);
        }else{
            contracts = contractRepository.getAll();
        }
        return contracts;
    }
}
