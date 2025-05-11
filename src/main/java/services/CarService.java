package services;

import models.Cars;
import models.Dto.CreateCarDto;
import models.Dto.UpdateCarDto;
import models.enums.CarStatusEnum;
import models.enums.FuelEnum;
import repository.CarRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final CarRepository carRepository;

    public CarService() {
        try {
            this.carRepository = new CarRepository();
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed for CarRepository", e);
        }
    }

    public List<Cars> getAllCars() {
        return carRepository.getAll();
    }

    public Cars getById(int id) {
        return carRepository.getById(id);
    }

    public Cars createCar(CreateCarDto dto) {
        return carRepository.create(dto);
    }

    public Cars updateCar(UpdateCarDto dto) {
        return carRepository.update(dto);
    }

    public List<Cars> findAvailable(LocalDate start, LocalDate end) {
        return carRepository.findAvailable(start, end);
    }

    public ArrayList<Cars> filter(String model, String color, int yearOfManufacture, int seatCount,
                                  FuelEnum fuelType, int dailyRentalPrice, CarStatusEnum status) {
        return carRepository.filter(model, color, yearOfManufacture, seatCount, fuelType, dailyRentalPrice, status);
    }
}

