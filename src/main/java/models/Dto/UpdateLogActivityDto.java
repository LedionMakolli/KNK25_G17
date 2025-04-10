package models.Dto;

import models.enums.PagesaEnum;
import models.enums.VeprimetEnum;

import java.sql.Date;
import java.time.LocalDateTime;

public class UpdateLogActivityDto {
    private int id;
    private int idUser;
    private String ipAddress;
    private VeprimetEnum veprimi;
    private LocalDateTime data;


    public UpdateLogActivityDto(int id, String ipAddress, VeprimetEnum veprimi, LocalDateTime data) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.veprimi = veprimi;
        this.data = data;
    }


    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getIpAddress() { // Corrected return type from double to String
        return ipAddress;
    }

    public VeprimetEnum getVeprimi() {
        return veprimi;
    }

    public LocalDateTime getData() {
        return data;
    }


    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIpAddress(String ipAddress) { // Added setter for ipAddress
        this.ipAddress = ipAddress;
    }

    public void setVeprimi(VeprimetEnum veprimi) {
        this.veprimi = veprimi;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}

