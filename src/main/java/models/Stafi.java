package models;

import java.time.LocalDate;

public class Stafi extends User {
    private int idStafi;
    private String pozita;  // "Menaxher", "Staf", "Mekanik"
    private LocalDate dataPunesimit;

    private Stafi(int id, String emri, String mbiemri, String email, String password, String roli, int idStafi, String pozita, LocalDate dataPunesimit) {
        super(id, emri, mbiemri, email, password, roli);
        this.idStafi = idStafi;
        this.pozita = pozita;
        this.dataPunesimit = dataPunesimit;
    }
}
