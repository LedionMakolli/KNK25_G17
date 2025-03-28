package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Rezervimet {
    private int id_rezervimet;
    private int id_klienti;
    private int id_vetura;
    private String data_fillimit;
    private String data_mbarimit;
    private String statusi;
    // statusi me enum e zene apo e lire

private Rezervimet(int ID_Rezervimet, int ID_Klienti, int ID_Vetura, String Data_Fillimit, String Data_Mbarimit, String Statusi){
    this.id_rezervimet=ID_Rezervimet;
    this.id_klienti=ID_Klienti;
    this.id_vetura=ID_Vetura;
    this.data_fillimit=Data_Fillimit;
    this.data_mbarimit=Data_Mbarimit;
    this.statusi=Statusi;
}
public static Rezervimet getInstance(ResultSet resultSet) throws SQLException {
int id_rezervimet=resultSet.getInt("id_rezervimet");
int id_klienti=resultSet.getInt("id_klienti");
int id_vetura=resultSet.getInt("id_vetura");
String data_fillimit=resultSet.getString("data_fillimit");
String data_mbarimit =resultSet.getString("data_mbarimit");
String statusi=resultSet.getString("statusi");

return new Rezervimet(id_rezervimet, id_klienti, id_vetura, data_fillimit, data_mbarimit, statusi);
}
public int getId_rezervimet(){return id_rezervimet;}

public int getId_klienti(){return id_klienti;}

public int getId_vetura(){return id_vetura;}

public String getData_fillimit(){return data_fillimit;}

public String getData_mbarimit(){return data_mbarimit;}

public String getStatusi(){return statusi;}

}
