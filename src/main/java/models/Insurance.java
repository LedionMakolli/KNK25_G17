package models;

import models.enums.KompaniaEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Insurance {
    private int idInsurance;
    private int idCar;
    private KompaniaEnum company;
    private Date startDate;
    private Date endDate;
    private double cost;


    private Insurance(int idInsurance, int idCar, KompaniaEnum company, Date startDate, Date endDate, double cost) {
        this.idInsurance = idInsurance;
        this.idCar = idCar;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public static Insurance getInstance(ResultSet resultSet) throws SQLException {
        int idInsurance = resultSet.getInt("idInsurance");
        int idCar = resultSet.getInt("idCar");
        String companyStr = resultSet.getString("company");
        KompaniaEnum company = KompaniaEnum.valueOf(companyStr.toUpperCase());
        Date startDate = resultSet.getDate("startDate");
        Date endDate = resultSet.getDate("endDate");
        double cost = resultSet.getDouble("cost");
        return new Insurance(idInsurance, idCar, company, startDate, endDate, cost);
    }

    public int getIdInsurance() {
        return idInsurance;
    }

    public int getIdvetura() {
        return idCar;
    }

    public KompaniaEnum getCompany() {
        return company;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getCost() {
        return cost;
    }

    public void printoTeDhenatPerSigurimineVetures() {
        System.out.println("----------------------------------------");
        System.out.println("Insurance information:");
        System.out.println("ID Insurance: " + getIdInsurance());
        System.out.println("ID Car: " + getIdvetura());
        System.out.println("Insurance company: " + getCompany());
        System.out.println("Registration Date: " + getStartDate());
        System.out.println("Expires: " + getEndDate());
        System.out.println("Insurance Cost: " + getCost() );

        System.out.println("----------------------------------------");
    }
}