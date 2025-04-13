package models.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreatePenaltyDto {
    private int reservationId;
    private String reasonOfPenalty;
    private BigDecimal moneyAmount;
    private LocalDateTime date;
    private boolean paid;

    public CreatePenaltyDto(int reservationId, String reasonOfPenalty, BigDecimal moneyAmount, boolean paid) {
        this.reservationId = reservationId;
        this.reasonOfPenalty = reasonOfPenalty;
        this.moneyAmount = moneyAmount;
        this.date = LocalDateTime.now();
        this.paid = paid;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setReasonOfPenalty(String reasonOfPenalty) {
        this.reasonOfPenalty = reasonOfPenalty;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getReasonOfPenalty() {
        return reasonOfPenalty;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isPaid() {
        return paid;
    }
}
