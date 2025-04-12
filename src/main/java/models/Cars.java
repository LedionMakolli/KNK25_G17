package models;

import models.enums.FuelDto;
import models.enums.CarStatusEnum;
import models.enums.TransmissionType;

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
    private FuelDto fuelType;
    private int dailyPrice;
    private CarStatusEnum status;
    private TransmissionType transmissionType;

    private Cars(int id, String licensePlate, String model, String color,
                 int yearOfManufacture, BigDecimal mileage, int seatCount,
                 FuelDto fuelType, int dailyPrice, CarStatusEnum status) {
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
    }

    public static Cars getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String licensePlate = resultSet.getString("license_plate");
        String model = resultSet.getString("model");
        String color = resultSet.getString("color");
        int yearOfManufacture = resultSet.getInt("year_of_manufacture");
        BigDecimal mileage = resultSet.getBigDecimal("mileage");
        int seatCount = resultSet.getInt("seat_count");
        String fuelTypeStr = resultSet.getString("fuel_type");
        FuelDto fuelType = FuelDto.valueOf(fuelTypeStr.toUpperCase());
        int dailyPrice = resultSet.getInt("daily_price");
        String statusStr = resultSet.getString("status");
        CarStatusEnum status = CarStatusEnum.valueOf(statusStr.toUpperCase());

        return new Cars(id, licensePlate, model, color, yearOfManufacture, mileage, seatCount, fuelType, dailyPrice, status);
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

    public FuelDto getFuelType() {
        return fuelType;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public CarStatusEnum getStatus() {
        return status;
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
        System.out.println("----------------------------------------");
    }
}
