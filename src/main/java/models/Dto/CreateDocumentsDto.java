package models.Dto;

import java.sql.Date;

public class CreateDocumentsDto {
    private int idContract;
    private String type;
    private String path;
    private Date dataUpload;

    public CreateDocumentsDto(int idContract, String type, String path, Date dataUpload) {
        this.idContract = idContract;
        this.type = type;
        this.path = path;
        this.dataUpload = dataUpload;
    }


    public int getIdContract() {
        return idContract;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public Date getDataUpload() {
        return dataUpload;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDataUpload(Date dataUpload) {
        this.dataUpload = dataUpload;
    }
}
