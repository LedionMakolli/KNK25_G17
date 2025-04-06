package models.Dto;

import models.enums.StatusiMirembatjaEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class UpdateDokumentetDto {
    private int id;
    private int idKontrata;
    private String lloji;
    private String path;
    private Date dataUpload;

    public UpdateDokumentetDto(int id, String lloji, String path, Date dataUpload) {
        this.id = id;
        this.lloji = lloji;
        this.path = path;
        this.dataUpload = dataUpload;
    }

    public int getId() {
        return id;
    }

    public int getIdKontrata() {
        return idKontrata;
    }

    public String getLloji() {
        return lloji;
    }

    public String getPath() {
        return path;
    }

    public Date getDataUpload() {
        return dataUpload;
    }
}
