package models.Dto;

import java.sql.Date;

public class CreateOffersDto {
    private int carId;
    private double discount;
    private Date startDate;
    private Date endDate;

    public CreateOffersDto(int carId, double discount, Date startDate, Date endDate) {
        this.carId = carId;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCarId() {
        return carId;
    }

    public double getDiscount() {
        return discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
