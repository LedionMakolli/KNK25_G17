package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String emri;
    private String mbiemri;
    private String email;
    private String password;
    private String roli; // "ADMIN", "CLIENT", "STAFF"

    protected User(int id, String emri, String mbiemri, String email, String password, String roli) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.email = email;
        this.password = password;
        this.roli = roli;
    }

    public static User getInstance(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String emri = rs.getString("emri");
        String mbiemri = rs.getString("mbiemri");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String roli = rs.getString("roli");

        return new User(id, emri, mbiemri, email, password, roli);
    }
}
