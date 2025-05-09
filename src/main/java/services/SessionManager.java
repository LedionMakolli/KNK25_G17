package services;

import models.Clients;
import models.Staff;

public class SessionManager<T> {
    private static SessionManager sessionManager;
    private Clients currentClient;
    private Staff currentStaff;
    private String theme;

    private SessionManager(){
        this.theme = "white-theme";
    }
    public static SessionManager getInstance(){
        if(sessionManager == null){
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void loginClient(Clients client){
        this.currentClient = client;
        this.currentStaff = null;
    }

    public void loginStaff(Staff staff){
        this.currentStaff = staff;
        this.currentClient = null;
    }

    public Clients getCurrentClient(){
        return currentClient;
    }

    public Staff getCurrentStaff(){
        return currentStaff;
    }

    public String getCurrentUsername(){
        return currentClient != null ? currentClient.getUsername() : currentStaff.getUsername();
    }

    public String getCurrentRole(){
        return currentClient != null ? "client" : "staff";
    }

    public void setTheme(String theme){
        this.theme = theme;
    }

    public String getTheme(){
        return this.theme;
    }

}
