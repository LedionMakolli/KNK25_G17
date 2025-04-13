package models;

import models.enums.StatusiMirembatjaEnum;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mirembajtja {
    private int id;
    private int idVetura;
    private String pershkrimi;
    private Date dataFillimit;
    private Date dataMbarimit;
    private BigDecimal kosto;
    private StatusiMirembatjaEnum statusi;
    private Integer idStafi;  // Integer per te lejuar NULL (nese fshihet punetori..)

    private Mirembajtja(int id, int idVetura, String pershkrimi, Date dataFillimit, Date dataMbarimit, BigDecimal kosto, StatusiMirembatjaEnum statusi, Integer idStafi) {
        this.id = id;
        this.idVetura = idVetura;
        this.pershkrimi = pershkrimi;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
        this.kosto = kosto;
        this.statusi = statusi;
        this.idStafi = idStafi;
    }

    public static Mirembajtja getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int idVetura = resultSet.getInt("idVetura");
        String pershkrimi = resultSet.getString("pershkrimi");
        Date dataFillimit = resultSet.getDate("dataFillimit");
        Date dataMbarimit = resultSet.getDate("dataMbarimit");
        BigDecimal kosto = resultSet.getBigDecimal("kosto");
        StatusiMirembatjaEnum mirembajtja = StatusiMirembatjaEnum.valueOf(resultSet.getString("statusi"));
        Integer idStafi = resultSet.getInt("idStafi");
        return new Mirembajtja(id,idVetura,pershkrimi,dataFillimit,dataMbarimit,kosto,mirembajtja,idStafi); // edhe dy ke me i shtu
    }

    public int getId() {
        return id;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public int getIdVetura() {
        return idVetura;
    }

    public Date getDataFillimit() {
        return dataFillimit;
    }

    public Date getDataMbarimit() {
        return dataMbarimit;
    }

    public BigDecimal getKosto() {
        return kosto;
    }

    public StatusiMirembatjaEnum getStatusi() {
        return statusi;
    }

    public Integer getIdStafi() {
        return idStafi;
    }

    public void printoTeDhenatPerMirembajtjen(){
        System.out.println("-----------------------------");
        System.out.println("Detajet e Mirembajtjes");
        System.out.println("ID: " + id);
        System.out.println("Pershkrimi: " + pershkrimi);
        System.out.println("Data fillimit: " + dataFillimit);
        System.out.println("Data mbarimit: " + dataMbarimit);
        System.out.println("Kosto: " + kosto);
        System.out.println("Statusi: " + statusi);
        System.out.println("IdStafi: " + idStafi);
        System.out.println("-----------------------------");
    }
}
