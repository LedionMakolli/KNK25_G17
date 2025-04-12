package models.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreatePenaltyDto {
    private int idRezervimet;
    private String arsyeja;
    private BigDecimal shuma;
    private LocalDateTime data;
    private boolean paguar;

    public CreatePenaltyDto(int idRezervimet, String arsyeja, BigDecimal shuma, boolean paguar) {
        if (arsyeja == null || arsyeja.trim().isEmpty()) {
            throw new IllegalArgumentException("Arsyeja nuk mund te jete e zbrazet.");
        }
        if (shuma == null || shuma.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Shuma duhet te jete pozitive.");
        }
        this.idRezervimet = idRezervimet;
        this.arsyeja = arsyeja;
        this.shuma = shuma;
        this.data = LocalDateTime.now();
        this.paguar = paguar;
    }

    public void setIdRezervimet(int idRezervimet) {
        this.idRezervimet = idRezervimet;
    }

    public void setArsyeja(String arsyeja) {
        this.arsyeja = arsyeja;
    }

    public void setShuma(BigDecimal shuma) {
        this.shuma = shuma;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setPaguar(boolean paguar) {
        this.paguar = paguar;
    }

    public int getIdRezervimet() {
        return idRezervimet;
    }

    public String getArsyeja() {
        return arsyeja;
    }

    public BigDecimal getShuma() {
        return shuma;
    }

    public LocalDateTime getData() {
        return data;
    }

    public boolean isPaguar() {
        return paguar;
    }
}
