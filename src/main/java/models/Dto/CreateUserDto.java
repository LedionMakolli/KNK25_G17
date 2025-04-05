package models.Dto;

public class CreateUserDto {
    private String emri;
    private String mbiemri;
    private String email;
    private String password;
    private String nrTelefonit;
    private String roli;

    public CreateUserDto(String emri, String mbiemri, String email, String password, String nrTelefonit, String roli) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.password = password;
        this.nrTelefonit=nrTelefonit;
        this.roli = roli;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNrTelefonit() {
        return nrTelefonit;
    }

    public String getRoli() {
        return roli;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNrTelefonit(String nrTelefonit) {
        this.nrTelefonit=nrTelefonit;
    }

    public void setRoli(String roli) {
        this.roli = roli;
    }
}
