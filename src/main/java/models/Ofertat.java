package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ofertat {
    private int id;
    private int idVetura;
    private double zbritja;
    private Date dataFillimit;
    private Date dataMbarimit;

    private Ofertat(int id, int idVetura, double zbritja, Date dataFillimit, Date dataMbarimit) {
        this.id = id;
        this.idVetura = idVetura;
        this.zbritja = zbritja;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
    }

    public static Ofertat getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idVetura = resultSet.getInt("idVetura");
        double zbritja = resultSet.getDouble("zbritja");
        Date dataFillimit = resultSet.getDate("dataFillimit");
        Date dataMbarimit = resultSet.getDate("dataMbarimit");

        return new Ofertat(id, idVetura, zbritja, dataFillimit, dataMbarimit);
    }

    public int getId() {
        return id;
    }

    public int getIdVetura() {
        return idVetura;
    }

    public double getZbritja() {
        return zbritja;
    }

    public Date getDataFillimit() {
        return dataFillimit;
    }

    public Date getDataMbarimit() {
        return dataMbarimit;
    }

}
