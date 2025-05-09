package models;

abstract class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String personalNumber;
    private String email;
    private String username;
    private String password;
    private String salt;
    private String telephoneNumber;

    protected User(int id, String firstName, String lastName, int age, String personalNumber, String email,
                   String username, String password, String salt, String telephoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
        this.personalNumber=personalNumber;
        this.email = email;
        this.username=username;
        this.password = password;
        this.salt =salt;
        this.telephoneNumber=telephoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public String getSalt() {
        return salt;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
