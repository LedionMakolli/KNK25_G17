package models.Dto;

import models.enums.Kompania;

import java.util.Date;

public class CreateSigurimiDto {
    private int id_vetura;
    private Kompania kompania;
    private Date data_fillimit;
    private Date data_mbarimit;
    private double kosto;


    private CreateSigurimiDto(int id_sigurimi, int id_vetura, Kompania kompania, Date data_fillimit, Date data_mbarimit, double kosto) {
        this.id_vetura=id_vetura;
        this.kompania = kompania;
        this.data_fillimit = data_fillimit;
        this.data_mbarimit = data_mbarimit;
        this.kosto = kosto;
    }

    public int getId_vetura() {
        return id_vetura;
    }
    public Kompania getKompania() {
        return kompania;
    }

    public Date getDataFillimit() {
        return data_fillimit;
    }

    public Date getDataMbarimit() {
        return data_mbarimit;
    }

    public double getKosto() {
        return kosto;
    }


public void setKompania(Kompania kompania){
    this.kompania=kompania;
}
    public void setId_vetura(int id_vetura){
        this.id_vetura=id_vetura;
    }
    public void setData_fillimit(Date data_fillimit){
        this.data_fillimit=data_fillimit;
    }

    public void setData_mbarimit(Date data_mbarimit){
        this.data_mbarimit=data_mbarimit;
    }

    public void setKosto(double kosto){
        this.kosto=kosto;
    }
}



