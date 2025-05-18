package services;

import models.Cars;
import repository.CarRepository;
import repository.OffersRepository;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CarDetailsSerivce {
    private final OffersRepository offersRepository;
    private final CarRepository carRepository;
    private Cars currentCar;

    public CarDetailsSerivce() throws SQLException {
        this.offersRepository = new OffersRepository();
        this.carRepository = new CarRepository();
    }

    public BigDecimal getDailyPrice(Cars car){
        this.currentCar = car;
        int carid = currentCar.getId();
        BigDecimal divider = BigDecimal.valueOf(100);
        BigDecimal regularPrice = carRepository.getDailyPrice(carid);
        if (offersRepository.getByCarId(carid)){
            BigDecimal sale = offersRepository.getSale(carid);
            return regularPrice.subtract( regularPrice.multiply(sale).divide(divider));// kqyre qit rresht
        }
        return regularPrice;
    }

    public boolean sale (Cars car){
        this.currentCar = car;
        int carid = currentCar.getId();
        if (offersRepository.getByCarId(carid)){
            return true;
        }
        return false;
    }

}
