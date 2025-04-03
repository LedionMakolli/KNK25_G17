package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Vleresimet {
    private int idVleresimi;
    private int idKlienti;
    private int idVetura;
    private int rating;
    private String text;
    private Timestamp data;

    private Vleresimet(int idVleresimi, int idKlienti, int idVetura, int rating, String text, Timestamp data) {
        this.idVleresimi = idVleresimi;
        this.idKlienti = idKlienti;
        this.idVetura = idVetura;
        this.rating = rating;
        this.text = text;
        this.data = data;
    }

    public static Vleresimet getInstance(ResultSet rs) throws SQLException {
        int idVleresimi = rs.getInt("idVleresimi");
        int idKlienti = rs.getInt("idKlienti");
        int idVetura = rs.getInt("idVetura");
        int rating = rs.getInt("rating");
        String text = rs.getString("text");
        Timestamp data = rs.getTimestamp("data");

        return new Vleresimet(idVleresimi, idKlienti, idVetura, rating, text, data);
    }

    public int getIdVleresimi() {
        return idVleresimi;
    }

    public int getIdKlienti() {
        return idKlienti;
    }

    public int getIdVetura() {
        return idVetura;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public Timestamp getData() {
        return data;
    }
}
