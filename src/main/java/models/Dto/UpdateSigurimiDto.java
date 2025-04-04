package models.Dto;

import java.util.Date;

public class UpdateSigurimiDto {
int idSigurimi;
Date dataFillimit;
Date dataMbarimit;
double kosto;


    private UpdateSigurimiDto(int idSigurimi, Date dataFillimit, Date dataMbarimit, double kosto) {

        this.idSigurimi = idSigurimi;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
        this.kosto = kosto;
    }

    public int getIDSigurimi() {
        return idSigurimi;
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

    public void setIDigurimi(int idSigurimi){
        this.idSigurimi =idSigurimi;
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
