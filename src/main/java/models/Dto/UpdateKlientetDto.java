package models.Dto;

public class UpdateKlientetDto {
    private String Emri;
    private String Mbiemri;
    private String Nr_telefonit;

    public UpdateKlientetDto(String emri, String mbiemri, String Nr_telefonit) {
        this.Emri=emri;
        this.Mbiemri=mbiemri;
        this.Nr_telefonit=Nr_telefonit;
    }

    public void setEmri(String emri) {
        Emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        Mbiemri = mbiemri;
    }

    public void setNr_telefonit(String nr_telefonit) {
        Nr_telefonit = nr_telefonit;
    }

    public String getEmri() {
        return Emri;
    }

    public String getMbiemri() {
        return Mbiemri;
    }

    public String getNr_telefonit() {
        return Nr_telefonit;
    }
}
