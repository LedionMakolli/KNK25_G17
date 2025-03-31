package models.Dto;

import models.enums.Pagesa;

public class CreateKontrataDto {
    private int id_kontrata;
    private int id_rezervimet;
    private double shuma;
    private Pagesa pagesa;

    public CreateKontrataDto(int id_kontrata, int id_rezervimet, double shuma, Pagesa pagesa){
        this.id_kontrata = id_kontrata;
        this.id_rezervimet = id_rezervimet;
        this.shuma = shuma;
        this.pagesa = pagesa;
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

    public Pagesa getPagesa() {
        return pagesa;
    }
}
