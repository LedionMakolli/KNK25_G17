package models.Dto;

import models.enums.StatusiVeturaEnum;
import java.math.BigDecimal;

public class UpdateVeturatDto {
    private int id;
    private String ngjyra;
    private BigDecimal kilometrazha;
    private int cmimiDitor;
    private StatusiVeturaEnum statusi;

    public UpdateVeturatDto(int id, String ngjyra, BigDecimal kilometrazha,
                            int cmimiDitor, StatusiVeturaEnum statusi) {
        this.id = id;
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

    public void setStatusi(StatusiVeturaEnum statusi) {
        this.statusi = statusi;
    }

    public int getId() {
        return id;
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

    public StatusiVeturaEnum getStatusi() {
        return statusi;
    }
}
