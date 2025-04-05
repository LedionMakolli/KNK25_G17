package testim;

import models.Dto.CreateRezervimetDto;
import models.Rezervimet;
import models.enums.StatusiRezervimet;
import repository.RezervimetRepository;

import java.sql.Date;

public class testRezervimet {
    public static void main(String[] args){
        Date data_fillimit1 = Date.valueOf("2025-04-01");
        Date data_mbarimit1 = Date.valueOf("2025-04-07");

        try{
            //testim i metodes create dhe getById
            RezervimetRepository rezervimetRepository=new RezervimetRepository();
            Rezervimet rezervimet = rezervimetRepository.getById(101);
            System.out.println("Rezervimet ID: " + rezervimet.getId_rezervimet());

            CreateRezervimetDto crdto = new CreateRezervimetDto(55, 2, data_fillimit1, data_mbarimit1, StatusiRezervimet.REZERVIMI_AKTIV);
            Rezervimet newRezervimet = rezervimetRepository.create(crdto);
            newRezervimet.printoTeDhenatRezervimet();

            //testimi i metodes update


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
