package models.Dto;

import models.enums.ActionEnum;
import models.enums.UserTypeEnum;

public class CreateLogActivityDto {
    private Integer idUser;
    private UserTypeEnum userType; // Client or Staff
    private ActionEnum action;

    public CreateLogActivityDto(Integer idUser, UserTypeEnum userType, ActionEnum action) {
        this.idUser = idUser;
        this.userType = userType;
        this.action=action;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }
}