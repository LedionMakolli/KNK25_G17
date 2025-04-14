package models.Dto;

import java.sql.Timestamp;

public class UpdateReviewsDto {
    private int id;
    private Integer clientId;
    private Integer carId;
    private Integer rating;
    private String text;
    private Timestamp date;

    public UpdateReviewsDto(int id, int clientId, int carId, int rating, String text, Timestamp date) {
        this.id = id;
        this.clientId = clientId;
        this.carId = carId;
        this.rating = rating;
        this.text = text;
        this.date = date;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getCarId() {
        return carId;
    }

    public Integer getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public Timestamp getDate() {
        return date;
    }
}
