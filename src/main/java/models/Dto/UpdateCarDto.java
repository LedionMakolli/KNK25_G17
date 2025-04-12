package models.Dto;

import models.enums.CarStatusEnum;
import java.math.BigDecimal;

public class UpdateCarDto {
    private int id;
    private String color;
    private BigDecimal mileage;
    private int dailyPrice;
    private CarStatusEnum status;

    public UpdateCarDto(int id, String color, BigDecimal mileage,
                        int dailyPrice, CarStatusEnum status) {
        this.id = id;
        this.color = color;
        this.mileage = mileage;
        this.dailyPrice = dailyPrice;
        this.status = status;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public void setStatus(CarStatusEnum status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public CarStatusEnum getStatus() {
        return status;
    }
}
