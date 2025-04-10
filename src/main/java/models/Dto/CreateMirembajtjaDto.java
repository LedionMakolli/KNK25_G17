package models.Dto;

import models.enums.StatusiMirembatjaEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class CreateMirembajtjaDto {
    private int idVetura;
    private String pershkrimi;
    private Date dataFillimit;
    private Date dataMbarimit;
    private BigDecimal kosto;
    private StatusiMirembatjaEnum statusi;
    private Integer idStafi;

    public CreateMirembajtjaDto( int idVetura, Date dataFillimit, String pershkrimi, Date dataMbarimit, BigDecimal kosto, StatusiMirembatjaEnum statusi, Integer idStafi) {
        this.idVetura = idVetura;
        this.dataFillimit = dataFillimit;
        this.pershkrimi = pershkrimi;
        this.dataMbarimit = dataMbarimit;
        this.kosto = kosto;
        this.statusi = statusi;
        this.idStafi = idStafi;
    }

    public int getIdVetura() {
        return idVetura;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public Date getDataFillimit() {
        return dataFillimit;
    }

    public Date getDataMbarimit() {
        return dataMbarimit;
    }

    public BigDecimal getKosto() {
        return kosto;
    }

    public StatusiMirembatjaEnum getStatusi() {
        return statusi;
    }

    public Integer getIdStafi() {
        return idStafi;
    }

    public void setIdVetura(int idVetura) {
        this.idVetura = idVetura;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    public void setDataFillimit(Date dataFillimit) {
        this.dataFillimit = dataFillimit;
    }

    public void setDataMbarimit(Date dataMbarimit) {
        this.dataMbarimit = dataMbarimit;
    }

    public void setKosto(BigDecimal kosto) {
        this.kosto = kosto;
    }

    public void setStatusi(StatusiMirembatjaEnum statusi) {
        this.statusi = statusi;
    }

    public void setIdStafi(Integer idStafi) {
        this.idStafi = idStafi;
    }
}
