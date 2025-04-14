package models;

import models.enums.PagesaEnum;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Payments {
    private int id;
    private int idReservation;
    private PagesaEnum type;
    private Integer promoCodeId; // Integer for handling NULL values
    private BigDecimal totalNoDiscount; // Total before discount
    private BigDecimal totalFinal; // Total after applying discounts
    private LocalDateTime date;


    public Payments(int id, int idReservation, PagesaEnum type, Integer promoCodeId,
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
        Integer idReservation = resultSet.getInt("idrservation");
        String typeStr = resultSet.getString("type");
        PagesaEnum type = PagesaEnum.valueOf(typeStr.toUpperCase());
        Integer promoCodeId = resultSet.getObject("promocodeid", Integer.class);
        BigDecimal totalNoDiscount = resultSet.getBigDecimal("totalNoDiscount");
        BigDecimal totalFinal = resultSet.getBigDecimal("totalFinal");
        LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();

        return new Payments(id, idReservation, type, promoCodeId, totalNoDiscount, totalFinal, date);
    }

    // Getters
    public int getId() {
        return id;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public PagesaEnum getType() {
        return type;
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

    public LocalDateTime getDate() {
        return date;
    }

    // Method to print details
    public void printPaymentDetails() {
        System.out.println("----------------------------------------");
        System.out.println("ID: " + getId());
        System.out.println("ID Reservation: " + getIdReservation());
        System.out.println("Type: " + getType());
        System.out.println("Promo Code ID: " + (getPromoCodeId() != null ? getPromoCodeId() : "N/A"));
        System.out.println("Total without discount: " + getTotalNoDiscount() + " €");
        System.out.println("Total final: " + getTotalFinal() + " €");
        System.out.println("Date: " + getDate());
        System.out.println("----------------------------------------");
    }
}

