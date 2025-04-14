package models;

import models.enums.ReservationStatusEnum;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservations {
    private int id;
    private int idClient;
    private int idCar;
    private Date startDate;   //LocalDate
    private Date endDate;
    private ReservationStatusEnum reservationStatus; //mundemi me shtu vetine created_at per kohen e sakte kur eshte shtuar rreshti tek rezervimet


private Reservations(int id, int idClient, int idCar, Date startDate, Date endDate, ReservationStatusEnum reservationStatus){
    this.id=id;
    this.idClient=idClient;
    this.idCar=idCar;
    this.startDate=startDate;
    this.endDate=endDate;
    this.reservationStatus=reservationStatus;
}
public static Reservations getInstance(ResultSet resultSet) throws SQLException {
int id=resultSet.getInt("id");
int idClient=resultSet.getInt("idClient");
int idCar=resultSet.getInt("idCar");
Date startDate=resultSet.getDate("startDate");
Date endDate =resultSet.getDate("endDate");
String statusString=resultSet.getString("reservationStatus");

ReservationStatusEnum reservationStatus= ReservationStatusEnum.valueOf(statusString.toUpperCase());



return new Reservations(id, idClient, idCar, startDate, endDate, reservationStatus);
}

    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdCar() {
        return idCar;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ReservationStatusEnum getReservationStatus() {
        return reservationStatus;
    }

    public void printoTeDhenatRezervimet(){
    System.out.println("ID_Rezervimet: " + getId());
    System.out.println("ID_Klienti: " + getIdClient());
    System.out.println("ID_Vetura: " + getIdCar());
    System.out.println("Data_Fillimit: " + getStartDate());
    System.out.println("Data_Mbarimit: " + getEndDate());
    System.out.println("Statusi: " + getReservationStatus());
    System.out.println("-------------------------------");
    }
}
