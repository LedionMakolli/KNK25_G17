package models;

import models.enums.PagesaEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Kontrata {
    private int id;
    private int idRezervimet;
    private double shuma;
    private PagesaEnum pagesa;
    private String data;

    private Kontrata(int id, int idRezervimet, double shuma, PagesaEnum pagesa, String data) {
        this.id = id;
        this.idRezervimet = idRezervimet;
        this.shuma = shuma;
        this.pagesa = pagesa;
        this.data = data;
    }

    public static Kontrata getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idRezervimet = resultSet.getInt("idRezervimet");
        double shuma = resultSet.getDouble("shuma");
        String pagesaStr = resultSet.getString("pagesa");
        PagesaEnum pagesa = PagesaEnum.valueOf(pagesaStr.toUpperCase());
        String data = resultSet.getString("data");
        return new Kontrata(id, idRezervimet, shuma, pagesa, data);
    }

    public int getId() {
        return id;
    }

    public int getIdrezervimet() {
        return idRezervimet;
    }

    public double getShuma() {
        return shuma;
    }

    public PagesaEnum getPagesa() {
        return pagesa;
    }

    public String getData() {return data;}

    public void printoTeDhenatPerKontraten(){
        System.out.println("----------------------------------------");
        System.out.println("Detajet e Kontrates");
        System.out.println("ID: " + getId());
        System.out.println("ID rezervimi: " + getIdrezervimet());
        System.out.println("Shuma: " + getShuma() + "€");
        System.out.println("Pagesa: " + getPagesa());
        System.out.println("Data: " + getData());
        System.out.println("----------------------------------------");
    }
}
