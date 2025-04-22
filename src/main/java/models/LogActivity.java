package models;

import models.enums.ActionEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LogActivity {
    private int id;
    private String clientUsername;
    private String staffUsername;
    private ActionEnum action;
    private LocalDateTime date;

    public LogActivity(int id, String clientUsername, String staffUsername, ActionEnum action, LocalDateTime date) {
        this.id = id;
        this.clientUsername = clientUsername;
        this.staffUsername = staffUsername;
        this.action = action;
        this.date = date;
    }

    public static LogActivity fromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String clientUsername = rs.getString("clientUsername");
        String staffUsername = rs.getString("staffUsername");
        ActionEnum action = ActionEnum.valueOf(rs.getString("action"));
        LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();

        return new LogActivity(id, clientUsername, staffUsername, action, date);
    }

    public static LogActivity createForClient(String clientUsername, ActionEnum action) {
        return new LogActivity(0, clientUsername, null, action, LocalDateTime.now());
    }

    public static LogActivity createForStaff(String staffUsername, ActionEnum action) {
        return new LogActivity(0, null, staffUsername, action, LocalDateTime.now());
    }

    // Getters
    public int getId() { return id; }
    public String getClientUsername() { return clientUsername; }
    public String getStaffUsername() { return staffUsername; }
    public ActionEnum getAction() { return action; }
    public LocalDateTime getDate() { return date; }

    // Utility method to get the acting username regardless of type
    public String getActorUsername() {
        return clientUsername != null ? clientUsername : staffUsername;
    }

    public void printDetails() {
        System.out.println("-----------------------------");
        System.out.println("Log Activity Details");
        System.out.println("ID: " + id);
        System.out.println("User: " + getActorUsername());
        System.out.println("Action: " + action);
        System.out.println("Date: " + date);
        System.out.println("-----------------------------");
    }
}