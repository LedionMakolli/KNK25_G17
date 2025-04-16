package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Contract {
    private int id;
    private int idPayment;
    private int idReservation;
    private double sum;
    private String date;


    private Contract(int id, int idPayment, int idReservation, double sum, String date) {
        this.id = id;
        this.idPayment = idPayment;
        this.idReservation = idReservation;
        this.sum = sum;
        this.date = date;
    }

    public static Contract getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idPagesa = resultSet.getInt("idPayment");
        int idReservation = resultSet.getInt("idReservation");
        double sum = resultSet.getDouble("sum");
        String data = resultSet.getString("date");
        return new Contract(id,idPagesa, idReservation, sum, data);
    }

    public int getId() {
        return id;
    }


    public double getSum() {
        return sum;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public int getIdReservation() {
        return idReservation;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {return date;}

    public void printoTeDhenatPerKontraten(){
        System.out.println("----------------------------------------");
        System.out.println("Detajet e Kontrates");
        System.out.println("ID: " + getId());
        System.out.println("ID Pagesa: " + getIdPayment());
        System.out.println("ID rezervimi: " + getIdReservation());
        System.out.println("Shuma: " + getSum() + "€");
        System.out.println("Data: " + getDate());
        System.out.println("----------------------------------------");
    }
}
