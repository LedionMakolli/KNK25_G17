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
    private PromoCode promoCode;
    private BigDecimal totalNoDiscount;
    private BigDecimal totalFinal;
    private LocalDateTime date;

    public Payments(int id, int idReservation, PaymentEnum type, PromoCode promoCode,
                    BigDecimal totalNoDiscount, BigDecimal totalFinal, LocalDateTime date) {
        this.id = id;
        this.idReservation = idReservation;
        this.type = type;
        this.promoCode = promoCode;
        this.totalNoDiscount = totalNoDiscount;
        this.totalFinal = totalFinal;
        this.date = date;
    }

    public static Payments getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idReservation = resultSet.getInt("idreservation");
        String typeStr = resultSet.getString("type");
        PaymentEnum type = PaymentEnum.valueOf(typeStr.toUpperCase());

        PromoCode promoCode = null;
        Integer promoCodeId = resultSet.getObject("promocodeid", Integer.class);
        if (promoCodeId != null) {
            try {
                PromoCodeRepository promoCodeRepository = new PromoCodeRepository();
                promoCode = promoCodeRepository.getById(promoCodeId);
            } catch (SQLException e) {
                e.printStackTrace();
                // Mund të vendosni një trajtim të gabimit më të mirë këtu
            }
        }

        BigDecimal totalNoDiscount = resultSet.getBigDecimal("totalnodiscount");
        BigDecimal totalFinal = resultSet.getBigDecimal("totaldinal");
        LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();

        return new Payments(id, idReservation, type, promoCode, totalNoDiscount, totalFinal, date);
    }

    public int getId() {
        return id;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public PaymentEnum getType() {
        return type;
    }

    public PromoCode getPromoCode() {
        return promoCode;
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
        System.out.println("Promo Code: " + (getPromoCode() != null ? getPromoCode().getCode() : "N/A"));
        System.out.println("Total without discount: " + getTotalNoDiscount() + " €");
        System.out.println("Total final: " + getTotalFinal() + " €");
        System.out.println("Date: " + getDate());
        System.out.println("----------------------------------------");
    }
}