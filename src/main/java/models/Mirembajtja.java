package models;

import models.enums.StatusiMirembatja;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Mirembajtja {
    private int id;
    private int idVetura;
    private String pershkrimi;
    private LocalDate dataFillimit;
    private LocalDate dataMbarimit;
    private BigDecimal kosto;
    private StatusiMirembatja statusi;
    private Integer idStafi;  // Integer per te lejuar NULL (nese fshihet punetori..)
}
