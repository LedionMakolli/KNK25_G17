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
        if (dto.getDate() == null || dto.getDate().isBefore(LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0))) {
            throw new IllegalArgumentException("Data duhet të jetë sot ose në të ardhmen.");
        }
    }
}
