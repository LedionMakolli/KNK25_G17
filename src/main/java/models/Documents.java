package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Documents {
    private int id;
    private int idContract;
    private String type;
    private String path;
    private Date dataUpload;

    private Documents(int id, int idContract, String type, String path, Date dataUpload) {
        this.id = id;
        this.idContract = idContract;
        this.type = type;
        this.path = path;
        this.dataUpload = dataUpload;
    }

    public static Documents getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idContract = resultSet.getInt("idContract");
        String lloji = resultSet.getString("type");
        String type = resultSet.getString("path");
        Date dataUpload = resultSet.getDate("dataUpload");

        return new Documents(id, idContract, lloji, type, dataUpload);
    }

    public int getId() {
        return id;
    }

    public int getIdContract() {
        return idContract;
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }

    public Date getDataUpload() {
        return dataUpload;
    }

    public void printoTeDhenatPerDokumentin(){
        System.out.println("--------------------");
        System.out.println("ID: " + getId());
        System.out.println("IDKontrata: " + getIdContract());
        System.out.println("Lloji: " + getType());
        System.out.println("Path: " + getPath());
        System.out.println("DataUpload: " + getDataUpload());
        System.out.println("--------------------");
    }
}
