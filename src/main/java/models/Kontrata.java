package models;

import models.enums.Pagesa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Kontrata {
    private int id_kontrata;
    private int id_rezervimet;
    private double shuma;
    private Pagesa pagesa;
    private String data;

    private Kontrata(int id_kontrata, int id_rezervimet, double shuma, Pagesa pagesa, String data) {
        this.id_kontrata = id_kontrata;
        this.id_rezervimet = id_rezervimet;
        this.shuma = shuma;
        this.pagesa = pagesa;
        this.data = data;
    }

    public static Kontrata getInstance(ResultSet resultSet) throws SQLException {
        int id_kontrata = resultSet.getInt("id_kontrata");
        int id_rezervimet = resultSet.getInt("id_rezervimet");
        double shuma = resultSet.getDouble("shuma");
        String pagesaStr = resultSet.getString("pagesa");
        Pagesa pagesa = Pagesa.valueOf(pagesaStr.toUpperCase());
        String data = resultSet.getString("data");
        return new Kontrata(id_kontrata, id_rezervimet, shuma, pagesa, data);
    }

    public int getIdkontrata() {
        return id_kontrata;
    }

    public int getIdrezervimet() {
        return id_rezervimet;
    }

    public double getShuma() {
        return shuma;
    }

    public Pagesa getPagesa() {
        return pagesa;
    }

    public String getData() {return data;}

    public void printoTeDhenatPerKontraten(){
        System.out.println("----------------------------------------");
        System.out.println("Detajet e Kontrates");
        System.out.println("ID: " + getIdkontrata());
        System.out.println("ID rezervimi: " + getIdrezervimet());
        System.out.println("Shuma: " + getShuma() + "€");
        System.out.println("Pagesa: " + getPagesa());
        System.out.println("Data: " + getData());
        System.out.println("----------------------------------------");
    }
}
