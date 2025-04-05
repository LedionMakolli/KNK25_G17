package testim;
import models.Dto.CreateKontrataDto;
import models.Kontrata;
import models.enums.PagesaEnum;
import repository.KontrataRepository;

import java.sql.Date;
import java.sql.SQLException;


public class test_KontrataRepository {
    public static void main(String[] args) {


        try {
            Date date = new Date(System.currentTimeMillis());
            
            KontrataRepository kontrataRepository = new KontrataRepository();
            Kontrata kontrata = kontrataRepository.getById(4);
            System.out.println("Kontrata ID: " + kontrata.getIdkontrata());

            CreateKontrataDto createKontrataDto = new CreateKontrataDto(6,3,5000.0, PagesaEnum.KARTELE,date);
            Kontrata newKontrata = kontrataRepository.create(createKontrataDto);
            newKontrata.printoTeDhenatPerKontraten();

//        UpdateKontrataDto updateKontrataDto = new UpdateKontrataDto(4,2000.0, Pagesa.KESH,date);
//        kontrataRepository.update(updateKontrataDto);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
