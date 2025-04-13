package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Reviews {
    private int id;
    private int clientId;
    private int carId;
    private int rating;
    private String text;
    private Timestamp date;

    private Reviews(int id, int clientId, int carId, int rating, String text, Timestamp date) {
        this.id = id;
        this.clientId = clientId;
        this.carId = carId;
        this.rating = rating;
        this.text = text;
        this.date = date;
    }

    public static Reviews getInstance(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int clientId = rs.getInt("clientid");
        int carId = rs.getInt("carid");
        int rating = rs.getInt("rating");
        String text = rs.getString("text");
        Timestamp date = rs.getTimestamp("date");

        return new Reviews(id, clientId, carId, rating, text, date);
    }

    public int getId() {
        return id;
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
