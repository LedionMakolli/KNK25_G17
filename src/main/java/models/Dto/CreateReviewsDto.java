package models.Dto;

import java.sql.Timestamp;

public class CreateReviewsDto {
    private int clientId;
    private int carId;
    private int rating;
    private String text;
    private Timestamp date;

    public CreateReviewsDto(int clientId, int carId, int rating, String text, Timestamp date) {
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

    public int getClientId() {
        return clientId;
    }

    public int getCarId() {
        return carId;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public Timestamp getDate() {
        return date;
    }
}
