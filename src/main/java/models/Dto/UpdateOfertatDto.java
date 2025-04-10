package models.Dto;

import java.util.Date;

public class UpdateOfertatDto {
    private int id;
    private Integer idVetura;
    private Double zbritja;
    private Date dataFillimit;
    private Date dataMbarimit;

    public UpdateOfertatDto(int id, int idVetura, double zbritja, Date dataFillimit, Date dataMbarimit) {
        this.id = id;
        this.idVetura = idVetura;
        this.zbritja = zbritja;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
    }

    public void setIdVetura(int idVetura) {
        this.idVetura = idVetura;
    }

    public void setZbritja(double zbritja) {
        this.zbritja = zbritja;
    }

    public void setDataFillimit(Date dataFillimit) {
        this.dataFillimit = dataFillimit;
    }

    public void setDataMbarimit(Date dataMbarimit) {
        this.dataMbarimit = dataMbarimit;
    }

    public int getId() {
        return id;
    }

    public Integer getIdVetura() {
        return idVetura;
    }

    public Double getZbritja() {
        return zbritja;
    }

    public Date getDataFillimit() {
        return dataFillimit;
    }

    public Date getDataMbarimit() {
        return dataMbarimit;
    }
}
