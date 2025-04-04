package models;

import models.enums.Kompania;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Sigurimi {
    private int idSigurimi;
    private int idVetura;
    private Kompania kompania;
    private Date dataFillimit;
    private Date dataMbarimit;
    private double kosto;


    private Sigurimi(int idSigurimi, int idVetura, Kompania kompania, Date dataFillimit, Date dataMbarimit, double kosto) {
        this.idSigurimi = idSigurimi;
        this.idVetura = idVetura;
        this.kompania = kompania;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
        this.kosto = kosto;
    }

    public static Sigurimi getInstance(ResultSet resultSet) throws SQLException {
        int idSigurimi = resultSet.getInt("idSigurimi");
        int idVetura = resultSet.getInt("idVetura");
        String kompaniaStr = resultSet.getString("kompania");
        Kompania kompania = Kompania.valueOf(kompaniaStr.toUpperCase());
        Date dataFillimit = resultSet.getDate("dataFillimit");
        Date dataMbarimit = resultSet.getDate("dataMbarimit");
        double kosto = resultSet.getDouble("kosto");
        return new Sigurimi(id_sigurimi, id_vetura, kompania, data_fillimit, data_mbarimit, kosto);
    }

    public int getIdSigurimi() {
        return idSigurimi;
    }

    public int getIdvetura() {
        return idVetura;
    }

    public Kompania getKompania() {
        return kompania;
    }

    public Date getDataFillimit() {
        return dataFillimit;
    }

    public Date getDataMbarimit() {
        return dataMbarimit;
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