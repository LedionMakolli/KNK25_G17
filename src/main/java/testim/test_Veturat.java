package testim;

import models.Dto.UpdateVeturatDto;
import models.Veturat;
import models.enums.StatusiVeturaEnum;
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
    }
}
