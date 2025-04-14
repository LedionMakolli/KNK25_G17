package models.Dto;

import java.util.Date;

public class UpdateInsuranceDto {
int idInsurance;
Date startDate;
Date endDate;
double cost;


    private UpdateInsuranceDto(int idInsurance, Date startDate, Date endDate, double cost) {

        this.idInsurance = idInsurance;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public int getIDInsurance() {
        return idInsurance;
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

    public void setIDInsurance(int idInsurance){
        this.idInsurance =idInsurance;
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
