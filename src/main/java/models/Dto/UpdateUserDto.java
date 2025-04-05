package models.Dto;

public class UpdateUserDto {
    private int id;
    private String email;
    private String password;
    private String nrTelefonit;
    private String roli;

    public UpdateUserDto(int id, String email, String password, String nrTelefonit, String roli) {
        this.id=id;
        this.email = email;
        this.password = password;
        this.nrTelefonit=nrTelefonit;
        this.roli = roli;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNrTelefonit(String nrTelefonit) {
        this.nrTelefonit = nrTelefonit;
    }

    public void setRoli(String roli) {
        this.roli = roli;
    }
    public int getId() {
        return id;
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
}
