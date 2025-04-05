package models.Dto;

import models.enums.StatusiRezervimetEnum;

import java.sql.Date;

public class CreateRezervimetDto {
    private int idKlienti;
    private int idVetura;
    private Date dataFillimit;
    private Date dataMbarimit;
    private StatusiRezervimetEnum statusiRezervimet;

    public CreateRezervimetDto(int idKlienti, int idVetura, Date dataFillimit, Date dataMbarimit, StatusiRezervimetEnum statusiRezervimet){
        this.idKlienti=idKlienti;
        this.idVetura=idVetura;
        this.dataFillimit=dataFillimit;
        this.dataMbarimit=dataMbarimit;
        this.statusiRezervimet=statusiRezervimet;
    }

    public int getIdKlienti(){
        return idKlienti;
    }

    public void setIdKlienti(int idKlienti){
        this.idKlienti=idKlienti;
    }

    public int getIdVetura(){
        return idVetura;
    }

    public void setIdVetura(int idVetura){
      this.idVetura=idVetura;
    }

    public Date getDataFillimit(){
        return dataFillimit;
    }

    public void setDataFillimit(Date dataFillimit){
        this.dataFillimit=dataFillimit;
    }

    public Date getDataMbarimit(){
        return dataMbarimit;
    }

    public void setDataMbarimit(Date dataMbarimit){
        this.dataMbarimit=dataMbarimit;
    }

    public StatusiRezervimetEnum getStatusiRezervimet(){
        return statusiRezervimet;
    }

    public void setStatusiRezervimet(StatusiRezervimetEnum statusiRezervimet){
        this.statusiRezervimet= this.statusiRezervimet;
    }

}
