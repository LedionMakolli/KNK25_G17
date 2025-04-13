package models.Dto;


import java.sql.Date;

public class UpdatePromoCodeDto {
    private int id;
    private String kodi;
    private double zbritja;
    private Date dataSkadimit;
    private Boolean aktiv;

    public UpdatePromoCodeDto(int id, String kodi, double zbritja,Date dataSkadimit, Boolean aktiv){
        this.id=id;
        this.kodi=kodi;
        this.zbritja=zbritja;
        this.dataSkadimit=dataSkadimit;
        this.aktiv=aktiv;
    }

public int getId(){
        return id;
}
public Date getDataSkadimit(){
        return dataSkadimit;
}
public void setDataSkadimit(Date dataSkadimit){
        this.dataSkadimit=dataSkadimit;
}
public Boolean isAktiv(){
        return aktiv;
}
public void setAktiv(Boolean aktiv){
        this.aktiv=aktiv;
}
}
