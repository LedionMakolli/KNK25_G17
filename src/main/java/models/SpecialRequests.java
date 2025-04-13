package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialRequests {
    private int id;
    private int idReservation;
    private String request;
    private Boolean completed;

    private SpecialRequests(int id, int idReservation, String request, Boolean completed){
        this.id=id;
        this.idReservation=idReservation;
        this.request=request;
        this.completed=completed;
    }
    public static SpecialRequests getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idReservation = resultSet.getInt("idReservation");
        String request = resultSet.getString("request");
        Boolean completed = resultSet.getBoolean("completed");

        return new SpecialRequests(id, idReservation,request, completed );
    }
    public int getId(){
        return id;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public String getRequest() {
        return request;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void printoTeDhenatKerkesaSpeciale(){
        System.out.println("Detajet e Kerkesave Speciale: ");
        System.out.println("ID: "+ getId());
        System.out.println("IDRezerimet: " + getIdReservation());
        System.out.println("Kerkesa: " + getRequest());
        System.out.println("Plotesuar: " + getCompleted());
    }
}
