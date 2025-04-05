package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klientet extends User {
    private int idKlienti;
    private String nrPersonal;

    private Klientet(int id, String emri, String mbiemri, String email, String password, String nrTelefoni,
                     String roli, int idKlienti, String nrPersonal) {
        super(id, emri, mbiemri, email, password, nrTelefoni, roli);
        this.idKlienti=idKlienti;
        this.nrPersonal=nrPersonal;
    }

    public static Klientet getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String emri = resultSet.getString("emri");
        String mbiemri = resultSet.getString("mbiemri");
        String nrPersonal = resultSet.getString("nrpersonal");
        String nrTelefoni = resultSet.getString("nrtelefoni");

        return new Klientet(id, emri, mbiemri, nrPersonal, nrTelefoni);
    }
    public int getIdKlienti() {
        return this.idKlienti;
    }

    public String getNrPersonal() {
        return nrPersonal;
    }


    public void printoTeDhenatPerKlientin() {
        System.out.println("Klienti u gjet:");
        System.out.println("ID: " + getId());
        System.out.println("Emri: " + getEmri());
        System.out.println("Mbiemri: " + getMbiemri());
        System.out.println("Nr Personal: " + getNrPersonal());
        System.out.println("Telefoni: " + getNrTelefoni());
        System.out.println("------------------------------");
    }
}
