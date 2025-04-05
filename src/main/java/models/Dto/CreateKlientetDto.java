package models.Dto;

public class CreateKlientetDto extends CreateUserDto {
    private int idKlienti;
    private String nrPersonal;

    public CreateKlientetDto(int idKlienti, String emri, String mbiemri, String email, String password, String nrTelefonit, String roli, String nrPersonal) {
        super(emri, mbiemri, email, password, nrTelefonit, roli);
        this.idKlienti = idKlienti;
        this.nrPersonal = nrPersonal;
    }

    public int getIdKlienti() {
        return idKlienti;
    }

    public void setIdKlienti(int idKlienti) {
        this.idKlienti = idKlienti;
    }

    public String getNrPersonal() {
        return nrPersonal;
    }

    public void setNrPersonal(String nrPersonal) {
        this.nrPersonal = nrPersonal;
    }
}
