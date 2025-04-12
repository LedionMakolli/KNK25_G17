package models;

import java.sql.ResultSet;
import java.sql.SQLException;

abstract class User {
    private int id;
    private String emri;
    private String mbiemri;
    private int age;
    private String email;
    private String password;
    private String nrTelefonit;

    protected User(int id, String emri, String mbiemri, int age, String email, String password, String nrTelefonit) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.age=age;
        this.email = email;
        this.password = password;
        this.nrTelefonit=nrTelefonit;
    }

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
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
