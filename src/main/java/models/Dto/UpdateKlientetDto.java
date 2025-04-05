package models.Dto;

public class UpdateKlientetDto extends UpdateUserDto{

    public UpdateKlientetDto(int id, String email, String password, String nrTelefonit, String roli, String pozita) {
        super(id, email, password, nrTelefonit, roli);
    }
}
