package models.Dto;

import java.time.LocalDate;

public class UpdatePromoCodeDto {
    private int id;
    private String kodi;
    private double zbritja;
    private LocalDate dataSkadimit;
    private Boolean aktiv;

    public UpdatePromoCodeDto(int id, String kodi, double zbritja,LocalDate dataSkadimit, Boolean aktiv){
        this.id=id;
        this.kodi=kodi;
        this.zbritja=zbritja;
        this.dataSkadimit=dataSkadimit;
        this.aktiv=aktiv;
    }

public int getId(){
        return id;
}
public LocalDate getDataSkadimit(){
        return dataSkadimit;
}
public void setDataSkadimit(LocalDate dataSkadimit){
        this.dataSkadimit=dataSkadimit;
}
public Boolean isAktiv(){
        return aktiv;
}
public void setAktiv(Boolean aktiv){
        this.aktiv=aktiv;
}
}
