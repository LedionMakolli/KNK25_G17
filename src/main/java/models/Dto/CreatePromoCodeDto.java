package models.Dto;


import java.math.BigDecimal;
import java.sql.Date;

public class CreatePromoCodeDto {
    private String code;
    private BigDecimal discount;
    private Date expiryDate;
    private Boolean active;
    public CreatePromoCodeDto(String code, BigDecimal discount, Date expiryDate, Boolean active){
        this.code=code;
        this.discount=discount;
        this.expiryDate=expiryDate;
        this.active=active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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
