package services;

import models.Dto.CreatePenaltyDto;
import models.Penalties;
import repository.PenaltiesRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PenaltyService {
    private final PenaltiesRepository repository;

    public PenaltyService() throws SQLException {
        this.repository = new PenaltiesRepository();
    }

    public Penalties addPenalty(CreatePenaltyDto dto) throws IllegalArgumentException {
        validate(dto);
        return repository.create(dto);
    }

    private void validate(CreatePenaltyDto dto) {
        if (dto.getReservationId() <= 0) {
            throw new IllegalArgumentException("Reservation ID must be greater than 0.");
        }
        if (dto.getReasonOfPenalty() == null || dto.getReasonOfPenalty().trim().isEmpty()) {
            throw new IllegalArgumentException("Reason of penalty cannot be empty.");
        }
        if (dto.getMoneyAmount() == null || dto.getMoneyAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Money amount must be greater than 0.");
        }
        if (dto.getDate() == null || dto.getDate().isAfter(LocalDateTime.now().plusDays(1))) {
            throw new IllegalArgumentException("Date must be a valid past or present date.");
        }
    }
}
