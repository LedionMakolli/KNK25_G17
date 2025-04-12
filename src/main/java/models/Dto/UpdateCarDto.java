package models.Dto;

import models.enums.CarStatusEnum;
import java.math.BigDecimal;

public class UpdateCarDto {
    private int id;
    private String ngjyra;
    private BigDecimal kilometrazha;
    private int cmimiDitor;
    private CarStatusEnum statusi;

    public UpdateCarDto(int id, String ngjyra, BigDecimal kilometrazha,
                        int cmimiDitor, CarStatusEnum statusi) {
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

    public void setStatusi(CarStatusEnum statusi) {
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

    public CarStatusEnum getStatusi() {
        return statusi;
    }
}
