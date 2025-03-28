package models.Dto;

import models.enums.Karburanti;
import models.enums.Statusi_Vetura;
import models.enums.Statusi_Vetura;

public class UpdateVeturatDto {
    private int ID_Vetura;
    private String ngjyra;
    private int kilometrazha;
    private Karburanti karburanti;
    private int cmimi_ditor;
    private Statusi_Vetura statusi;

    public UpdateVeturatDto(int ID_Vetura, String ngjyra, int kilometrazha, Karburanti karburanti,
                            int cmimi_ditor, Statusi_Vetura statusi) {
        this.ID_Vetura = ID_Vetura;
        this.ngjyra = ngjyra;
        this.kilometrazha = kilometrazha;
        this.karburanti = karburanti;
        this.cmimi_ditor = cmimi_ditor;
        this.statusi = statusi;
    }

    public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    public void setKilometrazha(int kilometrazha) {
        this.kilometrazha = kilometrazha;
    }

    public void setKarburanti(Karburanti karburanti) {
        this.karburanti = karburanti;
    }

    public void setCmimi_ditor(int cmimi_ditor) {
        this.cmimi_ditor = cmimi_ditor;
    }

    public void setStatusi(Statusi_Vetura statusi) {
        this.statusi = statusi;
    }

    public int getID_Vetura() {
        return ID_Vetura;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public int getKilometrazha() {
        return kilometrazha;
    }

    public Karburanti getKarburanti() {
        return karburanti;
    }

    public int getCmimi_ditor() {
        return cmimi_ditor;
    }

    public Statusi_Vetura getStatusi() {
        return statusi;
    }
}
