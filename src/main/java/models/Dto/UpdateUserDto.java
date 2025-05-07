package models.Dto;

abstract class UpdateUserDto {
    private int id;
    private int age;
    private String email;
    private String password;
    private String saltedHash;
    private String telephoneNumber;

    public UpdateUserDto(int id, int age, String email, String password, String saltedHash, String telephoneNumber) {
        this.id=id;
        this.age=age;
        this.email = email;
        this.password = password;
        this.saltedHash=saltedHash;
        this.telephoneNumber=telephoneNumber;
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

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setSaltedHash(String saltedHash) {
        this.saltedHash=saltedHash;
    }
    public String getSaltedHash() {
        return saltedHash;
    }
}
