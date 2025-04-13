package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialRequests {
    private int id;
    private int idRezervimet;
    private String kerkese;
    private Boolean plotesuar;

    private SpecialRequests(int id, int idRezervimet, String kerkese, Boolean plotesuar){
        this.id=id;
        this.idRezervimet=idRezervimet;
        this.kerkese=kerkese;
        this.plotesuar=plotesuar;
    }
    public static SpecialRequests getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idRezervimet = resultSet.getInt("idRezervimet");
        String kerkese = resultSet.getString("kerkese");
        Boolean plotesuar = resultSet.getBoolean("plotesuar");

        return new SpecialRequests(id, idRezervimet,kerkese, plotesuar );
    }
    public int getId(){
        return id;
    }
    public int getIdRezervimet(){
        return idRezervimet;
    }
    public String getKerkese(){
        return kerkese;
    }
    public Boolean getPlotesuar(){
        return plotesuar;
    }
    public void printoTeDhenatKerkesaSpeciale(){
        System.out.println("Detajet e Kerkesave Speciale: ");
        System.out.println("ID: "+ getId());
        System.out.println("IDRezerimet: " + getIdRezervimet());
        System.out.println("Kerkesa: " + getKerkese());
        System.out.println("Plotesuar: " + getPlotesuar());
    }
}
