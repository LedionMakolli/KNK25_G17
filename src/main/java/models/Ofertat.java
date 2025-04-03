package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ofertat {
    private int idOferta;
    private int idVetura;
    private double zbritja;
    private String dataFillimit;
    private String dataMbarimit;

    private Ofertat(int idOferta, int idVetura, double zbritja, String dataFillimit, String dataMbarimit) {
        this.idOferta = idOferta;
        this.idVetura = idVetura;
        this.zbritja = zbritja;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
    }

    public static Ofertat getInstance(ResultSet resultSet) throws SQLException {
        int idOferta = resultSet.getInt("idOferta");
        int idVetura = resultSet.getInt("idVetura");
        double zbritja = resultSet.getInt("zbritja");
        String dataFillimit = resultSet.getString("dataFillimit");
        String dataMbarimit = resultSet.getString("dataMbarimit");

        return new Ofertat(idOferta, idVetura, zbritja, dataFillimit, dataMbarimit);
    }

    public int getIdOferta() {
        return idOferta;
    }

    public int getIdVetura() {
        return idVetura;
    }

    public double getZbritja() {
        return zbritja;
    }

    public String getDataFillimit() {
        return dataFillimit;
    }

    public String getDataMbarimit() {
        return dataMbarimit;
    }

}
