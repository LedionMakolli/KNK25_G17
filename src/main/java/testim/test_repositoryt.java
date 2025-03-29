package testim;
import models.*;
import models.Dto.*;
import models.enums.Karburanti;
import models.enums.Statusi_Vetura;
import repository.KlientetRepository;
import repository.VeturatRepository;

import java.math.BigDecimal;
import java.sql.SQLException;

public class test_repositoryt {
    public static void main(String[] args) throws SQLException {
//        KlientetRepository klientetRepository=new KlientetRepository();
//        CreateKlientetDto klienti1=new CreateKlientetDto("Muhamed", "Jakupi", "012345", "1234567890");
//        Klientet klienti=klientetRepository.getById(11);
//
//        // Test per funksionimin e tabeles Klienti
//
//        if (klienti != null) {
//            System.out.println("Klienti u gjet:");
//            System.out.println("ID: " + klienti.getId_klienti());
//            System.out.println("Emri: " + klienti.getEmri());
//            System.out.println("Mbiemri: " + klienti.getMbiemri());
//            System.out.println("Nr Personal: " + klienti.getNr_personal());
//            System.out.println("Telefoni: " + klienti.getTelefoni());
//        } else {
//            System.out.println("Nuk u gjet klienti me ID: " + 11);
//        }

//         Test per funksionimin e tabeles Veturat
        VeturatRepository veturatRepository=new VeturatRepository();
//        CreateVeturatDto vetura1=new CreateVeturatDto("01-977-PE", "Ferrari", "BLACK",
//                2015,new BigDecimal(120000), 5, Karburanti.BENZINE, 200, Statusi_Vetura.NE_DISPOZICION);
//        veturatRepository.create(vetura1);
        Veturat veturaERe=veturatRepository.getById(1);
        veturaERe.getTeDhenat();
    }
}
