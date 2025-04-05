package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Stafi extends User {
    private String pozita;  // "Menaxher", "Staf", "Mekanik"
    private LocalDate dataPunesimit;

    private Stafi(int id, String emri, String mbiemri, String email, String password, String nrTelefonit, String roli, String pozita, LocalDate dataPunesimit) {
        super(id, emri, mbiemri, email, password, nrTelefonit, roli);
        this.pozita = pozita;
        this.dataPunesimit = dataPunesimit;
    }
    public static Stafi getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String emri = resultSet.getString("emri");
        String mbiemri = resultSet.getString("mbiemri");
        String email=resultSet.getString("email");
        String password=resultSet.getString("password");
        String nrTelefonit = resultSet.getString("nrtelefonit");
        String roli=resultSet.getString("roli");
        String pozita = resultSet.getString("pozita");
        LocalDate datapunesimit=resultSet.getDate("datapunesimit").toLocalDate();
        return new Stafi(id,emri,mbiemri,email,password,nrTelefonit,roli,pozita,datapunesimit);
    }

    public String getPozita() {
        return pozita;
    }

    public LocalDate getDataPunesimit() {
        return dataPunesimit;
    }
    public void printoTeDhenatPerStafin() {
        System.out.println("Punetori i stafit u gjet:");
        System.out.println("ID: " + getId());
        System.out.println("Emri: " + getEmri());
        System.out.println("Mbiemri: " + getMbiemri());
        System.out.println("Email: " + getEmail()); // passwordi
        System.out.println("Telefoni: " + getNrTelefonit());
        System.out.println("Roli: " + getRoli());
        System.out.println("Pozita: " + getPozita());
        System.out.println("Data e punesimit: " + getDataPunesimit());
        System.out.println("------------------------------");
    }
}
