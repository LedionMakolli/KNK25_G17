package models.Dto;

import java.util.Date;

public class UpdateSigurimiDto {

Date data_fillimit;
Date data_mbarimit;
double kosto;


    private UpdateSigurimiDto(  Date data_fillimit, Date data_mbarimit, double kosto) {


        this.data_fillimit = data_fillimit;
        this.data_mbarimit = data_mbarimit;
        this.kosto = kosto;
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
