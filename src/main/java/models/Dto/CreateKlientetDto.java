package models.Dto;

public class CreateKlientetDto {
    private String emri;
    private String mbiemri;
    private String nrPersonal;
    private String nrTelefoni;

    public CreateKlientetDto(String emri, String mbiemri, String nrPersonal, String nrTelefoni) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.nrPersonal = nrPersonal;
        this.nrTelefoni = nrTelefoni;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public void setNrPersonal(String nrPersonal) {
        this.nrPersonal = nrPersonal;
    }

    public void setNrTelefoni(String nrTelefoni) {
        this.nrTelefoni = nrTelefoni;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getNrPersonal() {
        return nrPersonal;
    }

    public String getNrTelefoni() {
        return nrTelefoni;
    }
}
