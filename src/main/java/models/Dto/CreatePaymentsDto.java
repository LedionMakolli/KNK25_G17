package models.Dto;

import models.enums.PaymentEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreatePaymentsDto {
    private Integer idReservation;
    private String type;
    private LocalDateTime date;
    private Integer promoCodeId;
    private BigDecimal totalNoDiscount;
    private BigDecimal totalFinal;

    // Constructor without id parameter
    public CreatePaymentsDto(Integer idReservation, String type, Integer promoCodeId,
                             BigDecimal totalNoDiscount, BigDecimal totalFinal, LocalDateTime date) {
        this.idReservation = idReservation;
        this.type = type;
        this.promoCodeId = promoCodeId;
        this.totalNoDiscount = totalNoDiscount;
        this.totalFinal = totalFinal;
        this.date = date;
    }

    // Getters and Setters (removed getId() and setId() since we don't need them)
    public Integer getIdReservation() {
        return idReservation;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getPromoCodeId() {
        return promoCodeId;
    }

    public BigDecimal getTotalNoDiscount() {
        return totalNoDiscount;
    }

    public BigDecimal getTotalFinal() {
        return totalFinal;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPromoCodeId(Integer promoCodeId) {
        this.promoCodeId = promoCodeId;
    }

    public void setTotalNoDiscount(BigDecimal totalNoDiscount) {
        this.totalNoDiscount = totalNoDiscount;
    }

    public void setTotalFinal(BigDecimal totalFinal) {
        this.totalFinal = totalFinal;
    }
}