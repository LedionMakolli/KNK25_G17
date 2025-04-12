package models;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Penalties {
    private int id;
    private int reservationId;
    private String reasonOfPenalty;
    private BigDecimal moneyAmount;
    private LocalDateTime date;
    private boolean paid;

    private Penalties(int id, int reservationId, String reasonOfPenalty, BigDecimal moneyAmount, LocalDateTime date, boolean paid) {
        this.id=id;
        this.reservationId = reservationId;
        this.reasonOfPenalty = reasonOfPenalty;
        this.moneyAmount = moneyAmount;
        this.paid = paid;
        this.date = date;
    }
    public static Penalties getInstance(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id");
        int reservationId=resultSet.getInt("reservationid");
        String reasonOfPenalty=resultSet.getString("reasonofpenalty");
        BigDecimal moneyAmount=resultSet.getBigDecimal("moneyamount");
        Timestamp timestamp=resultSet.getTimestamp("data");
        LocalDateTime date=timestamp.toLocalDateTime();
        boolean paid=resultSet.getBoolean("paguar");

        return new Penalties(id,reservationId,reasonOfPenalty,moneyAmount,date,paid);
    }

    public int getId() {
        return id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getReasonOfPenalty() {
        return reasonOfPenalty;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isPaid() {
        return paid;
    }
    public void printoTeDhenatPerPenalizimin() {
        System.out.println("----------------------------------------");
        System.out.println("Detajet e penalizimit: ");
        System.out.println("ID: " + getId());
        System.out.println("ID e rezervimit: " + getReservationId());
        System.out.println("Arsyeja: " + getReasonOfPenalty());
        System.out.println("Shuma: " + getMoneyAmount() + " €");
        System.out.println("Data: " + getDate());
        System.out.println("Paguar: " + (isPaid() ? "Po" : "Jo"));
        System.out.println("----------------------------------------");
    }

}
