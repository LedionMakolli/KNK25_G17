package models.Dto;

public class CreateClientDto extends CreateUserDto {
    private String nrPersonal;

    public CreateClientDto(String emri, String mbiemri, int age, String email, String password, String nrTelefonit, String nrPersonal) {
        super(emri, mbiemri, age, email, password, nrTelefonit);
        this.nrPersonal = nrPersonal;
    }

    public String getNrPersonal() {
        return nrPersonal;
    }

    public void setNrPersonal(String nrPersonal) {
        this.nrPersonal = nrPersonal;
    }
}
