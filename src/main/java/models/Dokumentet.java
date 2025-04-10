package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dokumentet {
    private int id;
    private int idKontrata;
    private String lloji;
    private String path;
    private Date dataUpload;

    private Dokumentet(int id, int idKontrata, String lloji, String path, Date dataUpload) {
        this.id = id;
        this.idKontrata = idKontrata;
        this.lloji = lloji;
        this.path = path;
        this.dataUpload = dataUpload;
    }

    public static Dokumentet getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idKontrata = resultSet.getInt("idKontrata");
        String lloji = resultSet.getString("lloji");
        String path = resultSet.getString("path");
        Date dataUpload = resultSet.getDate("dataUpload");

        return new Dokumentet(id, idKontrata, lloji, path, dataUpload);
    }

    public int getId() {
        return id;
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

    public void printoTeDhenatPerDokumentin(){
        System.out.println("--------------------");
        System.out.println("ID: " + getId());
        System.out.println("IDKontrata: " + getIdKontrata());
        System.out.println("Lloji: " + getLloji());
        System.out.println("Path: " + getPath());
        System.out.println("DataUpload: " + getDataUpload());
        System.out.println("--------------------");
    }
}
