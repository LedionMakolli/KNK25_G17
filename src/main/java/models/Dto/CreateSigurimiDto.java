package models.Dto;

import models.enums.Kompania;

import java.util.Date;

public class CreateSigurimiDto {
    private int idVetura;
    private Kompania kompania;
    private Date dataFillimit;
    private Date dataMbarimit;
    private double kosto;


    private CreateSigurimiDto(int id_sigurimi, int idVetura, Kompania kompania, Date dataFillimit, Date dataMbarimit, double kosto) {
        this.idVetura = idVetura;
        this.kompania = kompania;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
        this.kosto = kosto;
    }

    public int getIdVetura() {
        return idVetura;
    }
    public Kompania getKompania() {
        return kompania;
    }

    public Date getDataFillimit() {
        return dataFillimit;
    }

    public Date getDataMbarimit() {
        return dataMbarimit;
    }

    public double getKosto() {
        return kosto;
    }


public void setKompania(Kompania kompania){
    this.kompania=kompania;
}
    public void setIdVetura(int idVetura){
        this.idVetura = idVetura;
    }
    public void setDataFillimit(Date dataFillimit){
        this.dataFillimit = dataFillimit;
    }

    public void setDataMbarimit(Date dataMbarimit){
        this.dataMbarimit = dataMbarimit;
    }

    public void setKosto(double kosto){
        this.kosto=kosto;
    }
}



