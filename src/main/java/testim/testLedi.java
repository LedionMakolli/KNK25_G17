package testim;
import models.Dokumentet;
import models.Dto.*;

import models.Kontrata;
import models.Mirembajtja;
import models.enums.PagesaEnum;
import models.enums.StatusiMirembatjaEnum;
import repository.DokumentetRepository;
import repository.KontrataRepository;
import repository.MirembajtjaRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;


public class testLedi {
    public static void main(String[] args) {
        try {
            Date date = new Date(System.currentTimeMillis());

            // KONTRATA TEST
            
            KontrataRepository kontrataRepository = new KontrataRepository();
            Kontrata kontrata = kontrataRepository.getById(1);
            System.out.println("Kontrata ID: " + kontrata.getId());

            CreateKontrataDto createKontrataDto = new CreateKontrataDto(6,1,5000.0, PagesaEnum.KARTELE,date);
            Kontrata newKontrata = kontrataRepository.create(createKontrataDto);
            newKontrata.printoTeDhenatPerKontraten();

            UpdateKontrataDto updateKontrataDto = new UpdateKontrataDto(4,2000.0, PagesaEnum.KESH,date);
            kontrataRepository.update(updateKontrataDto);

            // DOKUMENTET TEST

//            DokumentetRepository dokumentetRepository = new DokumentetRepository();
//            Dokumentet dokumentet = dokumentetRepository.getById(2);
//            System.out.println("Dokumentet ID: " + dokumentet.getId());
//
//            CreateDokumentetDto createDokumentetDto = new CreateDokumentetDto(4, "PDF", "test.pdf", date);
//            Dokumentet newDokumentet = dokumentetRepository.create(createDokumentetDto);
//            newDokumentet.printoTeDhenatPerDokumentin();
////
//            UpdateDokumentetDto updateDokumentetDto = new UpdateDokumentetDto(3,"IMG","test",date);
//            newDokumentet = dokumentetRepository.update(updateDokumentetDto);
//            newDokumentet.printoTeDhenatPerDokumentin();


//            MirembajtjaRepository mirembajtjaRepository = new MirembajtjaRepository();
//            Mirembajtja mirembajtja = mirembajtjaRepository.getById(1);
//            System.out.println("Mirembajtja ID: " + mirembajtja.getId());
//
//            CreateMirembajtjaDto createMirembajtjaDto = new CreateMirembajtjaDto(1, date, "test", date, new BigDecimal("45.50"), StatusiMirembatjaEnum.NE_PROCES, 1);
//            Mirembajtja newMireMbajtja = mirembajtjaRepository.create(createMirembajtjaDto);
//            newMireMbajtja.printoTeDhenatPerMirembajtjen();
//
//            UpdateMirembajtjaDto updateMirembajtjaDto = new UpdateMirembajtjaDto(1,"MIRE",date,date,new BigDecimal("45.00"),StatusiMirembatjaEnum.ANULUAR);
//            newMireMbajtja = mirembajtjaRepository.update(updateMirembajtjaDto);
//            newMireMbajtja.printoTeDhenatPerMirembajtjen();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
