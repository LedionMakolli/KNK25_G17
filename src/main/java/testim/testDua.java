package testim;

import models.Dto.CreateRezervimetDto;
import models.Dto.UpdateRezervimetDto;
import models.Rezervimet;
import models.enums.StatusiRezervimetEnum;
import repository.RezervimetRepository;

import java.sql.Date;
import java.sql.SQLException;

public class testDua {
    public static void main(String[] args) {
        Date data_fillimit1 = Date.valueOf("2025-04-01");
        Date data_mbarimit1 = Date.valueOf("2025-04-07");
        Date data_fillimit2= Date.valueOf("2025-05-05");
        Date data_mbarimit2= Date.valueOf("2025-05-10");

       try{
           RezervimetRepository rezervimetRepository = new RezervimetRepository();
           Rezervimet rezervimet = rezervimetRepository.getById(101);
           System.out.println("Rezervimet id: " + rezervimet.getId());

           CreateRezervimetDto dto = new CreateRezervimetDto(55, 4, data_fillimit1, data_mbarimit1,StatusiRezervimetEnum.REZERVIMI_AKTIV );
           Rezervimet newRezervimet = rezervimetRepository.create(dto);
        newRezervimet.printoTeDhenatRezervimet();

           UpdateRezervimetDto updateRezervimetDto = new UpdateRezervimetDto(3, data_fillimit2,data_mbarimit2, StatusiRezervimetEnum.REZERVIMI_ANULUAR);
           newRezervimet = rezervimetRepository.update(updateRezervimetDto);
           newRezervimet.printoTeDhenatRezervimet();

//           if(rezervimetRepository.delete(newRezervimet.getId())){
//               System.out.println("rezervimet eshte fshire");
//           }

       }catch(SQLException e){
           e.printStackTrace();
       }
    }
}
