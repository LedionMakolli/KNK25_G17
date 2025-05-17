package models;

import models.enums.StatusMaintenanceEnum;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Maintenance {
    private int id;
    private int idCar;
    private String description;
    private Date dateStart;
    private Date dateFinish;
    private BigDecimal cost;
    private StatusMaintenanceEnum status;
    private Integer idStaff;  // Integer per te lejuar NULL (nese fshihet punetori..)

    private Maintenance(int id, int idCar, String description, Date dateStart, Date dateFinish, BigDecimal cost, StatusMaintenanceEnum status, Integer idStaff) {
        this.id = id;
        this.idCar = idCar;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.cost = cost;
        this.status = status;
        this.idStaff = idStaff;
    }

    public static Maintenance getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idCar = resultSet.getInt("idCar");
        String description = resultSet.getString("description");
        Date dateStart = resultSet.getDate("dateStart");
        Date dateFinish = resultSet.getDate("dateFininsh");
        BigDecimal cost = resultSet.getBigDecimal("cost");
        StatusMaintenanceEnum status = StatusMaintenanceEnum.valueOf(resultSet.getString("status"));
        Integer idStaff = resultSet.getInt("idStaff");
        return new Maintenance(id,idCar,description,dateStart,dateFinish,cost,status,idStaff); // edhe dy ke me i shtu
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getIdCar() {
        return idCar;
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

    public void printoTeDhenatPerMirembajtjen(){
        System.out.println("-----------------------------");
        System.out.println("Detajet e Mirembajtjes");
        System.out.println("ID: " + id);
        System.out.println("Pershkrimi: " + description);
        System.out.println("Data fillimit: " + dateStart);
        System.out.println("Data mbarimit: " + dateFinish);
        System.out.println("Kosto: " + cost);
        System.out.println("Statusi: " + status);
        System.out.println("IdStafi: " + idStaff);
        System.out.println("-----------------------------");
    }
}
