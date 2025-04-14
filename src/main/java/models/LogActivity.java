package models;

import models.enums.VeprimetEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LogActivity {
    private int id;
    private Integer idUser;
    private VeprimetEnum action;
    private LocalDateTime date;
    private String ipAddress;

    // Constructor
    public LogActivity(int id, Integer idUser, VeprimetEnum action, LocalDateTime date, String ipAddress) {
        this.id = id;
        this.idUser = idUser;
        this.action = action;
        this.date = date;
        this.ipAddress = ipAddress;
    }


    public static LogActivity getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");

        Integer idUser = resultSet.getObject("idUser", Integer.class);

        String actionStr = resultSet.getString("action");
        VeprimetEnum action = VeprimetEnum.valueOf(actionStr.toUpperCase());

        LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();

        String ipAddress = resultSet.getString("ipAddress");

        return new LogActivity(id, idUser, action, date, ipAddress);
    }


    public int getId() {
        return id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public VeprimetEnum getAction() {
        return action;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getIpAddress() {
        return ipAddress;
    }


    public void printoTeDhenatPerMirembajtjen() {
        System.out.println("-----------------------------");
        System.out.println("Maintainance Details");
        System.out.println("ID: " + id);
        System.out.println("ID User: " + idUser);
        System.out.println("Action: " + action);
        System.out.println("Date: " + date);
        System.out.println("IP Address: " + ipAddress);
        System.out.println("-----------------------------");
    }
}
