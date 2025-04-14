package models.Dto;

import models.enums.StatusiMaintenanceEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class CreateMaintenanceDto {
    private int idCar;
    private String description;
    private Date dateStart;
    private Date dateFinish;
    private BigDecimal cost;
    private StatusiMaintenanceEnum status;
    private Integer idStaff;

    public CreateMaintenanceDto(int idCar, Date dateStart, String description, Date dateFinish, BigDecimal cost, StatusiMaintenanceEnum status, Integer idStaff) {
        this.idCar = idCar;
        this.dateStart = dateStart;
        this.description = description;
        this.dateFinish = dateFinish;
        this.cost = cost;
        this.status = status;
        this.idStaff = idStaff;
    }

    public int getIdCar() {
        return idCar;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public StatusiMaintenanceEnum getStatus() {
        return status;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setStatus(StatusiMaintenanceEnum status) {
        this.status = status;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }
}
