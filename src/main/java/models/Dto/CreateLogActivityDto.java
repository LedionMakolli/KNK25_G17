package models.Dto;

public class CreateLogActivityDto {
    private String clientUsername;
    private String staffUsername;
    private String action; // Ndryshuar në String

    public CreateLogActivityDto(String clientUsername, String staffUsername, String action) {
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
