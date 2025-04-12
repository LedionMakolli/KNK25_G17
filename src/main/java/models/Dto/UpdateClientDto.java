package models.Dto;

public class UpdateClientDto extends UpdateUserDto{

    public UpdateClientDto(int id, int age, String email, String password, String nrTelefonit) {
        super(id, age, email, password, nrTelefonit);
    }
}
