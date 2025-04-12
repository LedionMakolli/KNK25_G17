package models.Dto;

public class UpdateClientDto extends UpdateUserDto{

    public UpdateClientDto(int id, String email, String password, String nrTelefonit) {
        super(id, email, password, nrTelefonit);
    }
}
