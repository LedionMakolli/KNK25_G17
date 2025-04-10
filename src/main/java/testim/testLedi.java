package testim;
import models.Dokumentet;
import models.Dto.CreateDokumentetDto;
import models.Dto.CreateKontrataDto;

import models.Dto.UpdateDokumentetDto;
import models.Dto.UpdateKontrataDto;
import models.Kontrata;
import models.enums.PagesaEnum;
import repository.DokumentetRepository;
import repository.KontrataRepository;

import java.sql.Date;
import java.sql.SQLException;


public class testLedi {
    public static void main(String[] args) {
        try {
            Date date = new Date(System.currentTimeMillis());

            // KONTRATA TEST
            
//            KontrataRepository kontrataRepository = new KontrataRepository();
//            Kontrata kontrata = kontrataRepository.getById(4);
//            System.out.println("Kontrata ID: " + kontrata.getId());
//
//            CreateKontrataDto createKontrataDto = new CreateKontrataDto(6,12,5000.0, PagesaEnum.KARTELE,date);
//            Kontrata newKontrata = kontrataRepository.create(createKontrataDto);
//            newKontrata.printoTeDhenatPerKontraten();
//
//            UpdateKontrataDto updateKontrataDto = new UpdateKontrataDto(4,2000.0, PagesaEnum.KESH,date);
//            kontrataRepository.update(updateKontrataDto);

            // DOKUMENTET TEST

            DokumentetRepository dokumentetRepository = new DokumentetRepository();
            Dokumentet dokumentet = dokumentetRepository.getById(2);
            System.out.println("Dokumentet ID: " + dokumentet.getId());

            CreateDokumentetDto createDokumentetDto = new CreateDokumentetDto(4, "PDF", "test.pdf", date);
            Dokumentet newDokumentet = dokumentetRepository.create(createDokumentetDto);
            newDokumentet.printoTeDhenatPerDokumentin();
//
            UpdateDokumentetDto updateDokumentetDto = new UpdateDokumentetDto(3,"IMG","test",date);
            newDokumentet = dokumentetRepository.update(updateDokumentetDto);
            newDokumentet.printoTeDhenatPerDokumentin();




        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
