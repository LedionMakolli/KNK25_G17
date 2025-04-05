package models.Dto;

import java.time.LocalDate;

public class CreateStafiDto extends CreateUserDto {
    private int idStafi;
    private String pozita;
    private LocalDate dataPunesimit;

    public CreateStafiDto(String emri, String mbiemri, String email, String password,
                          String nrTelefonit, String roli, int idStafi, String pozita, LocalDate dataPunesimit) {
        super(emri, mbiemri, email, password, nrTelefonit, roli);
        this.idStafi = idStafi;
        this.pozita = pozita;
        this.dataPunesimit = dataPunesimit;
    }

    public int getIdStafi() {
        return idStafi;
    }

    public void setIdStafi(int idStafi) {
        this.idStafi = idStafi;
    }

    public String getPozita() {
        return pozita;
    }

    public void setPozita(String pozita) {
        this.pozita = pozita;
    }

    public LocalDate getDataPunesimit() {
        return dataPunesimit;
    }

    public void setDataPunesimit(LocalDate dataPunesimit) {
        this.dataPunesimit = dataPunesimit;
    }
}

