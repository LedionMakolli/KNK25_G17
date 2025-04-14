package models.Dto;


import models.enums.VeprimetEnum;

import java.time.LocalDateTime;

public class CreateLogActivityDto {
    private int id;
    private Integer idUser;
    private VeprimetEnum action;
    private LocalDateTime date;
    private String ipAddress;


    public CreateLogActivityDto(int id, Integer idUser, VeprimetEnum action, LocalDateTime date, String ipAddress) {
        this.id = id;
        this.idUser = idUser;
        this.action = action;
        this.date = date;
        this.ipAddress = ipAddress;
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


    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setAction(VeprimetEnum action) {
        this.action = action;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
