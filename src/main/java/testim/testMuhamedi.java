package testim;

import models.Dto.*;
import models.Penalizimet;
import models.Rezervimet;
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
        PenalizimetRepository penalizimetRepository=new PenalizimetRepository();

        Penalizimet penalizimet=penalizimetRepository.getById(1);
        penalizimet.printoTeDhenatPerPenalizimin();
    }
}
