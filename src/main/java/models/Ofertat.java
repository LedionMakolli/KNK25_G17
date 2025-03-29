package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ofertat {
    private int id_oferta;
    private int id_vetura;
    private double zbritja;
    private String data_fillimit;
    private String data_mbarimit;

    private Ofertat(int id_oferta, int id_vetura, double zbritja, String data_fillimit, String data_mbarimit) {
        this.id_oferta = id_oferta;
        this.id_vetura = id_vetura;
        this.zbritja = zbritja;
        this.data_fillimit = data_fillimit;
        this.data_mbarimit = data_mbarimit;
    }

    public static Ofertat getInstance(ResultSet resultSet) throws SQLException {
        int id_oferta = resultSet.getInt("id_oferta");
        int id_vetura = resultSet.getInt("id_vetura");
        double zbritja = resultSet.getInt("zbritja");
        String data_fillimit = resultSet.getString("data_fillimit");
        String data_mbarimit = resultSet.getString("data_mbarimit");

        return new Ofertat(id_oferta, id_vetura, zbritja, data_fillimit, data_mbarimit);
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public int getId_vetura() {
        return id_vetura;
    }

    public double getZbritja() {
        return zbritja;
    }

    public String getData_fillimit() {
        return data_fillimit;
    }

    public String getData_mbarimit() {
        return data_mbarimit;
    }

}
