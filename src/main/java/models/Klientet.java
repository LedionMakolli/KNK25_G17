package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klientet {
    private int id_klienti;
    private String emri;
    private String mbiemri;
    private String nr_personal;
    private String telefoni;

    private Klientet(int ID_klienti, String emri, String mbiemri, String nr_personal, String nr_telefonit) {
        this.id_klienti = ID_klienti;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.nr_personal = nr_personal;
        this.telefoni = nr_telefonit;
    }
    public static Klientet getInstance(ResultSet resultSet) throws SQLException {
        int id_klienti=resultSet.getInt("ID_klienti");
        String emri=resultSet.getString("emri");
        String mbiemri=resultSet.getString("mbiemri");
        String nr_personal=resultSet.getString("nr_personal");
        String nr_telefonit=resultSet.getString("telefoni");

        return new Klientet(id_klienti, emri, mbiemri, nr_personal, nr_telefonit);
    }

    public int getId_klienti() {
        return id_klienti;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getNr_personal() {
        return nr_personal;
    }

    public String getTelefoni() {
        return telefoni;
    }
}
