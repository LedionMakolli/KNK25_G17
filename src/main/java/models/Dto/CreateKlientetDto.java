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

    public String getEmri() {
        return super.getEmri();
    }

    public String getMbiemri() {
        return super.getMbiemri();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public String getNrTelefonit() {
        return super.getNrTelefonit();
    }

    public String getRoli() {
        return super.getRoli();
    }

    public void setEmri(String emri) {
        super.setEmri(emri);
    }

    public void setMbiemri(String mbiemri) {
        super.setMbiemri(mbiemri);
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    public void setNrTelefonit(String nrTelefonit) {
        super.setNrTelefonit(nrTelefonit);
    }

    public void setRoli(String roli) {
        super.setRoli(roli);
    }
}
