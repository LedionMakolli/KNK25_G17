package models.Dto;

import models.enums.PaymentEnum;

import java.sql.Date;

public class UpdateContractDto {
    private int id;
    private int idPayment;
    private int idReservation;
    private double sum;
    private Date date;

    public UpdateContractDto(int id, double sum,  Date date) {
        this.id = id;
        this.sum = sum;
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


    public Date getDate() {
        return date;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
