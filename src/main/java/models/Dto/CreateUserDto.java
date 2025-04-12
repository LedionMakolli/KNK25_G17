package models.Dto;

abstract class CreateUserDto {
    private String emri;
    private String mbiemri;
    private int age;
    private String email;
    private String password;
    private String nrTelefonit;

    public CreateUserDto(String emri, String mbiemri, int age, String email, String password, String nrTelefonit) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.age=age;
        this.email = email;
        this.password = password;
        this.nrTelefonit=nrTelefonit;
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

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getNrTelefonit() {
        return nrTelefonit;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
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
        this.nrTelefonit=nrTelefonit;
    }
}
