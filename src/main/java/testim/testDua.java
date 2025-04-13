package testim;

import models.Dto.*;
import models.KerkesaSpeciale;
import models.PromoCode;
import models.Rezervimet;
import models.enums.StatusiRezervimetEnum;
import repository.KerkesaSpecialeRepository;
import repository.PromoCodeRepository;
import repository.RezervimetRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class testDua {
    public static void main(String[] args) {



        try {
//            RezervimetRepository rezervimetRepository = new RezervimetRepository();
//            Date data_fillimit1 = Date.valueOf("2025-04-01");
//            Date data_mbarimit1 = Date.valueOf("2025-04-07");
////            Rezervimet rezervimet = rezervimetRepository.getById(101);
////            System.out.println("Rezervimet id: " + rezervimet.getId());
//
//
//            CreateRezervimetDto dto = new CreateRezervimetDto(55, 4, data_fillimit1, data_mbarimit1, StatusiRezervimetEnum.REZERVIMI_AKTIV);
//            Rezervimet newRezervimet = rezervimetRepository.create(dto);
//            newRezervimet.printoTeDhenatRezervimet();
//
//            Date data_fillimit2 = Date.valueOf("2025-05-05");
//            Date data_mbarimit2 = Date.valueOf("2025-05-10");
//
//            UpdateRezervimetDto updateRezervimetDto = new UpdateRezervimetDto(newRezervimet.getId(),3,  data_fillimit2, data_mbarimit2, StatusiRezervimetEnum.REZERVIMI_ANULUAR);
//         Rezervimet updatedRezervimi = rezervimetRepository.update(updateRezervimetDto);
//            if (updatedRezervimi != null) {
//                System.out.println(" Rezervimi u përditësua:");
//                updatedRezervimi.printoTeDhenatRezervimet();
//            } else {
//                System.out.println("Dështoi përditësimi.");
//            }
//


//           PromoCodeRepository promoCodeRepository = new PromoCodeRepository();
//           PromoCode promo= promoCodeRepository.getById(1);
//
//           Date dataSkadimit = Date.valueOf("2025-04-12");
//           Date dataSkadimit2 = Date.valueOf("2024-05-12");
//
//           CreatePromoCodeDto dto = new CreatePromoCodeDto("6TC7BOSEU5",10, dataSkadimit, false );
//           PromoCode newPromoCode = promoCodeRepository.create(dto);
//           newPromoCode.printPromoCode();
//
//          System.out.println("-----------------------------------------");
//           UpdatePromoCodeDto updateDto = new UpdatePromoCodeDto(newPromoCode.getId(), null, 10, dataSkadimit2, true);
//           PromoCode updatedPromoCode = promoCodeRepository.update(updateDto);
//
//           if (updatedPromoCode != null) {
//               System.out.println("Update");
//               updatedPromoCode.printPromoCode();  // Printo informacionin e përditësuar
//           } else {
//               System.out.println("Përditësimi dështoi.");
//           }

            KerkesaSpecialeRepository kerkesaSpecialeRep=new KerkesaSpecialeRepository();
//            KerkesaSpeciale ks = kerkesaSpecialeRep.getById(2);
//            System.out.println("KerkesaSpeciale id: " + ks.getId());

            CreateKerkesatSpecialeDto createKerkesatSpecialeDto = new CreateKerkesatSpecialeDto(100, "Nje kerkse", false);
            KerkesaSpeciale newks = kerkesaSpecialeRep.create(createKerkesatSpecialeDto);
            newks.printoTeDhenatKerkesaSpeciale();

            UpdateKerkesatSpecialeDto updateDto = new UpdateKerkesatSpecialeDto(newks.getId(), 101, "Ndrro kerkesen", true);
            KerkesaSpeciale updatedks = kerkesaSpecialeRep.update(updateDto);
            System.out.println("--------------------------------------------------------");
            if(updatedks != null){
                System.out.println("Update");
                updatedks.printoTeDhenatKerkesaSpeciale();
            }else {
                System.out.println("No update");
            }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

