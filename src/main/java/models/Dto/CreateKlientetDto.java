package models.Dto;

public class CreateKlientetDto {
    private String emri;
    private String mbiemri;
    private String nr_personal;
    private String telefoni;

    public CreateKlientetDto(String emri, String mbiemri, String nr_personal, String telefoni) {
        this.emri=emri;
        this.mbiemri=mbiemri;
        this.nr_personal=nr_personal;
        this.telefoni=telefoni;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setNr_personal(String nr_personal) {
        this.nr_personal = nr_personal;
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

    public String getNr_personal() {
        return nr_personal;
    }

    public String getNr_telefonit() {
        return telefoni;
    }
}
