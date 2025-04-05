package models.Dto;

public class UpdateUserDto {
    private int id;
    private String email;
    private String password;
    private String roli;

    public UpdateUserDto(int id, String email, String password, String roli) {
        this.id = id;
        this.email = email;
        this.password = password;
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

    public String getRoli() {
        return roli;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoli(String roli) {
        this.roli = roli;
    }
}
