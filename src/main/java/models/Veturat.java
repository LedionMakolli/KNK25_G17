package models;

import models.enums.Karburanti;
import models.enums.Statusi_Vetura;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Veturat {
    private int id_vetura;
    private String targat;
    private String modeli;
    private String ngjyra;
    private int viti_prodhimit;
    private int kilometrazha;
    private int kapaciteti;
    private Karburanti karburanti;
    private int cmimi_ditor;
    private Statusi_Vetura statusi;

    private Veturat(int id_vetura, String targat, String modeli, String ngjyra,
                   int viti_prodhimit, int kilometrazha, int kapaciteti, Karburanti karburanti, int cmimi_ditor, Statusi_Vetura statusi) {
        this.id_vetura = id_vetura;
        this.targat = targat;
        this.modeli = modeli;
        this.ngjyra = ngjyra;
        this.viti_prodhimit = viti_prodhimit;
        this.kilometrazha = kilometrazha;
        this.kapaciteti=kapaciteti;
        this.karburanti = karburanti;
        this.cmimi_ditor = cmimi_ditor;
        this.statusi = statusi;
    }
    public static Veturat getInstance(ResultSet resultSet) throws SQLException {
        int id_vetura=resultSet.getInt("id_vetura");
        String targat=resultSet.getString("targat");
        String modeli=resultSet.getString("modeli");
        String ngjyra=resultSet.getString("ngjyra");
        int viti_prodhimit=resultSet.getInt("viti_prodhimit");
        int kilometrazha=resultSet.getInt("kilometrazha");
        int kapaciteti=resultSet.getInt("kapaciteti");
        String karburantiStr = resultSet.getString("karburanti");
        Karburanti karburanti = Karburanti.valueOf(karburantiStr.toUpperCase());
        int cmimi_ditor=resultSet.getInt("cmimi_ditor");
        String statusiStr = resultSet.getString("statusi");
        Statusi_Vetura statusi = Statusi_Vetura.valueOf(statusiStr.toUpperCase());
        return new Veturat(id_vetura,targat,modeli,ngjyra,viti_prodhimit,kilometrazha,kapaciteti,karburanti, cmimi_ditor, statusi);
    }

    public int getId_vetura() {
        return id_vetura;
    }

    public String getTargat() {
        return targat;
    }

    public String getModeli() {
        return modeli;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public int getViti_prodhimit() {
        return viti_prodhimit;
    }

    public int getKilometrazha() {
        return kilometrazha;
    }

    public int getKapaciteti() {
        return kapaciteti;
    }

    public Karburanti getKarburanti() {
        return karburanti;
    }

    public int getCmimi_ditor() {
        return cmimi_ditor;
    }

    public Statusi_Vetura getStatusi() {
        return statusi;
    }
}
