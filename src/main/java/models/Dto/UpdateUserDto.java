package models.Dto;

public class UpdateUserDto {
    private int id;
    private String email;
    private String password;
    private String nrTelefonit;

    public UpdateUserDto(int id, String email, String password, String nrTelefonit) {
        this.id=id;
        this.email = email;
        this.password = password;
        this.nrTelefonit=nrTelefonit;
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
}
