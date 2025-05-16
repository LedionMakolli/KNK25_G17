package services;

import repository.MaintenanceRepository;

import java.sql.SQLException;

public class MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    
    public MaintenanceService() throws SQLException {
        this.maintenanceRepository = new MaintenanceRepository();
    }


    /////////////////////////////////////



}
