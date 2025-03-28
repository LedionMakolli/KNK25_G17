package testim;
import models.*;
import models.Dto.*;
import repository.KlientetRepository;

import java.sql.SQLException;

public class test_repositoryt {
    public static void main(String[] args) throws SQLException {
        KlientetRepository klientetRepository=new KlientetRepository();
        CreateKlientetDto klienti1=new CreateKlientetDto("Muhamed", "Jakupi", "012345", "1234567890");

        Klientet klienti=klientetRepository.getById(11);
        if (klienti != null) {
            System.out.println("Klienti u gjet:");
            System.out.println("ID: " + klienti.getId_klienti());
            System.out.println("Emri: " + klienti.getEmri());
            System.out.println("Mbiemri: " + klienti.getMbiemri());
            System.out.println("Nr Personal: " + klienti.getNr_personal());
            System.out.println("Telefoni: " + klienti.getTelefoni());
        } else {
            System.out.println("Nuk u gjet klienti me ID: " + 11);
        }
    }
}
