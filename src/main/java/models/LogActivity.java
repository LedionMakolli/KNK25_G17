package models;

import models.enums.VeprimetEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LogActivity {
    private int id;
    private Integer idUser;
    private VeprimetEnum veprimi;
    private LocalDateTime data;
    private String ipAddress;

    // Constructor
    public LogActivity(int id, Integer idUser, VeprimetEnum veprimi, LocalDateTime data, String ipAddress) {
        this.id = id;
        this.idUser = idUser;
        this.veprimi = veprimi;
        this.data = data;
        this.ipAddress = ipAddress;
    }


    public static LogActivity getLogActivityById(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");

        Integer idUser = resultSet.getObject("idUser", Integer.class);

        String veprimiStr = resultSet.getString("veprimi");
        VeprimetEnum veprimi = VeprimetEnum.valueOf(veprimiStr.toUpperCase());

        LocalDateTime data = resultSet.getTimestamp("data").toLocalDateTime();

        String ipAddress = resultSet.getString("ipAddress");

        return new LogActivity(id, idUser, veprimi, data, ipAddress);
    }


    public int getId() {
        return id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public VeprimetEnum getVeprimi() {
        return veprimi;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getIpAddress() {
        return ipAddress;
    }


    public void printoTeDhenatPerMirembajtjen() {
        System.out.println("-----------------------------");
        System.out.println("Detajet e Mirembajtjes");
        System.out.println("ID: " + id);
        System.out.println("ID User: " + idUser);
        System.out.println("Veprimi: " + veprimi);
        System.out.println("Data: " + data);
        System.out.println("IP Address: " + ipAddress);
        System.out.println("-----------------------------");
    }
}
