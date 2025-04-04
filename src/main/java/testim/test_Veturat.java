package testim;

import models.Dto.CreateKlientetDto;
import models.Dto.CreateVeturatDto;
import models.Dto.UpdateKlientetDto;
import models.Dto.UpdateVeturatDto;
import models.Klientet;
import models.Veturat;
import models.enums.Karburanti;
import models.enums.StatusiVeturaEnum;
import repository.KlientetRepository;
import repository.VeturatRepository;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class test_Veturat {
    public static void main(String[] args) throws SQLException {
        VeturatRepository veturatRepository=new VeturatRepository();

        ArrayList<Veturat> veturat=veturatRepository.getAll();

        UpdateVeturatDto updateVeturatDto=new UpdateVeturatDto(4,
                "Kafe", new BigDecimal(160000), 40,  StatusiVeturaEnum.E_REZERVUAR);

        veturatRepository.update(updateVeturatDto);

        CreateVeturatDto createVeturatDto=new CreateVeturatDto("01-123-AB", "Range Rover", "E zezë", 2017, new BigDecimal(70000), 5, Karburanti.BENZINE, 70, StatusiVeturaEnum.E_REZERVUAR);
        veturatRepository.create(createVeturatDto);

        KlientetRepository klientetRepository=new KlientetRepository();

        UpdateKlientetDto updateKlientetDto=new UpdateKlientetDto(6, "049442748");
        klientetRepository.update(updateKlientetDto);

        ArrayList<Klientet> klientet=klientetRepository.getAll();

        klientet.forEach(
                klientet1 -> {
                    klientet1.printoTeDhenatPerKlientin();
                }
        );
    }
}
