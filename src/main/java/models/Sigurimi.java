package models;

import models.enums.Karburanti;
import models.enums.Kompania;
import models.enums.Statusi_Vetura;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Sigurimi {
    private int id_sigurimi;
    private int id_vetura;
    private Kompania kompania;
    private Date data_fillimit;
    private Date data_mbarimit;
    private double kosto;


    private Sigurimi(int id_sigurimi, int id_vetura, Kompania kompania, Date data_fillimit, Date data_mbarimit, double kosto) {
        this.id_sigurimi = id_sigurimi;
        this.id_vetura = id_vetura;
        this.kompania = kompania;
        this.data_fillimit = data_fillimit;
        this.data_mbarimit = data_mbarimit;
        this.kosto = kosto;
    }

    public static Sigurimi getInstance(ResultSet resultSet) throws SQLException {
        int id_sigurimi = resultSet.getInt("id_sigurimi");
        int id_vetura = resultSet.getInt("id_vetura");
        String kompaniaStr = resultSet.getString("kompania");
        Kompania kompania = Kompania.valueOf(kompaniaStr.toUpperCase());
        Date data_fillimit = resultSet.getDate("data_fillimit");
        Date data_mbarimit = resultSet.getDate("data_mbarimit");
        double kosto = resultSet.getDouble("kosto");
        return new Sigurimi(id_sigurimi, id_vetura, kompania, data_fillimit, data_mbarimit, kosto);
    }

    public int getIdSigurimi() {
        return id_sigurimi;
    }

    public int getIdvetura() {
        return id_vetura;
    }

    public Kompania getKompania() {
        return kompania;
    }

    public Date getDataFillimit() {
        return data_fillimit;
    }

    public Date getDataMbarimit() {
        return data_mbarimit;
    }

    public double getKosto() {
        return kosto;
    }

    public void printoTeDhenatPerSigurimineVetures() {
        System.out.println("----------------------------------------");
        System.out.println("Të dhënat e Sigurimit:");
        System.out.println("ID Sigurimi: " + getIdSigurimi());
        System.out.println("ID vetura: " + getIdvetura());
        System.out.println("Kompania e Sigurimit: " + getKompania());
        System.out.println("Data e Regjistrimit: " + getDataFillimit());
        System.out.println("Data e Skadimit: " + getDataMbarimit());
        System.out.println("Kosto e Sigurimit: " + getKosto() );

        System.out.println("----------------------------------------");
    }
}