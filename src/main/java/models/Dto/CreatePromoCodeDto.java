package models.Dto;


import java.sql.Date;

public class CreatePromoCodeDto {
    private String kodi;
    private double zbritja;
    private Date dataSkadimit;
    private Boolean aktiv;
    public CreatePromoCodeDto(String kodi, double zbritja, Date dataSkadimit, Boolean aktiv){
        this.kodi=kodi;
        this.zbritja=zbritja;
        this.dataSkadimit=dataSkadimit;
        this.aktiv=aktiv;
    }
    public String getKodi(){
        return kodi;
    }
    public void setKodi(String kodi){
        this.kodi=kodi;
    }
    public double getZbritja(){
        return zbritja;
    }
    public void setZbritja(double zbritja){
        this.zbritja=zbritja;
    }
    public Date getDataSkadimit(){
        return dataSkadimit;
    }
    public void setDataSkadimit(Date dataSkadimit){
        this.dataSkadimit= dataSkadimit;
    }
    public Boolean isAktiv(){
        return aktiv;
    }
    public void setAktiv(Boolean aktiv){
        this.aktiv=aktiv;
    }
}
