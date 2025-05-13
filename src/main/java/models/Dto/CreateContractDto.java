package models.Dto;

import models.enums.PaymentEnum;

import java.sql.Date;

public class CreateContractDto {
    private int idPayment;
    private int idReservation;
    private double sum;
    private Date date;

    public CreateContractDto(int idPayment,int idReservation, double sum, Date date) {
        this.idReservation = idReservation;
        this.idPayment = idPayment;
        this.sum = sum;
        this.date = date;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
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

    public void setDate(Date date) {
        this.date = date;
    }
}
