package models;

import models.enums.VeprimetEnum;

import java.time.LocalDateTime;

public class LogActivity {
    private int id;
    private Integer idUser;
    private VeprimetEnum veprimi;
    private LocalDateTime data;
    private String ipAdress;
}
