package services;

import models.Maintenance;
import models.Reservations;
import repository.MaintenanceRepository;

import java.sql.SQLException;
import java.util.List;

public class MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    
    public MaintenanceService() throws SQLException {
        this.maintenanceRepository = new MaintenanceRepository();
    }


    /////////////////////////////////////

public List<Maintenance> getMaintenanceByRole() throws SQLException{
        List<Maintenance> maintenances;
        String role = SessionManager.getInstance().getCurrentRole();

        if("staff".equals(role)){
            int staffId = SessionManager.getInstance().getCurrentStaff().getId();
            maintenances = maintenanceRepository.getStaffById(staffId);
        } else{
            maintenances = maintenanceRepository.getAll();
        }
        return maintenances;
}

}
