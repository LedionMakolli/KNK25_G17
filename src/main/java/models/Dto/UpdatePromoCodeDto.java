package models.Dto;


import java.sql.Date;

public class UpdatePromoCodeDto {
    private int id;
    private Date expiryDate;
    private Boolean active;

    public UpdatePromoCodeDto(int id,Date expiryDate, Boolean active){
        this.id=id;

        this.expiryDate=expiryDate;
        this.active=active;
    }

public int getId(){
        return id;
}

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
