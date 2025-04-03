package models.Dto;

public class UpdateKlientetDto {
    private int idKlienti;
    private String nrTelefoni;

    public UpdateKlientetDto(int idKlienti, String nrTelefoni) {
        this.idKlienti=idKlienti;
        this.nrTelefoni=nrTelefoni;
    }

    public void setNrTelefoni(String nrTelefoni) {
        this.nrTelefoni = nrTelefoni;
    }

    public int getIdKlienti() {
        return idKlienti;
    }

    public String getNrTelefoni() {
        return nrTelefoni;
    }
}
