package models.Dto;

import models.enums.FuelEnum;
import models.enums.CarStatusEnum;
import models.enums.TransmissionTypeEnum;
import java.math.BigDecimal;

public class CreateCarDto {
    private String licensePlate;
    private String model;
    private String color;
    private int yearOfManufacture;
    private BigDecimal mileage;
    private int numberOfSeats;
    private FuelEnum fuelType;
    private int dailyPrice;
    private CarStatusEnum status;
    private TransmissionTypeEnum transmissionType;

    public CreateCarDto(String licensePlate, String model, String color,
                        int yearOfManufacture, BigDecimal mileage, int numberOfSeats,
                        FuelEnum fuelType, int dailyPrice, CarStatusEnum status, TransmissionTypeEnum transmissionType) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.dailyPrice = dailyPrice;
        this.status = status;
        this.transmissionType = transmissionType;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setFuelType(FuelEnum fuelType) {
        this.fuelType = fuelType;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public void setStatus(CarStatusEnum status) {
        this.status = status;
    }

    public void setTransmissionType(TransmissionTypeEnum transmissionType) {
        this.transmissionType = transmissionType;
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public FuelEnum getFuelType() {
        return fuelType;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public CarStatusEnum getStatus() {
        return status;
    }

    public TransmissionTypeEnum getTransmissionType() {
        return transmissionType;
    }

}
