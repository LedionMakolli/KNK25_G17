package models.Dto;

import models.enums.StatusiMirembatjaEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class UpdateMirembajtjaDto {
    private int id;
    private int idVetura;
    private String pershkrimi;
    private Date dataFillimit;
    private Date dataMbarimit;
    private BigDecimal kosto;
    private StatusiMirembatjaEnum statusi;
    private Integer idStafi;


    public UpdateMirembajtjaDto(int id, String pershkrimi, Date dataFillimit, Date dataMbarimit, BigDecimal kosto, StatusiMirembatjaEnum statusi, Integer idStafi) {
        this.id = id;
        this.pershkrimi = pershkrimi;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
        this.kosto = kosto;
        this.statusi = statusi;
        this.idStafi = idStafi;
    }

    public int getId() {
        return id;
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

    public void setStatusi(StatusiMirembatjaEnum statusi) {
        this.statusi = statusi;
    }

    public void setIdStafi(Integer idStafi) {
        this.idStafi = idStafi;
    }

    public void setKosto(BigDecimal kosto) {
        this.kosto = kosto;
    }
}
