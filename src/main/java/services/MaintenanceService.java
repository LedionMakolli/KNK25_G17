package services;

import models.Cars;
import models.Dto.CreateMaintenanceDto;
import models.Maintenance;
import models.Reservations;
import models.Staff;
import models.enums.StatusMaintenanceEnum;
import repository.MaintenanceRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    
    public MaintenanceService() throws SQLException {
        this.maintenanceRepository = new MaintenanceRepository();
    }

    public void createMaintenance(
            Cars car,
            Date start,
            String description,
            Date finish,
            BigDecimal cost,
            StatusMaintenanceEnum status,
            Staff staff
    ) throws Exception {
        if (car == null || start == null || description == null || finish == null || cost == null || status == null || staff == null){
            throw new IllegalArgumentException("All fields must be filled");
        }

        if (start.after(finish)){
            throw new IllegalArgumentException("Start date must be before finish date.");
        }

        CreateMaintenanceDto dto = new CreateMaintenanceDto(
                car.getId(),
                start,
                description,
                finish,
                cost,
                status,
                staff.getId()
        );
        maintenanceRepository.create(dto);
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
