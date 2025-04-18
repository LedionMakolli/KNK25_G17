package models.Dto;

import java.sql.Date;

public class UpdateOffersDto {
    private int id;
    private Integer carId;
    private Double discount;
    private Date startDate;
    private Date endDate;

    public UpdateOffersDto(int id, int carId, double discount, Date startDate, Date endDate) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public Integer getCarId() {
        return carId;
    }

    public Double getDiscount() {
        return discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
