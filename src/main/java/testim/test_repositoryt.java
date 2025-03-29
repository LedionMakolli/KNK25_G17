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
//                2015,new BigDecimal(120000), 700, Karburanti.BENZINE, 200, Statusi_Vetura.NE_DISPOZICION);
//        veturatRepository.create(vetura1);
        Veturat veturaERe=veturatRepository.getById(1);
        if (veturaERe != null) {
            System.out.println("----------------------------------------");
            System.out.println("Vetura u krijua me sukses!");
            System.out.println("Detajet e veturës:");
            System.out.println("ID: " + veturaERe.getIdvetura());
            System.out.println("Targat: " + veturaERe.getTargat());
            System.out.println("Modeli: " + veturaERe.getModeli());
            System.out.println("Ngjyra: " + veturaERe.getNgjyra());
            System.out.println("Viti i prodhimit: " + veturaERe.getVitiProdhimit());
            System.out.println("Kilometrazha: " + veturaERe.getKilometrazha() + " km");
            System.out.println("Kapaciteti: " + veturaERe.getKapaciteti() + " HP");
            System.out.println("Karburanti: " + veturaERe.getKarburanti());
            System.out.println("Çmimi ditor: " + veturaERe.getCmimiditor() + " €");
            System.out.println("Statusi: " + veturaERe.getStatusi());
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Krijimi i veturës dështoi!");
        }
    }
}
