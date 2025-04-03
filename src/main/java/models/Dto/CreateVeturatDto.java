package models.Dto;

import models.enums.Karburanti;
import models.enums.StatusiVetura;
import java.math.BigDecimal;

public class CreateVeturatDto {
    private String targat;
    private String modeli;
    private String ngjyra;
    private int vitiProdhimit;
    private BigDecimal kilometrazha;
    private int numriUleseve;
    private Karburanti karburanti;
    private int cmimiDitor;
    private StatusiVetura statusi;

    public CreateVeturatDto(String targat, String modeli, String ngjyra,
                            int vitiProdhimit, BigDecimal kilometrazha, int numriUleseve,
                            Karburanti karburanti, int cmimiDitor, StatusiVetura statusi) {
        this.targat = targat;
        this.modeli = modeli;
        this.ngjyra = ngjyra;
        this.vitiProdhimit = vitiProdhimit;
        this.kilometrazha = kilometrazha;
        this.numriUleseve = numriUleseve;
        this.karburanti = karburanti;
        this.cmimiDitor = cmimiDitor;
        this.statusi = statusi;
    }

    public void setTargat(String targat) {
        this.targat = targat;
    }

    public void setModeli(String modeli) {
        this.modeli = modeli;
    }

    public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    public void setVitiProdhimit(int vitiProdhimit) {
        this.vitiProdhimit = vitiProdhimit;
    }

    public void setKilometrazha(BigDecimal kilometrazha) {
        this.kilometrazha = kilometrazha;
    }

    public void setNumriUleseve(int numriUleseve) {
        this.numriUleseve = numriUleseve;
    }

    public void setKarburanti(Karburanti karburanti) {
        this.karburanti = karburanti;
    }

    public void setCmimiDitor(int cmimiDitor) {
        this.cmimiDitor = cmimiDitor;
    }

    public void setStatusi(StatusiVetura statusi) {
        this.statusi = statusi;
    }

    public String getTargat() {
        return targat;
    }

    public String getModeli() {
        return modeli;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public int getVitiProdhimit() {
        return vitiProdhimit;
    }

    public BigDecimal getKilometrazha() {
        return kilometrazha;
    }

    public int getNumriUleseve() {
        return numriUleseve;
    }

    public Karburanti getKarburanti() {
        return karburanti;
    }

    public int getCmimiDitor() {
        return cmimiDitor;
    }

    public StatusiVetura getStatusi() {
        return statusi;
    }
}
