package models;

import models.enums.StatusiRezervimetEnum;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rezervimet {
    private int id;
    private int idKlienti;
    private int idVetura;
    private Date dataFillimit;   //LocalDate
    private Date dataMbarimit;
    private StatusiRezervimetEnum statusiRezervimet; //mundemi me shtu vetine created_at per kohen e sakte kur eshte shtuar rreshti tek rezervimet


private Rezervimet(int id, int idKlienti, int idVetura, Date dataFillimit, Date dataMbarimit, StatusiRezervimetEnum statusiRezervimet){
    this.id=id;
    this.idKlienti=idKlienti;
    this.idVetura=idVetura;
    this.dataFillimit=dataFillimit;
    this.dataMbarimit=dataMbarimit;
    this.statusiRezervimet=statusiRezervimet;
}
public static Rezervimet getInstance(ResultSet resultSet) throws SQLException {
int id=resultSet.getInt("id");
int idKlienti=resultSet.getInt("idKlienti");
int idVetura=resultSet.getInt("idVetura");
Date dataFillimit=resultSet.getDate("dataFillimit");
Date dataMbarimit =resultSet.getDate("dataMbarimit");
String statusiString=resultSet.getString("statusiRezervimet");

StatusiRezervimetEnum statusiRezervimet= StatusiRezervimetEnum.valueOf(statusiString.toUpperCase());



return new Rezervimet(id, idKlienti, idVetura, dataFillimit, dataMbarimit, statusiRezervimet);
}
public int getId(){return id;}

public int getIdKlienti(){return idKlienti;}

public int getIdVetura(){return idVetura;}

public Date getDataFillimit(){return dataFillimit;}

public Date getDataMbarimit(){return dataMbarimit;}

public StatusiRezervimetEnum getStatusi(){return statusiRezervimet;}

    public void printoTeDhenatRezervimet(){
    System.out.println("ID_Rezervimet: " + getId());
    System.out.println("ID_Klienti: " + getIdKlienti());
    System.out.println("ID_Vetura: " + getIdVetura());
    System.out.println("Data_Fillimit: " + getDataFillimit());
    System.out.println("Data_Mbarimit: " + getDataMbarimit());
    System.out.println("Statusi: " + getStatusi());
    System.out.println("-------------------------------");
    }
}
