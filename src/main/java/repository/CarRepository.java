package repository;

import models.*;
import models.Dto.*;
import models.enums.FuelEnum;
import models.enums.CarStatusEnum;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class CarRepository extends BaseRepository<Cars, CreateCarDto, UpdateCarDto> {

    public CarRepository() throws SQLException {
        super("cars");
    }

    @Override
    public Cars fromResultSet(ResultSet rs) {
        try {
            return Cars.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cars> findAvailable(LocalDate start, LocalDate end) {
        String sql = """
        SELECT *
          FROM cars c
         WHERE NOT EXISTS (
               SELECT 1
                 FROM reservations r
                WHERE r.idcar = c.id
                  AND NOT (r.enddate < ? OR r.startdate > ?)
               )
        """;

        List<Cars> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(start));
            ps.setDate(2, java.sql.Date.valueOf(end));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(Cars.getInstance(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding available cars", e);
        }
        return list;
    }


    // 3. create method
    public Cars create(CreateCarDto carDto) {
        String query = """
                INSERT INTO CARS (LICENSEPLATE, MODEL, COLOR, YEAROFMANUFACTURE,
                MILEAGE, SEATCOUNT, FUELTYPE, DAILYPRICE, STATUS, TRANSMISSIONTYPE, IMAGEPATH)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, carDto.getLicensePlate());
            preparedStatement.setString(2, carDto.getModel());
            preparedStatement.setString(3, carDto.getColor());
            preparedStatement.setInt(4, carDto.getYearOfManufacture());
            preparedStatement.setBigDecimal(5, carDto.getMileage());
            preparedStatement.setInt(6, carDto.getNumberOfSeats());
            preparedStatement.setObject(7, carDto.getFuelType(), Types.OTHER);
            preparedStatement.setInt(8, carDto.getDailyPrice());
            preparedStatement.setObject(9, carDto.getStatus().name(), Types.OTHER);
            preparedStatement.setObject(10, carDto.getTransmissionType().name(), Types.OTHER);
            preparedStatement.setObject(11, carDto.getImagePath());
            preparedStatement.execute();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                int id = result.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 4. update method
    public Cars update(UpdateCarDto carDto) {
        StringBuilder query = new StringBuilder("UPDATE CARS SET ");
        List<Object> parameters = new ArrayList<>();
        boolean hasUpdates = false;

        if (carDto.getColor() != null) {
            query.append("color = ?, ");
            parameters.add(carDto.getColor());
            hasUpdates = true;
        }
        if (carDto.getMileage() != null) {
            query.append("mileage = ?, ");
            parameters.add(carDto.getMileage());
            hasUpdates = true;
        }
        if (carDto.getDailyPrice() > 0) {
            query.append("dailyprice = ?, ");
            parameters.add(carDto.getDailyPrice());
            hasUpdates = true;
        }
        if (carDto.getStatus() != null) {
            query.append("status = ?, ");
            parameters.add(carDto.getStatus().name());
            hasUpdates = true;
        }
        if (!hasUpdates) {
            return getById(carDto.getId());
        }
        query.setLength(query.length() - 2);
        query.append(" WHERE id=?");
        parameters.add(carDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i), Types.OTHER);
            }
            preparedStatement.executeUpdate();
            return getById(carDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Error during update!", e);
        }
    }

    // 6. filter method
    public ArrayList<Cars> filter(String model, String color, int yearOfManufacture, int seatCount,
                                  FuelEnum fuelType, int dailyRentalPrice, CarStatusEnum status) {
        ArrayList<Cars> cars = new ArrayList<Cars>();
        StringBuilder query = new StringBuilder("SELECT * FROM CARS WHERE 1=1");
        List<Object> parameters = new ArrayList<>();

        if (model != null) {
            query.append(" and model= ?");
            parameters.add(model);
        }
        if (color != null) {
            query.append(" and color= ?");
            parameters.add(color);
        }
        if (yearOfManufacture > 0) {
            query.append(" and year_of_manufacture=?");
            parameters.add(yearOfManufacture);
        } else if (yearOfManufacture < 0) {
            throw new IllegalArgumentException("Invalid year of manufacture");
        }
        if (seatCount > 0) {
            query.append(" and seat_count=?");
            parameters.add(seatCount);
        } else if (seatCount < 0) {
            throw new IllegalArgumentException("Invalid seat count");
        }
        if (fuelType != null) {
            query.append(" and fuel_type::text = ?");
            parameters.add(fuelType.name());
        }

        if (dailyRentalPrice > 0) {
            query.append(" and daily_rental_price=?");
            parameters.add(dailyRentalPrice);
        } else if (dailyRentalPrice < 0) {
            throw new IllegalArgumentException("Invalid daily rental price");
        }
        if (status != null) {
            query.append(" and status::text = ?");
            parameters.add(status.name());
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cars.add(Cars.getInstance(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public BigDecimal getDailyPrice(int carId){
        String query = "SELECT dailyPrice FROM CARS WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, carId);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                int price = resultSet.getInt("dailyPrice");
                return BigDecimal.valueOf(price);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }
}
