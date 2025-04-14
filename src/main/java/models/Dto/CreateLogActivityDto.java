package models.Dto;

import models.enums.VeprimetEnum;
import java.time.LocalDateTime;

public class CreateLogActivityDto {
    private Integer idUser;
    private String userType; // Client or Staff
    private VeprimetEnum action;
    private LocalDateTime date;

    public CreateLogActivityDto(Integer idUser, String userType, VeprimetEnum action, LocalDateTime date) {
        this.idUser = idUser;
        this.userType = userType;
        this.action = action;
        this.date = date;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getUserType() {
        return userType;
    }

    public VeprimetEnum getAction() {
        return action;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setAction(VeprimetEnum action) {
        this.action = action;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}