package testim;
import models.*;
import models.Dto.*;
import models.enums.Karburanti;
import models.enums.Statusi_Vetura;
import repository.KlientetRepository;
import repository.SigurimiRepository;
import repository.VeturatRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class test_repositoryt {
    public static void main(String[] args) throws SQLException {

        // Test per UpdateKlientet

//        KlientetRepository klientetRepository=new KlientetRepository();
//        UpdateKlientetDto updateMedi=new UpdateKlientetDto(1, "049442758");
//        klientetRepository.update(updateMedi);


////         Test per funksionimin e tabeles Veturat

//        VeturatRepository veturatRepository=new VeturatRepository();
//      CreateVeturatDto vetura1=new CreateVeturatDto("01-977-PE", "Ferrari", "BLACK",
//                2015,new BigDecimal(120000), 5, Karburanti.BENZINE, 200, Statusi_Vetura.NE_DISPOZICION);
//        veturatRepository.create(vetura1);
//        Veturat vetura2=veturatRepository.getById(4);
//        ArrayList<Veturat> veturat=veturatRepository.getAll();
//
//        veturat.forEach(
//                veturat1 -> {
//                    if(veturat1.getStatusi()==Statusi_Vetura.NE_DISPOZICION) {
//                        veturat1.printoTeDhenatPerVeturen();
//                    }
//                }
//        );

//         Test per funksionimin e tabeles UpdateVeturat
        SigurimiRepository sigurimiRepository=new SigurimiRepository();

//        UpdateVeturatDto updateVetura1=new UpdateVeturatDto(1, null, new BigDecimal("120000"), 0, null);
//        UpdateVeturatDto updateVetura1=new UpdateVeturatDto(0, null, null, 0, null);
//        veturatRepository.update(updateVetura1);
//        ArrayList<Veturat> veturat=veturatRepository.filter("Fiat 500", null, 0, 0,
//                null, 0, null);
//        veturat.forEach(
//                v-> {
//                    v.printoTeDhenatPerVeturen();
//                }
//        );
    }
}
