package models.Dto;

public class UpdateKlientetDto {
    private int id_klienti;
    private String telefoni;

    public UpdateKlientetDto(int id_klienti, String telefoni) {
        this.id_klienti=id_klienti;
        this.telefoni=telefoni;
    }

    public void setTelefoni(String telefoni) {
        this.telefoni = telefoni;
    }

    public int getId_klienti() {
        return id_klienti;
    }

    public String getTelefoni() {
        return telefoni;
    }
}
