package testim;
import models.Contract;
import models.Dto.*;

import models.enums.PaymentEnum;
import repository.KontrataRepository;

import java.sql.Date;
import java.sql.SQLException;


public class testLedi {
    public static void main(String[] args) {
        try {
            Date date = new Date(System.currentTimeMillis());

            // KONTRATA TEST
            
            KontrataRepository kontrataRepository = new KontrataRepository();
            Contract contract = kontrataRepository.getById(1);
            System.out.println("Contract ID: " + contract.getId());

            CreateContractDto createContractDto = new CreateContractDto(6,1,5000.0, PaymentEnum.CARD,date);
            Contract newContract = kontrataRepository.create(createContractDto);
            newContract.printoTeDhenatPerKontraten();

            UpdateContractDto updateContractDto = new UpdateContractDto(4,2000.0, PaymentEnum.CASH,date);
            kontrataRepository.update(updateContractDto);

            // DOKUMENTET TEST

//            DokumentetRepository dokumentetRepository = new DokumentetRepository();
//            Documents dokumentet = dokumentetRepository.getById(2);
//            System.out.println("Documents ID: " + dokumentet.getId());
//
//            CreateDokumentetDto createDokumentetDto = new CreateDokumentetDto(4, "PDF", "test.pdf", date);
//            Documents newDokumentet = dokumentetRepository.create(createDokumentetDto);
//            newDokumentet.printoTeDhenatPerDokumentin();
////
//            UpdateDocumentsDto updateDokumentetDto = new UpdateDocumentsDto(3,"IMG","test",date);
//            newDokumentet = dokumentetRepository.update(updateDokumentetDto);
//            newDokumentet.printoTeDhenatPerDokumentin();


//            MirembajtjaRepository mirembajtjaRepository = new MirembajtjaRepository();
//            Maintenance mirembajtja = mirembajtjaRepository.getById(1);
//            System.out.println("Maintenance ID: " + mirembajtja.getId());
//
//            CreateMaintenanceDto createMirembajtjaDto = new CreateMaintenanceDto(1, date, "test", date, new BigDecimal("45.50"), StatusiMaintenanceEnum.IN_PROCESS, 1);
//            Maintenance newMireMbajtja = mirembajtjaRepository.create(createMirembajtjaDto);
//            newMireMbajtja.printoTeDhenatPerMirembajtjen();
//
//            UpdateMaintenanceDto updateMirembajtjaDto = new UpdateMaintenanceDto(1,"MIRE",date,date,new BigDecimal("45.00"),StatusiMaintenanceEnum.ANULUAR);
//            newMireMbajtja = mirembajtjaRepository.update(updateMirembajtjaDto);
//            newMireMbajtja.printoTeDhenatPerMirembajtjen();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
