package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Offers {
    private int id;
    private int carId;
    private double discount;
    private Date startDate;
    private Date endDate;

    private Offers(int id, int carId, double discount, Date startDate, Date endDate) {
        this.id = id;
        this.carId = carId;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Offers getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int carId = resultSet.getInt("idCar");
        double discount = resultSet.getDouble("discount");
        Date startDate = resultSet.getDate("startDate");
        Date endDate = resultSet.getDate("endDate");

        return new Offers(id, carId, discount, startDate, endDate);
    }

    public int getId() {
        return id;
    }

    public int getCarId() {
        return carId;
    }

    public double getDiscount() {
        return discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    private static void printOfferDetails(Offers offer) {
        System.out.println("---------------------------------");
        System.out.println("Offer ID: " + offer.getId());
        System.out.println("Car ID: " + offer.getCarId());
        System.out.println("Discount: " + offer.getDiscount() + "%");
        System.out.println("Start Date: " + offer.getStartDate());
        System.out.println("End Date: " + offer.getEndDate());
        System.out.println("---------------------------------");
    }
}
