package models.Dto;

import models.enums.PaymentEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UpdatePaymentsDto {
    private final int id;
    private String type;
    private LocalDateTime date;
    private int promoCodeId;
    private BigDecimal totalNoDiscount;
    private BigDecimal totalFinal;

    public UpdatePaymentsDto(int id, String type, LocalDateTime date,
                             int promoCodeId, BigDecimal totalNoDiscount,
                             BigDecimal totalFinal) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.promoCodeId = promoCodeId;
        this.totalNoDiscount = totalNoDiscount;
        this.totalFinal = totalFinal;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getPromoCodeId() {
        return promoCodeId;
    }

    public BigDecimal getTotalNoDiscount() {
        return totalNoDiscount;
    }

    public BigDecimal getTotalFinal() {
        return totalFinal;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPromoCodeId(int promoCodeId) {
        this.promoCodeId = promoCodeId;
    }

    public void setTotalNoDiscount(BigDecimal totalNoDiscount) {
        this.totalNoDiscount = totalNoDiscount;
    }

    public void setTotalFinal(BigDecimal totalFinal) {
        this.totalFinal = totalFinal;
    }
}