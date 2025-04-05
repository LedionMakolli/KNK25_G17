package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dokumentet {
    private int idDokument;
    private int idKontrata;
    private String lloji;
    private String path;
    private Date dataUpload;

    private Dokumentet(int idDokument, int idKontrata, String lloji, String path, Date dataUpload) {
        this.idDokument = idDokument;
        this.idKontrata = idKontrata;
        this.lloji = lloji;
        this.path = path;
        this.dataUpload = dataUpload;
    }

    public Dokumentet getInstance(ResultSet resultSet) throws SQLException {
        int idDokument = resultSet.getInt("idDokument");
        int idKontrata = resultSet.getInt("idKontrata");
        String lloji = resultSet.getString("lloji");
        String path = resultSet.getString("path");
        Date dataUpload = resultSet.getDate("dataUpload");

        return new Dokumentet(idDokument, idKontrata, lloji, path, dataUpload);
    }

    public int getIdDokument() {
        return idDokument;
    }

    public int getIdKontrata() {
        return idKontrata;
    }

    public String getPath() {
        return path;
    }

    public String getLloji() {
        return lloji;
    }

    public Date getDataUpload() {
        return dataUpload;
    }
}
