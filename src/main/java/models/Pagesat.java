package models;

import models.enums.PagesaEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagesat {
    private int id;
    private int idRezervimi;
    private PagesaEnum lloji;
    private Integer promoCodeId;  // Integer n'vend te int per vlera NULL
    private BigDecimal totaliPaZbritje;
    private BigDecimal totaliFinal;  // me ose pa zbritje
    private LocalDateTime data;
}
