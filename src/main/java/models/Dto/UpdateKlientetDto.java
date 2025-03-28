package models.Dto;

public class UpdateKlientetDto {
    private String emri;
    private String mbiemri;
    private String telefoni;

    public UpdateKlientetDto(String emri, String mbiemri, String Nr_telefonit) {
        this.emri=emri;
        this.mbiemri=mbiemri;
        this.telefoni=Nr_telefonit;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setNr_telefonit(String nr_telefonit) {
        this.telefoni = nr_telefonit;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getNr_telefonit() {
        return telefoni;
    }
}
