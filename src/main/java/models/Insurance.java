package models;

import models.enums.InsuranceCompanyEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Insurance {
    private int id;
    private int idCar;
    private InsuranceCompanyEnum company;
    private Date startDate;
    private Date endDate;
    private double cost;


    private Insurance(int id, int idCar, InsuranceCompanyEnum company, Date startDate, Date endDate, double cost) {
        this.id = id;
        this.idCar = idCar;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public static Insurance getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idCar = resultSet.getInt("idCar");
        String companyStr = resultSet.getString("company");
        InsuranceCompanyEnum company = InsuranceCompanyEnum.valueOf(companyStr.toUpperCase());
        Date startDate = resultSet.getDate("startDate");
        Date endDate = resultSet.getDate("endDate");
        double cost = resultSet.getDouble("cost");
        return new Insurance(id, idCar, company, startDate, endDate, cost);
    }

    public int getId() {
        return id;
    }

    public int getIdCar() {
        return idCar;
    }

    public InsuranceCompanyEnum getCompany() {
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
        System.out.println("ID Insurance: " + getId());
        System.out.println("ID Car: " + getIdCar());
        System.out.println("Insurance company: " + getCompany());
        System.out.println("Registration Date: " + getStartDate());
        System.out.println("Expires: " + getEndDate());
        System.out.println("Insurance Cost: " + getCost() );

        System.out.println("----------------------------------------");
    }
}