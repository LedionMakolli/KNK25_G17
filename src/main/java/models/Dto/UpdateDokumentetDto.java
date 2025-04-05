package models.Dto;

import models.enums.StatusiMirembatjaEnum;

import java.math.BigDecimal;
import java.sql.Date;

public class UpdateDokumentetDto {
    private int idDokument;
    private int idKontrata;
    private String lloji;
    private String path;
    private Date dataUpload;

    public UpdateDokumentetDto(int idDokument, String lloji, String path, Date dataUpload) {
        this.idDokument = idDokument;
        this.lloji = lloji;
        this.path = path;
        this.dataUpload = dataUpload;
    }

    public int getIdDokument() {
        return idDokument;
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
