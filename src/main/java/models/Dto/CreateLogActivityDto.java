package models.Dto;


import models.enums.VeprimetEnum;

import java.sql.Date;
import java.time.LocalDateTime;

public class CreateLogActivityDto {
    private int id;
    private int idUser;
    private VeprimetEnum veprimi;
    private LocalDateTime data;
    private String ipAddress;


    public CreateLogActivityDto(int id, int idUser, VeprimetEnum veprimi, LocalDateTime data, String ipAddress) {
        this.id = id;
        this.idUser = idUser;
        this.veprimi = veprimi;
        this.data = data;
        this.ipAddress = ipAddress;
    }


    public int getId() {
        return id;
    }

    public int getIdUser() {
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


    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setVeprimi(VeprimetEnum veprimi) {
        this.veprimi = veprimi;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
