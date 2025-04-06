package models.Dto;

import java.sql.Date;

public class CreateDokumentetDto {
    private int id;
    private int idKontrata;
    private String lloji;
    private String path;
    private Date dataUpload;

    public CreateDokumentetDto(int id, int idKontrata, String lloji, String path, Date dataUpload) {
        this.id = id;
        this.idKontrata = idKontrata;
        this.lloji = lloji;
        this.path = path;
        this.dataUpload = dataUpload;
    }

    public int getIdDokument() {
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
