package models.Dto;

import models.enums.ReservationStatusEnum;

import java.sql.Date;

public class UpdateReservationsDto {
    private int id;
    private int idCar;
    private Date startDate;
    private Date endDate;
    private ReservationStatusEnum reservationStatus;

    public UpdateReservationsDto(int id, int idCar, Date startDate, Date endDate, ReservationStatusEnum reservationStatus){
        this.id=id;
        this.idCar = idCar;
        this.startDate = startDate;
        this.endDate= endDate;
        this.reservationStatus  = reservationStatus;
    }
 public UpdateReservationsDto(){}


    public int getId() {
        return id;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ReservationStatusEnum getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatusEnum reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
