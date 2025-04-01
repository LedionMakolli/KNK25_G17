package models.Dto;

import java.util.Date;

public class CreateSigurimiDto {
    private String kompania;
    private Date data_fillimit;
    private Date data_mbarimit;
    private double kosto;


    private CreateSigurimiDto(int id_sigurimi, int id_vetura, String kompania, Date data_fillimit, Date data_mbarimit, double kosto) {

        this.kompania = kompania;
        this.data_fillimit = data_fillimit;
        this.data_mbarimit = data_mbarimit;
        this.kosto = kosto;
    }


    public String getKompania() {
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


public void setKompania(String kompania){
    this.kompania=kompania;
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



