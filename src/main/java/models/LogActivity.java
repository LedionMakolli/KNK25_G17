package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LogActivity {
    private int id;
    private Integer idUser;
    private String userType; // Client or Staff
    private static final String action="Log In";
    private LocalDateTime date;

    private LogActivity(int id, Integer idUser, String userType, LocalDateTime date) {
        this.id = id;
        this.idUser = idUser;
        this.userType = userType;
        this.date = date;
    }

    public static LogActivity getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        Integer idUser = resultSet.getObject("idUser", Integer.class);
        String userType = resultSet.getString("userType");
        String actionStr = resultSet.getString("action");
        LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();

        return new LogActivity(id, idUser, userType, date);
    }

    public int getId() {
        return id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getUserType() {
        return userType;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void printLogActivityDetails() {
        System.out.println("-----------------------------");
        System.out.println("Log Activity Details");
        System.out.println("ID: " + id);
        System.out.println("ID User: " + idUser);
        System.out.println("User Type: " + userType);
        System.out.println("Action: " + action);
        System.out.println("Date: " + date);
        System.out.println("-----------------------------");
    }
}
