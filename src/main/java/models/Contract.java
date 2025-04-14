package models;

import models.enums.PaymentEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Contract {
    private int id;
    private int idReservation;
    private double sum;
    private PaymentEnum payment;
    private String date;

    private Contract(int id, int idReservation, double sum, PaymentEnum payment, String date) {
        this.id = id;
        this.idReservation = idReservation;
        this.sum = sum;
        this.payment = payment;
        this.date = date;
    }

    public static Contract getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idReservation = resultSet.getInt("idReservation");
        double sum = resultSet.getDouble("sum");
        String paymemntStr = resultSet.getString("payment");
        PaymentEnum paymemnt = PaymentEnum.valueOf(paymemntStr.toUpperCase());
        String data = resultSet.getString("date");
        return new Contract(id, idReservation, sum, paymemnt, data);
    }

    public int getId() {
        return id;
    }

    public int getIdrezervimet() {
        return idReservation;
    }

    public double getSum() {
        return sum;
    }

    public PaymentEnum getPayment() {
        return payment;
    }

    public String getDate() {return date;}

    public void printoTeDhenatPerKontraten(){
        System.out.println("----------------------------------------");
        System.out.println("Detajet e Kontrates");
        System.out.println("ID: " + getId());
        System.out.println("ID rezervimi: " + getIdrezervimet());
        System.out.println("Shuma: " + getSum() + "€");
        System.out.println("Pagesa: " + getPayment());
        System.out.println("Data: " + getDate());
        System.out.println("----------------------------------------");
    }
}
