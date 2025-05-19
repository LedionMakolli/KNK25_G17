package services;

import javafx.scene.control.Alert;
import models.Cars;
import models.Dto.CreateMaintenanceDto;
import models.Maintenance;
import models.Reservations;
import models.Staff;
import models.enums.StaffPositionEnum;
import models.enums.StatusMaintenanceEnum;
import repository.MaintenanceRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
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



public List<Maintenance> getMaintenanceByRole() throws SQLException{
        List<Maintenance> maintenances;
        String role = SessionManager.getInstance().getCurrentRole();

        if(SessionManager.getInstance().getCurrentStaff().getPosition().equals(StaffPositionEnum.STAFF)){
            int staffId = SessionManager.getInstance().getCurrentStaff().getId();
            maintenances = maintenanceRepository.getStaffById(staffId);
        } else{
            maintenances = maintenanceRepository.getAll();
        }
        return maintenances;
}

}
