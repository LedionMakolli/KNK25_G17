package models.Dto;

public class UpdateClientDto extends UpdateUserDto{

    public UpdateClientDto(int id, int age, String email, String password, String salt, String telephoneNumber) {
        super(id, age, email, password, salt, telephoneNumber);
    }
}
