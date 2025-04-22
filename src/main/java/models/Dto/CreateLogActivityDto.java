package models.Dto;

import models.enums.ActionEnum;
import models.enums.UserTypeEnum;

public class CreateLogActivityDto {
    private String clientUsername;
    private String staffUsername;
    private ActionEnum action;

    public CreateLogActivityDto(String clientUsername, String staffUsername, ActionEnum action) {
        this.clientUsername = clientUsername;
        this.staffUsername = staffUsername;
        this.action = action;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }
}