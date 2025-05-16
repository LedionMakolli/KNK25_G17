package services;

import models.Dto.UpdatePenaltyDto;
import models.Dto.UpdateSpecialRequestsDto;
import models.SpecialRequests;
import repository.PenaltiesRepository;
import repository.SpecialRequestsRepository;

public class UpdateTablesService {

    private final PenaltiesRepository penaltiesRepository;
    private final SpecialRequestsRepository specialRequestsRepository;

    public UpdateTablesService() throws Exception {
        this.penaltiesRepository = new PenaltiesRepository();
        this.specialRequestsRepository = new SpecialRequestsRepository();
    }

    public boolean updatePenalties(int id, boolean isApproved) throws Exception {
        UpdatePenaltyDto dto = new UpdatePenaltyDto(id, isApproved);
        return penaltiesRepository.updatePaguar(dto) != null;
    }

    public boolean updateSpecialRequests(int id, boolean isApproved) throws Exception {
        SpecialRequests specialRequest = specialRequestsRepository.getById(id);
        if (specialRequest == null) {
            return false;
        }

        UpdateSpecialRequestsDto dto = new UpdateSpecialRequestsDto(
                specialRequest.getId(),
                specialRequest.getIdReservation(),
                specialRequest.getRequest(),
                isApproved
        );
        return specialRequestsRepository.update(dto) != null;
    }
}
