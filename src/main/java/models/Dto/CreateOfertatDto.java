package models.Dto;

import java.util.Date;

public class CreateOfertatDto {
    private int idVetura;
    private double zbritja;
    private Date dataFillimit;
    private Date dataMbarimit;

    public CreateOfertatDto(int idVetura, double zbritja, Date dataFillimit, Date dataMbarimit) {
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

    public int getIdVetura() {
        return idVetura;
    }

    public double getZbritja() {
        return zbritja;
    }

    public java.sql.Date getDataFillimit() {
        return dataFillimit;
    }

    public java.sql.Date getDataMbarimit() {
        return dataMbarimit;
    }
}
