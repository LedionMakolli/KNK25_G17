package models.Dto;

import models.enums.Karburanti;
import models.enums.Statusi_Vetura;
import models.enums.Statusi_Vetura;

import java.math.BigDecimal;

public class UpdateVeturatDto {
    private int ID_Vetura;
    private String ngjyra;
    private BigDecimal kilometrazha;
    private int kapaciteti;
    private Karburanti karburanti;
    private int cmimi_ditor;
    private Statusi_Vetura statusi;

    public UpdateVeturatDto(int ID_Vetura, String ngjyra, BigDecimal kilometrazha,
                            Karburanti karburanti, int kapaciteti,
                            int cmimi_ditor, Statusi_Vetura statusi) {
        this.ID_Vetura = ID_Vetura;
        this.ngjyra = ngjyra;
        this.kilometrazha = kilometrazha;
        this.kapaciteti=kapaciteti;
        this.karburanti = karburanti;
        this.cmimi_ditor = cmimi_ditor;
        this.statusi = statusi;
    }
    public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    public void setKilometrazha(BigDecimal kilometrazha) {
        this.kilometrazha = kilometrazha;
    }

    public void setKapaciteti(int kapaciteti) {
        this.kapaciteti = kapaciteti;
    }

    public void setKarburanti(Karburanti karburanti) {
        this.karburanti = karburanti;
    }

    public void setCmimiditor(int cmimi_ditor) {
        this.cmimi_ditor = cmimi_ditor;
    }

    public void setStatusi(Statusi_Vetura statusi) {
        this.statusi = statusi;
    }

    public int getIDVetura() {
        return ID_Vetura;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public BigDecimal getKilometrazha() {
        return kilometrazha;
    }

    public int getKapaciteti() {
        return kapaciteti;
    }

    public Karburanti getKarburanti() {
        return karburanti;
    }

    public int getCmimiDitor() {
        return cmimi_ditor;
    }

    public Statusi_Vetura getStatusi() {
        return statusi;
    }
}
