package models;

import models.enums.PagesaEnum;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Pagesat {
    private int id;
    private int idRezervimi;
    private PagesaEnum lloji;
    private Integer promoCodeId; // Integer for handling NULL values
    private BigDecimal totaliPaZbritje; // Total before discount
    private BigDecimal totaliFinal; // Total after applying discounts
    private LocalDateTime data;


    public Pagesat(int id, int idRezervimi, PagesaEnum lloji, Integer promoCodeId,
                   BigDecimal totaliPaZbritje, BigDecimal totaliFinal, LocalDateTime data) {
        this.id = id;
        this.idRezervimi = idRezervimi;
        this.lloji = lloji;
        this.promoCodeId = promoCodeId;
        this.totaliPaZbritje = totaliPaZbritje;
        this.totaliFinal = totaliFinal;
        this.data = data;
    }


    public static Pagesat getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        Integer idRezervimi = resultSet.getInt("idrezervimi");
        String llojiStr = resultSet.getString("lloji");
        PagesaEnum lloji = PagesaEnum.valueOf(llojiStr.toUpperCase());
        Integer promoCodeId = resultSet.getObject("promocodeid", Integer.class);
        BigDecimal totaliPaZbritje = resultSet.getBigDecimal("totaliPaZbritje");
        BigDecimal totaliFinal = resultSet.getBigDecimal("totaliFinal");
        LocalDateTime data = resultSet.getTimestamp("data").toLocalDateTime();

        return new Pagesat(id, idRezervimi, lloji, promoCodeId, totaliPaZbritje, totaliFinal, data);
    }

    // Getters
    public int getId() {
        return id;
    }

    public Integer getIdRezervimi() {
        return idRezervimi;
    }

    public PagesaEnum getLloji() {
        return lloji;
    }

    public Integer getPromoCodeId() {
        return promoCodeId;
    }

    public BigDecimal getTotaliPaZbritje() {
        return totaliPaZbritje;
    }

    public BigDecimal getTotaliFinal() {
        return totaliFinal;
    }

    public LocalDateTime getData() {
        return data;
    }

    // Method to print details
    public void printoTeDhenatPerPagesen() {
        System.out.println("----------------------------------------");
        System.out.println("ID: " + getId());
        System.out.println("ID e rezervimit: " + getIdRezervimi());
        System.out.println("Lloji: " + getLloji());
        System.out.println("Promo Code ID: " + (getPromoCodeId() != null ? getPromoCodeId() : "N/A"));
        System.out.println("Totali pa zbritje: " + getTotaliPaZbritje() + " €");
        System.out.println("Totali final: " + getTotaliFinal() + " €");
        System.out.println("Data: " + getData());
        System.out.println("----------------------------------------");
    }
}

