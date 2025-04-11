package models.Dto;

import models.enums.PagesaEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UpdatePagesatDto {
    private int id;
    private Integer idRezervimi;
    private PagesaEnum lloji;
    private LocalDateTime data;
    private Integer promoCodeId;
    private BigDecimal totaliPaZbritje;
    private BigDecimal totaliFinal;

    // Constructor
    public UpdatePagesatDto(int id, int idRezervimi, PagesaEnum lloji, Integer promoCodeId,
                            BigDecimal totaliPaZbritje, BigDecimal totaliFinal, LocalDateTime data) {
        this.id = id;
        this.idRezervimi = idRezervimi;
        this.lloji = lloji;
        this.promoCodeId = promoCodeId;
        this.totaliPaZbritje = totaliPaZbritje;
        this.totaliFinal = totaliFinal;
        this.data = data;
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

    public LocalDateTime getData() {
        return data;
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

    // Setters




    public void setLloji(PagesaEnum lloji) {
        this.lloji = lloji;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setPromoCodeId(Integer promoCodeId) {
        this.promoCodeId = promoCodeId;
    }

    public void setTotaliPaZbritje(BigDecimal totaliPaZbritje) {
        this.totaliPaZbritje = totaliPaZbritje;
    }

    public void setTotaliFinal(BigDecimal totaliFinal) {
        this.totaliFinal = totaliFinal;
    }
}

