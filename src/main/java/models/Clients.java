package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Clients extends User {
    private String nrPersonal;

    private Clients(int id, String emri, String mbiemri, int age, String email, String password, String nrTelefoni, String nrPersonal) {
        super(id, emri, mbiemri, age, email, password, nrTelefoni);
        this.nrPersonal=nrPersonal;
    }

    public static Clients getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String emri = resultSet.getString("emri");
        String mbiemri = resultSet.getString("mbiemri");
        int age=resultSet.getInt("age");
        String email=resultSet.getString("email");
        String password=resultSet.getString("password");
        String nrTelefoni = resultSet.getString("nrtelefonit");
        String nrPersonal = resultSet.getString("nrpersonal");
        return new Clients(id, emri, mbiemri, age, email, password, nrTelefoni, nrPersonal);
    }

    public String getNrPersonal() {
        return nrPersonal;
    }
    public void printoTeDhenatPerKlientin() {
        System.out.println("Klienti u gjet:");
        System.out.println("ID: " + getId());
        System.out.println("Emri: " + getEmri());
        System.out.println("Mbiemri: " + getMbiemri());
        System.out.println("Age: " + getAge());
        System.out.println("Email: " + getEmail()); // passwordin
        System.out.println("Telefoni: " + getNrTelefonit());
        System.out.println("Numri Personal: " + getNrPersonal());
        System.out.println("------------------------------");
    }
}
