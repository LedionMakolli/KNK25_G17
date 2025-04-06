package models.Dto;

import java.time.LocalDate;

public class UpdatePromoCodeDto {
    private int id;
    private LocalDate dataSkadimit;
    private Boolean aktiv;

    public UpdatePromoCodeDto(int id, LocalDate dataSkadimit, Boolean aktiv){
        this.id=id;
        this.dataSkadimit=dataSkadimit;
        this.aktiv=aktiv;
    }
    public UpdatePromoCodeDto(){}
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
