package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klientet {
    private int ID_klienti;
    private String Emri;
    private String Mbiemri;
    private String Nr_personal;
    private String Nr_telefonit;

    private Klientet(int ID_klienti, String emri, String mbiemri, String nr_personal, String nr_telefonit) {
        this.ID_klienti = ID_klienti;
        this.Emri = emri;
        this.Mbiemri = mbiemri;
        this.Nr_personal = nr_personal;
        this.Nr_telefonit = nr_telefonit;
    }
    public static Klientet getInstance(ResultSet resultSet) throws SQLException {
        int ID_klienti=resultSet.getInt("ID_klienti");
        String Emri=resultSet.getString("emri");
        String Mbiemri=resultSet.getString("mbiemri");
        String Nr_personal=resultSet.getString("nr_personal");
        String Nr_telefonit=resultSet.getString("telefoni");
    }
}
