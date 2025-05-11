package services;

import models.Cars;
import models.Dto.CreateCarDto;
import models.Dto.UpdateCarDto;
import repository.CarRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CarService2 {
    private final CarRepository repository;

    public CarService2() throws SQLException {
        this.repository = new CarRepository();
    }

    public Cars getById(int id) throws Exception{
        try {
            return repository.getById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching car with ID " + id, e);
        }
    }


    public List<Cars> findAvailable(LocalDate start, LocalDate end) {
        try {
            return repository.findAvailable(start, end);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("Error fetching available cars between %s and %s", start, end), e);
        }
    }


    public Cars create(CreateCarDto dto) {
        try {
            return repository.create(dto);
        } catch (Exception e) {
            throw new RuntimeException("Error creating new car", e);
        }
    }

    public Cars update(UpdateCarDto dto) {
        try {
            return repository.update(dto);
        } catch (Exception e) {
            throw new RuntimeException("Error updating car with ID " + dto.getId(), e);
        }
    }


    public void delete(int id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting car with ID " + id, e);
        }
    }
}
