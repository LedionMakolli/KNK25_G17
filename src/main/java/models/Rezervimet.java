package models;

public class Rezervimet {
    private int ID_Rezervimet;
    private int ID_Klienti;
    private int ID_Vetura;
    private String Data_Fillimit;
    private String Data_Mbarimit;
    private String Statusi;
    // statusi me enum e zene apo e lire

private Rezervimet(int ID_Rezervimet, int ID_Klienti, int ID_Vetura, String Data_Fillimit, String Data_Mbarimit, String Statusi){
    this.ID_Rezervimet=ID_Rezervimet;
    this.ID_Klienti=ID_Klienti;
    this.ID_Vetura=ID_Vetura;
    this.Data_Fillimit=Data_Fillimit;
    this.Data_Mbarimit=Data_Mbarimit;
    this.Statusi=Statusi;
}

}
