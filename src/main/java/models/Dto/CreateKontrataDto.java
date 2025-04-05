package models.Dto;

import models.enums.PagesaEnum;

import java.sql.Date;

public class CreateKontrataDto {
    private int id_kontrata;
    private int id_rezervimet;
    private double shuma;
    private PagesaEnum pagesa;
    private Date data;

    public CreateKontrataDto(int id_kontrata, int id_rezervimet, double shuma, PagesaEnum pagesa, Date data) {
        this.id_kontrata = id_kontrata;
        this.id_rezervimet = id_rezervimet;
        this.shuma = shuma;
        this.pagesa = pagesa;
        this.data = data;
    }

    public int getId_kontrata() {
        return id_kontrata;
    }

    public int getId_rezervimet() {
        return id_rezervimet;
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
