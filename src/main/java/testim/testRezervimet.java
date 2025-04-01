package testim;

import models.Rezervimet;
import repository.RezervimetRepository;

public class testRezervimet {
    public static void main(String[] args){
//testim i metodes create dhe getById
        try{
            RezervimetRepository rezervimetRepository=new RezervimetRepository();
            Rezervimet rezervimet = rezervimetRepository.getById(101);
            System.out.println("Rezervimet ID: " + rezervimet.getId_rezervimet());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
