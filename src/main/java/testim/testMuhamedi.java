package testim;

import models.Dto.CreateCarDto;
import models.Dto.UpdateCarDto;
import models.enums.CarStatusEnum;
import models.enums.FuelEnum;
import models.enums.TransmissionTypeEnum;
import repository.CarRepository;
import java.math.BigDecimal;
import java.sql.SQLException;

public class testMuhamedi {
    public static void main(String[] args) throws SQLException {
        CarRepository carRepository=new CarRepository();

//        CreateCarDto createCarDto=new CreateCarDto("01-977-PE", "Range Rover", "Black", 2015,
//                new BigDecimal(120000), 5, FuelEnum.DIESEL,120, CarStatusEnum.AVAILABLE, TransmissionTypeEnum.AUTOMATIC);
//
//        carRepository.create(createCarDto);

        UpdateCarDto updateCarDto=new UpdateCarDto(1, "Red", null, 135, null);
    }
}
