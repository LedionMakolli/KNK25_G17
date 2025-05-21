package models.Dto;

import java.util.Date;

public class UpdateInsuranceDto {
int id;
Date startDate;
Date endDate;
double cost;


    private UpdateInsuranceDto(int id, Date startDate, Date endDate, double cost) {

        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public int getId() {
        return id;
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

    public void setId(int id){
        this.id =id;
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
