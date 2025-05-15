package models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PromoCode {
    private int id;
    private String code;
    private BigDecimal discount;
    private Date expiryDate;
    private Boolean active;

    private PromoCode(int id,String code, BigDecimal discount, Date expiryDate, Boolean active){
        this.id=id;
        this.code=code;
        this.discount=discount;
        this.expiryDate=expiryDate;
        this.active=active;
    }
    public static PromoCode getInstance(ResultSet resultSet) throws SQLException{
        int id=resultSet.getInt("id");
        String code=resultSet.getString("code");
        BigDecimal discount = resultSet.getBigDecimal("discount");
        Date expiryDate= resultSet.getDate("expiryDate");
        Boolean active = resultSet.getBoolean("active");

        return new PromoCode(id, code, discount, expiryDate, active);
    }
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Boolean getActive() {
        return active;
    }

    public BigDecimal applyDiscount(BigDecimal amount){
        BigDecimal discountFraction = discount.divide(BigDecimal.valueOf(100));
        BigDecimal multiplier = BigDecimal.ONE.subtract(discountFraction);
        return amount.multiply(multiplier);
    }

    public void printPromoCode(){
        System.out.println("Te dhenat per PromoCode");
        System.out.println("ID: " + getId());
        System.out.println("Kodi: " + getCode());
        System.out.println("Zbritja:" + getDiscount());
        System.out.println("Data e skadimit: " + getExpiryDate());
        System.out.println("Aktiv: " + getActive());
    }
}


