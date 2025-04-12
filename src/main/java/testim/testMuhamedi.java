package testim;

import models.Dto.CreateStafDto;
import repository.CarRepository;
import repository.StaffRepository;

import java.sql.SQLException;

public class testMuhamedi {
    public static void main(String[] args) throws SQLException {
        CarRepository carRepository=new CarRepository();

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

        StaffRepository staffRepository=new StaffRepository();
//        CreateStafDto createStafDto=new CreateStafDto("Muhamed", "Jakupi", "")
    }
}
