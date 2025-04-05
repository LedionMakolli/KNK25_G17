package models.Dto;

public class UpdateStafiDto extends UpdateUserDto {
    private String pozita;

    public UpdateStafiDto(int id, String email, String password, String nrTelefonit, String roli, String pozita) {
        super(id, email, password, nrTelefonit, roli);
        this.pozita=pozita;
    }

    public void setPozita(String pozita) {
        this.pozita = pozita;
    }

    public String getPozita() {
        return pozita;
    }
}
