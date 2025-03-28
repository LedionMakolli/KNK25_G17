package models.Dto;

public class CreateKlientetDto {
    private String Emri;
    private String Mbiemri;
    private String Nr_personal;
    private String Nr_telefonit;

    public CreateKlientetDto(String emri, String mbiemri, String Nr_personal, String Nr_telefonit) {
        this.Emri=emri;
        this.Mbiemri=mbiemri;
        this.Nr_personal=Nr_personal;
        this.Nr_telefonit=Nr_telefonit;
    }

    public void setEmri(String emri) {
        Emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        Mbiemri = mbiemri;
    }

    public void setNr_personal(String nr_personal) {
        Nr_personal = nr_personal;
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

    public String getNr_personal() {
        return Nr_personal;
    }

    public String getNr_telefonit() {
        return Nr_telefonit;
    }
}
