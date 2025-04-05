package models;

import models.enums.Veprimet;

import java.time.LocalDateTime;

public class LogActivity {
    private int id;
    private Integer idUser;
    private Veprimet veprimi;
    private LocalDateTime data;
    private String ipAdress;
}
