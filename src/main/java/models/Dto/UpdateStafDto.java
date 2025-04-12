package models.Dto;

public class UpdateStafDto extends UpdateUserDto {
    private String position;

    public UpdateStafDto(int id, int age, String email, String password, String telephoneNumber, String position) {
        super(id, age, email, password, telephoneNumber);
        this.position=position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
