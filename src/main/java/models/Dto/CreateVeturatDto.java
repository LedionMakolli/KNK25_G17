package models.Dto;
import models.*;
import models.enums.Karburanti;
import models.enums.Statusi_Vetura;

import java.math.BigDecimal;
//enum Karburanti {
//    BENZINE,
//    NAFTE,
//    ELEKTRIKE,
//    HIBRID
//}
//
//enum Statusi {
//    NE_DIZPONIM,
//    E_REZERVUAR,
//    NE_SERVIS
//}

public class CreateVeturatDto {
    private String targat;
    private String modeli;
    private String ngjyra;
    private int viti_prodhimit;
    private BigDecimal kilometrazha;
    private int kapaciteti;
    private Karburanti karburanti;
    private int cmimi_ditor;
    private Statusi_Vetura statusi;

    public CreateVeturatDto(String targat, String modeli, String ngjyra,
                            int viti_prodhimit, BigDecimal kilometrazha, int kapaciteti, Karburanti karburanti,
                            int cmimi_ditor, Statusi_Vetura statusi) {
        this.targat = targat;
        this.modeli = modeli;
        this.ngjyra = ngjyra;
        this.viti_prodhimit = viti_prodhimit;
        this.kilometrazha = kilometrazha;
        this.kapaciteti=kapaciteti;
        this.karburanti = karburanti;
        this.cmimi_ditor = cmimi_ditor;
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

    public void setVitiprodhimit(int viti_prodhimit) {
        this.viti_prodhimit = viti_prodhimit;
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
        return viti_prodhimit;
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
