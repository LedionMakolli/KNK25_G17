package models.Dto;

import models.enums.InsuranceCompanyEnum;

import java.util.Date;

public class CreateInsuranceDto {
    private int idCar;
    private InsuranceCompanyEnum company;
    private Date startDate;
    private Date endDate;
    private double cost;


    private CreateInsuranceDto(int id_sigurimi, int idCar, InsuranceCompanyEnum company, Date startDate, Date endDate, double cost) {
        this.idCar = idCar;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
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


public void setCompany(InsuranceCompanyEnum company){
    this.company = company;
}
    public void setIdCar(int idCar){
        this.idCar = idCar;
    }
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public void setCost(double cost){
        this.cost = cost;
    }
}



