package models.Dto;

public class UpdateStafDto extends UpdateUserDto {
    private String pozita;

    public UpdateStafDto(int id, String email, String password, String nrTelefonit, String pozita) {
        super(id, email, password, nrTelefonit);
        this.pozita=pozita;
    }

    public void setPozita(String pozita) {
        this.pozita = pozita;
    }

    public String getPozita() {
        return pozita;
    }
}
