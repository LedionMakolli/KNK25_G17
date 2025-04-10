package models.Dto;

import java.sql.Date;

public class CreateDokumentetDto {
    private int idKontrata;
    private String lloji;
    private String path;
    private Date dataUpload;

    public CreateDokumentetDto(int idKontrata, String lloji, String path, Date dataUpload) {
        this.idKontrata = idKontrata;
        this.lloji = lloji;
        this.path = path;
        this.dataUpload = dataUpload;
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

    public void setIdKontrata(int idKontrata) {
        this.idKontrata = idKontrata;
    }

    public void setLloji(String lloji) {
        this.lloji = lloji;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDataUpload(Date dataUpload) {
        this.dataUpload = dataUpload;
    }
}
