package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Vleresimet {
    private int idVleresimi;
    private int idKlienti;
    private int idVetura;
    private int rating;
    private String text;
    private String data;

    private Vleresimet(int idVleresimi, int idKlienti, int idVetura, int rating, String text, String data) {
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
        String data = rs.getString("data");

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

    public String getData() {
        return data;
    }
}
