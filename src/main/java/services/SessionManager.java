package services;

import models.Cars;
import models.Clients;
import models.Staff;

public class SessionManager {
    private static SessionManager sessionManager;
    private String currentRole;
    private Clients currentClient;
    private Staff currentStaff;


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
    public void setCurrentClient(Clients currentClient){
        this.currentClient = currentClient;
    }

    public Staff getCurrentStaff(){
        return currentStaff;
    }

    public void setCurrentStaff(Staff currentStaff){
        this.currentStaff = currentStaff;
    }

    public String getCurrentUsername(){
        return currentClient != null ? currentClient.getUsername() : currentStaff.getUsername();
    }

    public String getCurrentRole(){
        return currentClient != null ? "client" : "staff";
    }

    public void setCurrentRole(String role){
        this.currentRole = role;
    }

    public boolean isClient() {
        return "client".equals(getCurrentRole());
    }

    public boolean isStaff() {
        return "staff".equals(getCurrentRole());
    }

    public boolean isLoggedIn() {
        return currentClient != null || currentStaff != null;
    }

    private Cars selectedCar;

    public void setSelectedCar(Cars car) {
        this.selectedCar = car;
    }

    public Cars getSelectedCar() {
        return selectedCar;
    }

}
