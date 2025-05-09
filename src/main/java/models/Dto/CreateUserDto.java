package models.Dto;

abstract class CreateUserDto {
    private String firstName;
    private String lastName;
    private int age;
    private String personalNumber;
    private String email;
    private String username;
    private String password;
    private String salt;
    private String telephoneNumber;

    public CreateUserDto(String firstName, String lastName, int age, String personalNumber, String email,
                         String username, String password, String salt, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
        this.personalNumber=personalNumber;
        this.email = email;
        this.username=username;
        this.password = password;
        this.salt=salt;
        this.telephoneNumber=telephoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public void setSalt(String salt) {
        this.salt=salt;
    }
    public String getSalt() {
        return salt;
    }
}
