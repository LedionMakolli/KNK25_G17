package models.enums;

public enum Veprimet {  // nashta duhet me ndryshu
    // Autentikim
    LOGIN_SUKSES,
    LOGIN_DESHTIM,
    LOGOUT,
    NDERRRO_PASSWORD,

    // Menaxhimi i Përdoruesve
    KRIJO_PERDORUES,
    PERDITESO_PERDORUES,
    FSHIJ_PERDORUES,
    BLOKO_PERDORUES,

    // Rezervimet
    KRIJO_REZERVIM,
    PERDITESO_REZERVIM,
    FSHIJ_REZERVIM,
    KONFIRMO_REZERVIM,
    ANULO_REZERVIM,

    // Pagesat
    KRIJO_PAGESE,
    REFUZO_PAGESE,
    RAPORTO_PAGESE,

    // Menaxhimi i Automjeteve
    SHTO_VETURE,
    PERDITESO_VETURE,
    FSHIJ_VETURE,
    REGJISTRO_MIREMBAJTJE,

    // Menaxhimi i Stafit
    SHTO_STAF,
    NDRRO_POZICION,
    SHKYQ_STAF,

    // Admin
    BACKUP_DATABASE,
    RESTORE_DATABASE,
    GENERO_RAPORT,

    // Sistemi
    GABIM_SISTEMI,
    ACCESS_DENIED,
    KERKIM_JO_AUTORIZUAR
}
