package models.Dto;

public class CreateKlientetDto extends CreateUserDto {
    private String nrPersonal;

    public CreateKlientetDto(String emri, String mbiemri, String email, String password, String nrTelefonit, String roli, String nrPersonal) {
        super(emri, mbiemri, email, password, nrTelefonit, roli);
        this.nrPersonal = nrPersonal;
    }

    public String getNrPersonal() {
        return nrPersonal;
    }

    public void setNrPersonal(String nrPersonal) {
        this.nrPersonal = nrPersonal;
    }
}
