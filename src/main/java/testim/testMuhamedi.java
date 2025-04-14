package testim;

import models.Cars;
import models.Clients;
import models.Dto.*;
import models.enums.CarStatusEnum;
import models.enums.FuelEnum;
import models.enums.TransmissionTypeEnum;
import repository.CarRepository;
import repository.ClientRepository;
import repository.StaffRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class testMuhamedi {
    public static void main(String[] args) throws SQLException {
//        CarRepository carRepository=new CarRepository();

//        CreateCarDto createCarDto=new CreateCarDto("01-977-PE", "Range Rover", "Black", 2015,
//                new BigDecimal(120000), 5, FuelEnum.DIESEL,120, CarStatusEnum.AVAILABLE, TransmissionTypeEnum.AUTOMATIC);
//
//        carRepository.create(createCarDto);

//        UpdateCarDto updateCarDto=new UpdateCarDto(1, "Red", null, 135, null);
//
//        carRepository.update(updateCarDto);
//        ArrayList<Cars> cars=carRepository.filter(null, "Red", 0, 0,null, 0, null);
//        cars.forEach(
//                car1-> {
//                    car1.printCarDetails();
//                }
//        );

//        ClientRepository clientRepository=new ClientRepository();
//
//        CreateClientDto createClientDto=new CreateClientDto("Klienti1", "Mbiemri1", 23, "12231213",
//                "klientimbiemri1@gmail.com", "klientimbiemri1", "123klienti", "049427726");
//
//        clientRepository.create(createClientDto);
//        UpdateClientDto updateClientDto=new UpdateClientDto(1, 24, null, "newPassword", null);
//
//        clientRepository.update(updateClientDto);

//        ArrayList<Clients> clients=clientRepository.getAll();
//        clients.forEach(
//                clients1 -> {
//                    clients1.printClientData();
//                }
//        );
//        clientRepository.delete(6);

//        CarRepository carRepository=new CarRepository();

//        CreateCarDto createCarDto=new CreateCarDto("02-222-MV",
//                "Range Rover", "Blue", 2018,
//                new BigDecimal(40000), 5, FuelEnum.DIESEL, 150,
//                CarStatusEnum.AVAILABLE, TransmissionTypeEnum.AUTOMATIC);
//
//        carRepository.create(createCarDto);

//        ArrayList<Cars> cars=carRepository.getAll();
//        cars.forEach(
//                cars1 -> {
//                    cars1.printCarDetails();
//                }
//        );
//        Cars car1=carRepository.getById(2);
//        car1.printCarDetails();
//        carRepository.delete(12);
//        UpdateCarDto updateCarDto=new UpdateCarDto(11, null,
//                null, 86, null);
//
//        carRepository.update(updateCarDto);
    }
}
