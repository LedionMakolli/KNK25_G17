package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klientet {
    private int idKlienti;
    private String emri;
    private String mbiemri;
    private String nrPersonal;
    //    private String klientUsername;
//    private String klientPassword;
    private String nrTelefoni;

    private Klientet(int idKlienti, String emri, String mbiemri, String nrPersonal, String nrTelefoni) {
        this.idKlienti = idKlienti;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.nrPersonal = nrPersonal;
        this.nrTelefoni = nrTelefoni;
    }

    public static Klientet getInstance(ResultSet resultSet) throws SQLException {
        int idKlienti = resultSet.getInt("idklienti");
        String emri = resultSet.getString("emri");
        String mbiemri = resultSet.getString("mbiemri");
        String nrPersonal = resultSet.getString("nrpersonal");
        String nrTelefoni = resultSet.getString("telefoni");

        return new Klientet(idKlienti, emri, mbiemri, nrPersonal, nrTelefoni);
    }

    public int getIdKlienti() {
        return idKlienti;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getNrPersonal() {
        return nrPersonal;
    }

    public String getNrTelefoni() {
        return nrTelefoni;
    }

    public void printoTeDhenatPerKlientin() {
        System.out.println("Klienti u gjet:");
        System.out.println("ID: " + getIdKlienti());
        System.out.println("Emri: " + getEmri());
        System.out.println("Mbiemri: " + getMbiemri());
        System.out.println("Nr Personal: " + getNrPersonal());
        System.out.println("Telefoni: " + getNrTelefoni());
    }
}
