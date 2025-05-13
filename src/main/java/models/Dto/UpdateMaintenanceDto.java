package models.Dto;

import models.enums.StatusMaintenanceEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class UpdateMaintenanceDto {
    private int id;
    private int idCar;
    private String description;
    private Date dateStart;
    private Date dateFinish;
    private BigDecimal cost;
    private StatusMaintenanceEnum status;
    private Integer idStaff;


    public UpdateMaintenanceDto(int id, String description, Date dateStart, Date dateFininsh, BigDecimal cost, StatusMaintenanceEnum status) {
        this.id = id;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.cost = cost;
        this.status = status;
    }

    public int getId() {
        return id;
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

    public StatusMaintenanceEnum getStatus() {
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

    public void setDateFinish(Date dateFininsh) {
        this.dateFinish = dateFininsh;
    }

    public void setStatus(StatusMaintenanceEnum status) {
        this.status = status;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
