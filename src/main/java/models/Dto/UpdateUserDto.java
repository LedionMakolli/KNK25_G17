package models.Dto;

abstract class UpdateUserDto {
    private int id;
    private int age;
    private String email;
    private String password;
    private String nrTelefonit;

    public UpdateUserDto(int id, int age, String email, String password, String nrTelefonit) {
        this.id=id;
        this.age=age;
        this.email = email;
        this.password = password;
        this.nrTelefonit=nrTelefonit;
    }

    public void setAge(int age) {
        this.age=age;
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

    public int getAge() {
        return age;
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
