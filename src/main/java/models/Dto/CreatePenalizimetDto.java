package models.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreatePenalizimetDto {
    private int idRezervimet;
    private String arsyeja;
    private BigDecimal shuma;
    private LocalDateTime data;
    private boolean paguar;

    public CreatePenalizimetDto(int idRezervimet, String arsyeja, BigDecimal shuma, LocalDateTime data, boolean paguar) {
        this.idRezervimet = idRezervimet;
        this.arsyeja = arsyeja;
        this.shuma = shuma;
        this.data = data;
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
