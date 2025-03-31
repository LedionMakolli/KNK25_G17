package models;

import models.enums.Rating;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Vleresimet {
    private int id_vleresimi;
    private int id_klienti;
    private int id_vetura;
    private Rating rating;
    private String text;
    private String data;

    private Vleresimet(int id_vleresimi, int id_klienti, int id_vetura, Rating rating, String text, String data) {
        this.id_vleresimi = id_vleresimi;
        this.id_klienti = id_klienti;
        this.id_vetura = id_vetura;
        this.rating = rating;
        this.text = text;
        this.data = data;
    }

    public static Vleresimet getInstance(ResultSet rs) throws SQLException {
        int id_vleresimi = rs.getInt("id_vleresimi");
        int id_klienti = rs.getInt("id_klienti");
        int id_vetura = rs.getInt("id_vetura");
        int ratingInt = rs.getInt("rating");
        Rating rating = Rating.fromValue(ratingInt);
        String text = rs.getString("text");
        String data = rs.getString("data");

        return new Vleresimet(id_vleresimi, id_klienti, id_vetura, rating, text, data);
    }

    public int getId_vleresimi() {
        return id_vleresimi;
    }

    public int getId_klienti() {
        return id_klienti;
    }

    public int getId_vetura() {
        return id_vetura;
    }

    public Rating getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public String getData() {
        return data;
    }
}
