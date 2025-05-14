package testim;

import models.Cars;
import models.Clients;
import models.Dto.*;
import models.enums.CarStatusEnum;
import models.enums.FuelEnum;
import models.enums.StaffPositionEnum;
import models.enums.TransmissionTypeEnum;
import repository.CarRepository;
import repository.ClientRepository;
import repository.StaffRepository;
import services.PasswordHasher;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class testMuhamedi {
    public static void main(String[] args) throws SQLException {
        StaffRepository staffRepository=new StaffRepository();

        CreateStafDto createStafDto=new CreateStafDto(
                "Ledion", "Makolli", 20, "1023613293",
                "ledionmakolli@gmail.com", "ledion", "ledion",
                PasswordHasher.generateSalt(), "049442222", StaffPositionEnum.STAFF,
                LocalDate.now(), 130000
        );
        staffRepository.create(createStafDto);

    }
}
