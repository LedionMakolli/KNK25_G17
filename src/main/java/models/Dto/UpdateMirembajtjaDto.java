package models.Dto;

import models.enums.StatusiMirembatjaEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class UpdateMirembajtjaDto {
    private int idMirembajtja;
    private int idVetura;
    private String pershkrimi;
    private Date dataFillimit;
    private Date dataMbarimit;
    private BigDecimal kosto;
    private StatusiMirembatjaEnum statusi;
    private Integer idStafi;


    public UpdateMirembajtjaDto(int idMirembajtja, String pershkrimi, Date dataFillimit, Date dataMbarimit, BigDecimal kosto, StatusiMirembatjaEnum statusi, Integer idStafi) {
        this.idMirembajtja = idMirembajtja;
        this.pershkrimi = pershkrimi;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
        this.kosto = kosto;
        this.statusi = statusi;
        this.idStafi = idStafi;
    }

    public int getIdMirembajtja() {
        return idMirembajtja;
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
}
