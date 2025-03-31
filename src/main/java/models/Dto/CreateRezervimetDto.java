package models.Dto;

import models.enums.Statusi_Rezervimet;

import java.sql.Date;

public class CreateRezervimetDto {
    private int id_klienti;
    private int id_vetura;
    private Date data_fillimit;
    private Date data_mbarimit;
    private Statusi_Rezervimet statusi;

    public CreateRezervimetDto(int id_klienti, int id_vetura, Date data_fillimit, Date data_mbarimit, Statusi_Rezervimet statusi){
        this.id_klienti=id_klienti;
        this.id_vetura=id_vetura;
        this.data_fillimit=data_fillimit;
        this.data_mbarimit=data_mbarimit;
        this.statusi=statusi;
    }

    public int getId_klienti(){
        return id_klienti;
    }

    public void setId_klienti(int id_klienti){
        this.id_klienti=id_klienti;
    }

    public int getId_vetura(){
        return id_vetura;
    }

    public void setId_vetura(int id_vetura){
      this.id_vetura=id_vetura;
    }

    public Date getData_fillimit(){
        return data_fillimit;
    }

    public void setData_fillimit(Date data_fillimit){
        this.data_fillimit=data_fillimit;
    }

    public Date getData_mbarimit(){
        return data_mbarimit;
    }

    public void setData_mbarimit(Date data_mbarimit){
        this.data_mbarimit=data_mbarimit;
    }

    public Statusi_Rezervimet getStatusi(){
        return statusi;
    }

    public void setStatusi(Statusi_Rezervimet statusi){
        this.statusi=statusi;
    }

}
