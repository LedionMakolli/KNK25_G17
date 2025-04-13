package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PromoCode {
    private int id;
    private String kodi;
    private double zbritja;
    private Date dataSkadimit;
    private Boolean aktiv;

    private PromoCode(int id,String kodi, double zbritja, Date dataSkadimit, Boolean aktiv){
        this.id=id;
        this.kodi=kodi;
        this.zbritja=zbritja;
        this.dataSkadimit=dataSkadimit;
        this.aktiv=aktiv;
    }
    public static PromoCode getInstance(ResultSet resultSet) throws SQLException{
        int id=resultSet.getInt("id");
        String kodi=resultSet.getString("kodi");
        double zbritja = resultSet.getDouble("zbritja");
        Date dataSkadimit= resultSet.getDate("dataSkadimit");
        Boolean aktiv = resultSet.getBoolean("aktiv");

        return new PromoCode(id, kodi, zbritja, dataSkadimit, aktiv);
    }
    public int getId(){
        return id;
    }
    public String getKodi(){
        return kodi;
    }
    public double getZbritja(){
        return zbritja;
    }
    public Date getDataSkadimit(){
        return dataSkadimit;
    }
    public Boolean getAktiv(){
        return aktiv;
    }
    public void printPromoCode(){
        System.out.println("Te dhenat per PromoCode");
        System.out.println("ID: " + getId());
        System.out.println("Kodi: " + getKodi());
        System.out.println("Zbritja:" + getZbritja());
        System.out.println("Data e skadimit: " + getDataSkadimit());
        System.out.println("Aktiv: " + getAktiv());
    }
}
