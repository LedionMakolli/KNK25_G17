package services;

import models.Dto.UpdateMaintenanceDto;
import models.enums.StatusMaintenanceEnum;
import repository.MaintenanceRepository;

public class UpdateMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public UpdateMaintenanceService() throws Exception {
        this.maintenanceRepository = new MaintenanceRepository();
    }

    public boolean updateMaintenanceStatus(int id, String status) throws Exception {
        StatusMaintenanceEnum statusEnum = StatusMaintenanceEnum.valueOf(status);
        UpdateMaintenanceDto dto = new UpdateMaintenanceDto(id, null, null, null, null, statusEnum);
        return maintenanceRepository.update(dto) != null;
    }
}