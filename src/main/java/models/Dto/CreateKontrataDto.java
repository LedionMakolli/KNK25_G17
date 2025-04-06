package models.Dto;

import models.enums.PagesaEnum;

import java.sql.Date;

public class CreateKontrataDto {
    private int id;
    private int idRezervimet;
    private double shuma;
    private PagesaEnum pagesa;
    private Date data;

    public CreateKontrataDto(int id, int id_rezervimet, double shuma, PagesaEnum pagesa, Date data) {
        this.id = id;
        this.idRezervimet = id_rezervimet;
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
