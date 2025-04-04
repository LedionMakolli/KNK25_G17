package models;

import models.enums.Karburanti;
import models.enums.StatusiVetura;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Veturat {
    private int idVetura;
    private String targat;
    private String modeli;
    private String ngjyra;
    private int vitiProdhimit;
    private BigDecimal kilometrazha;
    private int numriUleseve;
    private Karburanti karburanti;
    private int cmimiDitor;
    private StatusiVetura statusi;

    private Veturat(int idVetura, String targat, String modeli, String ngjyra,
                   int vitiProdhimit, BigDecimal kilometrazha, int numriUleseve,
                    Karburanti karburanti, int cmimiDitor, StatusiVetura statusi) {
        this.idVetura = idVetura;
        this.targat = targat;
        this.modeli = modeli;
        this.ngjyra = ngjyra;
        this.vitiProdhimit = vitiProdhimit;
        this.kilometrazha = kilometrazha;
        this.numriUleseve=numriUleseve;
        this.karburanti = karburanti;
        this.cmimiDitor = cmimiDitor;
        this.statusi = statusi;
    }
    public static Veturat getInstance(ResultSet resultSet) throws SQLException {
        int idVetura=resultSet.getInt("idvetura");
        String targat=resultSet.getString("targat");
        String modeli=resultSet.getString("modeli");
        String ngjyra=resultSet.getString("ngjyra");
        int vitiProdhimit=resultSet.getInt("vitiprodhimit");
        BigDecimal kilometrazha=resultSet.getBigDecimal("kilometrazha");
        int numriUleseve=resultSet.getInt("numriuleseve");
        String karburantiStr = resultSet.getString("karburanti");
        Karburanti karburanti = Karburanti.valueOf(karburantiStr.toUpperCase());
        int cmimiDitor=resultSet.getInt("cmimiditor");
        String statusiStr = resultSet.getString("statusi");
        StatusiVetura statusi = StatusiVetura.valueOf(statusiStr.toUpperCase());
        return new Veturat(idVetura,targat,modeli,ngjyra,vitiProdhimit,kilometrazha,numriUleseve,karburanti, cmimiDitor, statusi);
    }

    public int getIdVetura() {
        return idVetura;
    }

    public String getTargat() {
        return targat;
    }

    public String getModeli() {
        return modeli;
    }

    public String getNgjyra() {
        return ngjyra;
    }

    public int getVitiProdhimit() {
        return vitiProdhimit;
    }

    public BigDecimal getKilometrazha() {
        return kilometrazha;
    }

    public int getNumriUleseve() {
        return numriUleseve;
    }

    public Karburanti getKarburanti() {
        return karburanti;
    }

    public int getCmimiDitor() {
        return cmimiDitor;
    }

    public StatusiVetura getStatusi() {
        return statusi;
    }
    public void printoTeDhenatPerVeturen() {
        System.out.println("----------------------------------------");
        System.out.println("Detajet e veturës:");
        System.out.println("ID: " + getIdVetura());
        System.out.println("Targat: " + getTargat());
        System.out.println("Modeli: " + getModeli());
        System.out.println("Ngjyra: " + getNgjyra());
        System.out.println("Viti i prodhimit: " + getVitiProdhimit());
        System.out.println("Kilometrazha: " + getKilometrazha() + " km");
        System.out.println("Kapaciteti: " + getNumriUleseve() + " Ulese");
        System.out.println("Karburanti: " + getKarburanti());
        System.out.println("Çmimi ditor: " + getCmimiDitor() + " €");
        System.out.println("Statusi: " + getStatusi());
        System.out.println("----------------------------------------");
    }
}
