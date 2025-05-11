package models;

import models.enums.FuelEnum;
import models.enums.CarStatusEnum;
import models.enums.TransmissionTypeEnum;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cars {
    private int id;
    private String licensePlate;
    private String model;
    private String color;
    private int yearOfManufacture;
    private BigDecimal mileage;
    private int seatCount;
    private FuelEnum fuelType;
    private int dailyPrice;
    private CarStatusEnum status;
    private TransmissionTypeEnum transmissionType;

    private Cars(int id, String licensePlate, String model, String color,
                 int yearOfManufacture, BigDecimal mileage, int seatCount,
                 FuelEnum fuelType, int dailyPrice, CarStatusEnum status, TransmissionTypeEnum transmissionType) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.seatCount = seatCount;
        this.fuelType = fuelType;
        this.dailyPrice = dailyPrice;
        this.status = status;
        this.transmissionType=transmissionType;
    }

    public static Cars getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String licensePlate = resultSet.getString("licenseplate");
        String model = resultSet.getString("model");
        String color = resultSet.getString("color");
        int yearOfManufacture = resultSet.getInt("yearofmanufacture");
        BigDecimal mileage = resultSet.getBigDecimal("mileage");
        int seatCount = resultSet.getInt("seatcount");
        String fuelTypeStr = resultSet.getString("fueltype");
        FuelEnum fuelType = FuelEnum.valueOf(fuelTypeStr.toUpperCase());
        int dailyPrice = resultSet.getInt("dailyprice");
        String statusStr = resultSet.getString("status");
        CarStatusEnum status = CarStatusEnum.valueOf(statusStr.toUpperCase());
        String transmissionType1=resultSet.getString("transmissiontype");
        TransmissionTypeEnum transmissionType= TransmissionTypeEnum.valueOf(transmissionType1.toUpperCase());

        return new Cars(id, licensePlate, model, color, yearOfManufacture, mileage, seatCount, fuelType, dailyPrice, status, transmissionType);
    }

    public int getId() {
        return id;
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

    public int getSeatCount() {
        return seatCount;
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


    public void printCarDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Car details:");
        System.out.println("ID: " + getId());
        System.out.println("License Plate: " + getLicensePlate());
        System.out.println("Model: " + getModel());
        System.out.println("Color: " + getColor());
        System.out.println("Production Year: " + getYearOfManufacture());
        System.out.println("Mileage: " + getMileage() + " km");
        System.out.println("Seat Capacity: " + getSeatCount() + " Seats");
        System.out.println("Fuel Type: " + getFuelType());
        System.out.println("Daily Price: " + getDailyPrice() + " €");
        System.out.println("Status: " + getStatus());
        System.out.println("Transmission type: " + getTransmissionType());
        System.out.println("----------------------------------------");
    }
}
