package models.Dto;

import models.enums.PaymentEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UpdatePaymentsDto {
    private int id;
    private Integer idReservation;
    private PaymentEnum type;
    private LocalDateTime date;
    private Integer promoCodeId;
    private BigDecimal totalNoDiscount;
    private BigDecimal totalFinal;

    // Constructor
    public UpdatePaymentsDto(int id, int idReservation, PaymentEnum type, Integer promoCodeId,
                             BigDecimal totalNoDiscount, BigDecimal totalFinal, LocalDateTime date) {
        this.id = id;
        this.idReservation = idReservation;
        this.type = type;
        this.promoCodeId = promoCodeId;
        this.totalNoDiscount = totalNoDiscount;
        this.totalFinal = totalFinal;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public PaymentEnum getType() {
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

    // Setters




    public void setType(PaymentEnum type) {
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

