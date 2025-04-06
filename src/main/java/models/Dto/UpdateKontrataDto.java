package models.Dto;

import models.enums.PagesaEnum;

import java.sql.Date;

public class UpdateKontrataDto {
    private int id;
    private int idRezervimet;
    private double shuma;
    private PagesaEnum pagesa;
    private Date data;

    public UpdateKontrataDto(int id_kontrata, double shuma, PagesaEnum pagesa, Date data) {
        this.id = id;
        this.shuma = shuma;
        this.pagesa = pagesa;
        this.data = data;
    }

    public int getId_kontrata() {
        return id;
    }

    public int getId_rezervimet() {
        return idRezervimet;
    }

    public double getShuma() {
        return shuma;
    }

    public PagesaEnum getPagesa() {
        return pagesa;
    }

    public Date getData() {
        return data;
    }
}
