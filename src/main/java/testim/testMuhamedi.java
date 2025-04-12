package testim;

import models.Clients;
import repository.KlientetRepository;
import repository.RezervimetRepository;

import java.sql.SQLException;

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
//        UpdateClientDto updateKlientetDto=
//                new UpdateClientDto(2, "zana.kras1@gmail.com",
//                        null, null);
//        klientetRepository.update(updateKlientetDto);
        Clients klienti=klientetRepository.getById(2);
        klienti.printoTeDhenatPerKlientin();
    }
}
