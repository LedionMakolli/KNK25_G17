package models.Dto;

import models.enums.StatusiMirembatjaEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class CreateMirembajtjaDto {
    private int idMirembajtja;
    private int idVetura;
    private String pershkrimi;
    private Date dataFillimit;
    private Date dataMbarimit;
    private BigDecimal kosto;
    private StatusiMirembatjaEnum statusi;
    private Integer idStafi;

    public CreateMirembajtjaDto(int idMirembajtja, int idVetura, Date dataFillimit, String pershkrimi, Date dataMbarimit, BigDecimal kosto, StatusiMirembatjaEnum statusi, Integer idStafi) {
        this.idMirembajtja = idMirembajtja;
        this.idVetura = idVetura;
        this.dataFillimit = dataFillimit;
        this.pershkrimi = pershkrimi;
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
