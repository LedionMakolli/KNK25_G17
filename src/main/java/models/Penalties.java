package models;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Penalties {
    private int id;
    private int idRezervimet;
    private String arsyeja;
    private BigDecimal shuma;
    private LocalDateTime data;
    private boolean paguar;

    private Penalties(int id, int idRezervimet, String arsyeja, BigDecimal shuma, LocalDateTime data, boolean paguar) {
        this.id=id;
        this.idRezervimet = idRezervimet;
        this.arsyeja = arsyeja;
        this.shuma = shuma;
        this.paguar = paguar;
        this.data = data;
    }
    public static Penalties getInstance(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id");
        int idRezervimet=resultSet.getInt("idrezervimet");
        String arsyeja=resultSet.getString("arsyeja");
        BigDecimal shuma=resultSet.getBigDecimal("shuma");
        Timestamp timestamp=resultSet.getTimestamp("data");
        LocalDateTime data=timestamp.toLocalDateTime();
        boolean paguar=resultSet.getBoolean("paguar");

        return new Penalties(id,idRezervimet,arsyeja,shuma,data,paguar);
    }

    public int getId() {
        return id;
    }

    public int getIdRezervimet() {
        return idRezervimet;
    }

    public String getArsyeja() {
        return arsyeja;
    }

    public BigDecimal getShuma() {
        return shuma;
    }

    public LocalDateTime getData() {
        return data;
    }

    public boolean isPaguar() {
        return paguar;
    }
    public void printoTeDhenatPerPenalizimin() {
        System.out.println("----------------------------------------");
        System.out.println("Detajet e penalizimit: ");
        System.out.println("ID: " + getId());
        System.out.println("ID e rezervimit: " + getIdRezervimet());
        System.out.println("Arsyeja: " + getArsyeja());
        System.out.println("Shuma: " + getShuma() + " €");
        System.out.println("Data: " + getData());
        System.out.println("Paguar: " + (isPaguar() ? "Po" : "Jo"));
        System.out.println("----------------------------------------");
    }

}
