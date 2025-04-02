package models.Dto;

import java.util.Date;

public class UpdateSigurimiDto {
int id_sigurimi;
Date data_fillimit;
Date data_mbarimit;
double kosto;


    private UpdateSigurimiDto( int id_sigurimi, Date data_fillimit, Date data_mbarimit, double kosto) {

        this.id_sigurimi=id_sigurimi;
        this.data_fillimit = data_fillimit;
        this.data_mbarimit = data_mbarimit;
        this.kosto = kosto;
    }

    public int getIDSigurimi() {
        return id_sigurimi;
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

    public void setID_sigurimi(int id_sigurimi){
        this.id_sigurimi=id_sigurimi;
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
