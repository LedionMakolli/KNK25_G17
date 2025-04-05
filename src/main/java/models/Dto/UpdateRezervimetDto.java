package models.Dto;

import models.enums.StatusiRezervimetEnum;

import java.sql.Date;

public class UpdateRezervimetDto {
    private int id;
    private int idVetura;
    private Date dataFillimit;
    private Date dataMbarimit;
    private StatusiRezervimetEnum statusiRezervimet;

    public UpdateRezervimetDto(int idVetura, Date dataFillimit, Date dataMbarimit, StatusiRezervimetEnum statusiRezervimet){
        this.idVetura = idVetura;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit= dataMbarimit;
        this.statusiRezervimet  = statusiRezervimet;
    }
 public UpdateRezervimetDto(){}


    public int getIdRezervimet() {
        return id;
    }

    public int getIdVetura(){
        return idVetura;
    }
    public Date getDataFillimit(){
        return dataFillimit;
    }
    public Date getDataMbarimit(){
        return dataMbarimit;
    }
    public void setDataFillimit(Date dataFillimit){
        this.dataFillimit = dataFillimit;
    }
    public void setDataMbarimit(Date data_mbarimit){
        this.dataMbarimit=dataMbarimit;
    }

    public StatusiRezervimetEnum getStatusiRezervimet(){
        return statusiRezervimet;
    }
}
