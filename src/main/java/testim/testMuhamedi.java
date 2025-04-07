package testim;

import models.Dto.*;
import models.Klientet;
import models.Penalizimet;
import models.Rezervimet;
import repository.KlientetRepository;
import repository.PenalizimetRepository;
import repository.RezervimetRepository;
import repository.StafiRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class testMuhamedi {
    public static void main(String[] args) throws SQLException {
        RezervimetRepository rezervimetRepository=new RezervimetRepository();

//        ArrayList<Rezervimet> rezervimet=rezervimetRepository.getAll();
//        rezervimet.forEach(
//                rezervimi -> {
//                    rezervimi.printoTeDhenatRezervimet();
//                }
//        );
        KlientetRepository klientetRepository=new KlientetRepository();
//
//        UpdateKlientetDto updateKlientetDto=
//                new UpdateKlientetDto(2, "zana.kras1@gmail.com",
//                        null, null);
//        klientetRepository.update(updateKlientetDto);
        Klientet klienti=klientetRepository.getById(2);
        klienti.printoTeDhenatPerKlientin();
    }
}
