package models;

import models.enums.FuelDto;
import models.enums.CarStatusEnum;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cars {
    private int id;
    private String licensePlate;
    private String model;
    private String color;
    private int productionYear;
    private BigDecimal mileage;
    private int seatCount;
    private FuelDto fuelType;
    private int dailyPrice;
    private CarStatusEnum status;

    private Cars(int id, String licensePlate, String model, String color,
                int productionYear, BigDecimal mileage, int seatCount,
                FuelDto fuelType, int dailyPrice, CarStatusEnum status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.seatCount = seatCount;
        this.fuelType = fuelType;
        this.dailyPrice = dailyPrice;
        this.status = status;
    }

    public static Cars getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String licensePlate = resultSet.getString("licensePlate");
        String model = resultSet.getString("model");
        String color = resultSet.getString("color");
        int productionYear = resultSet.getInt("productionYear");
        BigDecimal mileage = resultSet.getBigDecimal("mileage");
        int seatCount = resultSet.getInt("seatCount");
        String fuelTypeStr = resultSet.getString("fuelType");
        FuelDto fuelType = FuelDto.valueOf(fuelTypeStr.toUpperCase());
        int dailyPrice = resultSet.getInt("dailyPrice");
        String statusStr = resultSet.getString("status");
        CarStatusEnum status = CarStatusEnum.valueOf(statusStr.toUpperCase());
        return new Cars(id, licensePlate, model, color, productionYear, mileage, seatCount, fuelType, dailyPrice, status);
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

    public int getProductionYear() {
        return productionYear;
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
        System.out.println("Production Year: " + getProductionYear());
        System.out.println("Mileage: " + getMileage() + " km");
        System.out.println("Seat Capacity: " + getSeatCount() + " Seats");
        System.out.println("Fuel Type: " + getFuelType());
        System.out.println("Daily Price: " + getDailyPrice() + " €");
        System.out.println("Status: " + getStatus());
        System.out.println("----------------------------------------");
    }
}
