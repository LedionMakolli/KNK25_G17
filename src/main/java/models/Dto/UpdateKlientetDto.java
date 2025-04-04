package models.Dto;

public class UpdateKlientetDto {
    private int id;
    private String nrTelefoni;

    public UpdateKlientetDto(int id, String nrTelefoni) {
        this.id=id;
        this.nrTelefoni=nrTelefoni;
    }

    public void setNrTelefoni(String nrTelefoni) {
        this.nrTelefoni = nrTelefoni;
    }

    public int getId() {
        return id;
    }

    public String getNrTelefoni() {
        return nrTelefoni;
    }
}
