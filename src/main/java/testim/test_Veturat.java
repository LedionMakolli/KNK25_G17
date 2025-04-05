package testim;

import models.Dto.*;
import models.Klientet;
import models.Veturat;
import models.enums.Karburanti;
import models.enums.StatusiVeturaEnum;
import repository.KlientetRepository;
import repository.StafiRepository;
import repository.VeturatRepository;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class test_Veturat {
    public static void main(String[] args) throws SQLException {
        StafiRepository stafiRepository=new StafiRepository();

        CreateStafiDto createStafiDto=new CreateStafiDto("Ejone", "Analumi", "ejone@gmail.com", "ejona123",
                "11982133", "Staf", "Mekanike", LocalDate.of(2025,6,5));

        stafiRepository.create(createStafiDto);

//        UpdateStafiDto updateStafiDto=new UpdateStafiDto(1, null, null, "049442758", "Staf","Menaxher");
//
//        stafiRepository.update(updateStafiDto);

//        KlientetRepository klientetRepository=new KlientetRepository();
////
//        CreateKlientetDto createKlientetDto=new CreateKlientetDto("Zana", "Krasniqi", "zanakrasniqi@gmail.com", "passwordi123",
//                "0494123758", "Staf", "96851265");
////        UpdateKlientetDto updateKlientetDto=new UpdateKlientetDto(1, null, "newPassword", null, null);
//        klientetRepository.create(createKlientetDto);
    }
}
