package models.Dto;
import models.*;
import models.enums.Karburanti;
import models.enums.Statusi_Vetura;
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
    private int kilometrazha;
    private Karburanti karburanti;
    private int cmimi_ditor;
    private Statusi_Vetura statusi;

    public CreateVeturatDto(String targat, String modeli, String ngjyra,
                            int viti_prodhimit, int kilometrazha, Karburanti karburanti,
                            int cmimi_ditor, Statusi_Vetura statusi) {
        this.targat = targat;
        this.modeli = modeli;
        this.ngjyra = ngjyra;
        this.viti_prodhimit = viti_prodhimit;
        this.kilometrazha = kilometrazha;
        this.karburanti = karburanti;
        this.cmimi_ditor = cmimi_ditor;
        this.statusi = statusi;
    }
    public String getTargat() {
        return targat;
    }

    public void setTargat(String targat) {
        this.targat = targat;
    }

    public String getModeli() {
        return modeli;
    }

    public void setModeli(String modeli) {
        this.modeli = modeli;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    public int getViti_prodhimit() {
        return viti_prodhimit;
    }

    public void setViti_prodhimit(int viti_prodhimit) {
        this.viti_prodhimit = viti_prodhimit;
    }

    public int getKilometrazha() {
        return kilometrazha;
    }

    public void setKilometrazha(int kilometrazha) {
        this.kilometrazha = kilometrazha;
    }

    public Karburanti getKarburanti() {
        return karburanti;
    }

    public void setKarburanti(Karburanti karburanti) {
        this.karburanti = karburanti;
    }

    public int getCmimi_ditor() {
        return cmimi_ditor;
    }

    public void setCmimi_ditor(int cmimi_ditor) {
        this.cmimi_ditor = cmimi_ditor;
    }

    public Statusi_Vetura getStatusi() {
        return statusi;
    }

    public void setStatusi(Statusi_Vetura statusi) {
        this.statusi = statusi;
    }
}
