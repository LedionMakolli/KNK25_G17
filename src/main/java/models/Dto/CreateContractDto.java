package models.Dto;

import models.enums.PaymentEnum;

import java.sql.Date;

public class CreateContractDto {
    private int id;
    private int idReservation;
    private double sum;
    private PaymentEnum payment;
    private Date date;

    public CreateContractDto(int id, int idReservation, double sum, PaymentEnum payment, Date date) {
        this.id = id;
        this.idReservation = idReservation;
        this.sum = sum;
        this.payment = payment;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public double getSum() {
        return sum;
    }

    public PaymentEnum getPayment() {
        return payment;
    }

    public Date getDate() {
        return date;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setPayment(PaymentEnum payment) {
        this.payment = payment;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
