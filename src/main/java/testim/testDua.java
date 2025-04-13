package testim;

import models.Dto.CreatePromoCodeDto;
import models.Dto.CreateRezervimetDto;
import models.Dto.UpdatePromoCodeDto;
import models.Dto.UpdateRezervimetDto;
import models.PromoCode;
import models.Rezervimet;
import models.enums.StatusiRezervimetEnum;
import repository.PromoCodeRepository;
import repository.RezervimetRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class testDua {
    public static void main(String[] args) {



        try {
            RezervimetRepository rezervimetRepository = new RezervimetRepository();
            Date data_fillimit1 = Date.valueOf("2025-04-01");
            Date data_mbarimit1 = Date.valueOf("2025-04-07");
//            Rezervimet rezervimet = rezervimetRepository.getById(101);
//            System.out.println("Rezervimet id: " + rezervimet.getId());



            CreateRezervimetDto dto = new CreateRezervimetDto(55, 4, data_fillimit1, data_mbarimit1, StatusiRezervimetEnum.REZERVIMI_AKTIV);
            Rezervimet newRezervimet = rezervimetRepository.create(dto);
            newRezervimet.printoTeDhenatRezervimet();

            Date data_fillimit2 = Date.valueOf("2025-05-05");
            Date data_mbarimit2 = Date.valueOf("2025-05-10");

            UpdateRezervimetDto updateRezervimetDto = new UpdateRezervimetDto(newRezervimet.getId(),3,  data_fillimit2, data_mbarimit2, StatusiRezervimetEnum.REZERVIMI_ANULUAR);
         Rezervimet updatedRezervimi = rezervimetRepository.update(updateRezervimetDto);
            if (updatedRezervimi != null) {
                System.out.println("🔁 Rezervimi u përditësua:");
                updatedRezervimi.printoTeDhenatRezervimet();
            } else {
                System.out.println("❌ Dështoi përditësimi.");
            }

//            if (rezervimetRepository.delete(newRezervimet.getId())) {
//                System.out.println("rezervimet eshte fshire");
//           }

//           PromoCodeRepository promoCodeRepository = new PromoCodeRepository();
//           PromoCode promo= promoCodeRepository.getById(1);
//
//           LocalDate dataSkadimit = LocalDate.of(2025, 4, 12);
//           LocalDate dataSkadimit2 = LocalDate.of(2025, 5, 12);
//
//           CreatePromoCodeDto dto = new CreatePromoCodeDto("6TC7BOSEU5",10, dataSkadimit, false );
//           PromoCode newPromoCode = promoCodeRepository.create(dto);
//           newPromoCode.printPromoCode();
//
//           // Përditësimi vetëm i "zbritjes"
//           UpdatePromoCodeDto updateDto = new UpdatePromoCodeDto(11, null, 15.0, null, null);
//           PromoCode updatedPromoCode = promoCodeRepository.update(updateDto);
//
//           if (updatedPromoCode != null) {
//               updatedPromoCode.printPromoCode();  // Printo informacionin e përditësuar
//           } else {
//               System.out.println("Përditësimi dështoi.");
//           }
//
//
//
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

