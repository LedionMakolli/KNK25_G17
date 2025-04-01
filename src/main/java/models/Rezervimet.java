package models;

import models.enums.Statusi_Rezervimet;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rezervimet {
    private int id_rezervimet;
    private int id_klienti;
    private int id_vetura;
    private Date data_fillimit;   //LocalDate
    private Date data_mbarimit;
    private Statusi_Rezervimet statusi_rezervimet;


private Rezervimet(int id_rezervimet, int id_klienti, int id_vetura, Date data_fillimit, Date data_mbarimit, Statusi_Rezervimet statusi_rezervimet){
    this.id_rezervimet=id_rezervimet;
    this.id_klienti=id_klienti;
    this.id_vetura=id_vetura;
    this.data_fillimit=data_fillimit;
    this.data_mbarimit=data_mbarimit;
    this.statusi_rezervimet=statusi_rezervimet;
}
public static Rezervimet getInstance(ResultSet resultSet) throws SQLException {
int id_rezervimet=resultSet.getInt("id_rezervimet");
int id_klienti=resultSet.getInt("id_klienti");
int id_vetura=resultSet.getInt("id_vetura");
Date data_fillimit=resultSet.getDate("data_fillimit");
Date data_mbarimit =resultSet.getDate("data_mbarimit");
String statusiString=resultSet.getString("statusi_rezervimet");

Statusi_Rezervimet statusi_rezervimet= Statusi_Rezervimet.valueOf(statusiString);



return new Rezervimet(id_rezervimet, id_klienti, id_vetura, data_fillimit, data_mbarimit, statusi_rezervimet);
}
public int getId_rezervimet(){return id_rezervimet;}

public int getId_klienti(){return id_klienti;}

public int getId_vetura(){return id_vetura;}

public Date getData_fillimit(){return data_fillimit;}

public Date getData_mbarimit(){return data_mbarimit;}

public Statusi_Rezervimet getStatusi(){return statusi_rezervimet;}

}
