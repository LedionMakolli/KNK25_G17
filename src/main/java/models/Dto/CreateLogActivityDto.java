package models.Dto;

import java.time.LocalDateTime;

public class CreateLogActivityDto {
    private Integer idUser;
    private String userType; // Client or Staff
    private static final String action="Log In";
    private LocalDateTime date;

    public CreateLogActivityDto(Integer idUser, String userType, LocalDateTime date) {
        this.idUser = idUser;
        this.userType = userType;
        this.date = date;
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

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}