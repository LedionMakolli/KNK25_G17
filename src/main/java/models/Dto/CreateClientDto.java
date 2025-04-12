package models.Dto;

public class CreateClientDto extends CreateUserDto {

    public CreateClientDto(String firstName, String lastName, int age, String personalNumber, String email,
                           String username, String password, String telephoneNumber) {
        super(firstName, lastName, age, personalNumber, email, username, password, telephoneNumber);
    }
}
