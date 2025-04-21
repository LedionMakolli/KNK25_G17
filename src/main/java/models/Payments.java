package models;

import models.enums.PaymentEnum;
import repository.PromoCodeRepository;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Payments {
    private int id;
    private int idReservation;
    private PaymentEnum type;
    private int promoCodeId;
    private BigDecimal totalNoDiscount;
    private BigDecimal totalFinal;
    private LocalDateTime date;

    public Payments(int id, int idReservation, PaymentEnum type, int promoCodeId,
                    BigDecimal totalNoDiscount, BigDecimal totalFinal, LocalDateTime date) {
        this.id = id;
        this.idReservation = idReservation;
        this.type = type;
        this.promoCodeId = promoCodeId;
        this.totalNoDiscount = totalNoDiscount;
        this.totalFinal = totalFinal;
        this.date = date;
    }

    public static Payments getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idReservation = resultSet.getInt("idreservation");
        String typeStr = resultSet.getString("type");
        PaymentEnum type = PaymentEnum.valueOf(typeStr.toUpperCase());
        int promoCodeId = 0;
        Integer promoCodeIdNullable = resultSet.getObject("promocodeid", Integer.class);
        if (promoCodeIdNullable != null) {
            promoCodeId = promoCodeIdNullable;
        }
        BigDecimal totalNoDiscount = resultSet.getBigDecimal("totalnodiscount");
        BigDecimal totalFinal = resultSet.getBigDecimal("totalfinal");
        LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();

        return new Payments(id, idReservation, type, promoCodeId, totalNoDiscount, totalFinal, date);
    }

    public int getId() {
        return id;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public PaymentEnum getType() {
        return type;
    }

    public int getPromoCodeId() {  // Changed from getPromoCode()
        return promoCodeId;
    }

    public BigDecimal getTotalNoDiscount() {
        return totalNoDiscount;
    }

    public BigDecimal getTotalFinal() {
        return totalFinal;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void printPaymentDetails() {
        System.out.println("----------------------------------------");
        System.out.println("ID: " + getId());
        System.out.println("ID Reservation: " + getIdReservation());
        System.out.println("Type: " + getType());
        System.out.println("Promo Code ID: " + getPromoCodeId());
        System.out.println("Total without discount: " + getTotalNoDiscount() + " €");
        System.out.println("Total final: " + getTotalFinal() + " €");
        System.out.println("Date: " + getDate());
        System.out.println("----------------------------------------");
    }
}