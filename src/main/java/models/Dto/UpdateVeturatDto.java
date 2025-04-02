package models.Dto;

import models.enums.StatusiVetura;
import java.math.BigDecimal;


public class UpdateVeturatDto {
    private int idVetura;
    private String ngjyra;
    private BigDecimal kilometrazha;
    private int cmimiDitor;
    private StatusiVetura statusi;

    public UpdateVeturatDto(int idVetura, String ngjyra, BigDecimal kilometrazha,
                            int cmimiDitor, StatusiVetura statusi) {
        this.idVetura = idVetura;
        this.ngjyra = ngjyra;
        this.kilometrazha = kilometrazha;
        this.cmimiDitor = cmimiDitor;
        this.statusi = statusi;
    }
    public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    public void setKilometrazha(BigDecimal kilometrazha) {
        this.kilometrazha = kilometrazha;
    }

    public void setCmimiDitor(int cmimiDitor) {
        this.cmimiDitor = cmimiDitor;
    }

    public void setStatusi(StatusiVetura statusi) {
        this.statusi = statusi;
    }

    public int getIdVetura() {
        return idVetura;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public BigDecimal getKilometrazha() {
        return kilometrazha;
    }

    public int getCmimiDitor() {
        return cmimiDitor;
    }

    public StatusiVetura getStatusi() {
        return statusi;
    }
}
