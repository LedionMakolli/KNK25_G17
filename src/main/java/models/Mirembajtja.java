package models;

import models.enums.StatusiMirembatjaEnum;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Mirembajtja {
    private int idMirembajtja;
    private int idVetura;
    private String pershkrimi;
    private Date dataFillimit;
    private Date dataMbarimit;
    private BigDecimal kosto;
    private StatusiMirembatjaEnum statusi;
    private Integer idStafi;  // Integer per te lejuar NULL (nese fshihet punetori..)

    private Mirembajtja(int idMirembajtja, int idVetura, String pershkrimi, Date dataFillimit, Date dataMbarimit, BigDecimal kosto, StatusiMirembatjaEnum statusi, Integer idStafi) {
        this.idMirembajtja = idMirembajtja;
        this.idVetura = idVetura;
        this.pershkrimi = pershkrimi;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
        this.kosto = kosto;
        this.statusi = statusi;
        this.idStafi = idStafi;
    }

    public static Mirembajtja getMirembajtjaById(ResultSet resultSet) throws SQLException {
        int idMirembajtja = resultSet.getInt("idMirembajtja");
        int idVetura = resultSet.getInt("idVetura");
        String pershkrimi = resultSet.getString("pershkrimi");
        Date dataFillimit = resultSet.getDate("dataFillimit");
        Date dataMbarimit = resultSet.getDate("dataMbarimit");
        BigDecimal kosto = resultSet.getBigDecimal("kosto");
        StatusiMirembatjaEnum mirembajtja = StatusiMirembatjaEnum.valueOf(resultSet.getString("statusi"));
        Integer idStafi = resultSet.getInt("idStafi");
        return new Mirembajtja(idMirembajtja,idVetura,pershkrimi,kosto,mirembajtja,idStafi); // edhe dy ke me i shtu
    }
}
