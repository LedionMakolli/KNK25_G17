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
    

}
