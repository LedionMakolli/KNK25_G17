package models.Dto;

import java.time.LocalDate;

public class CreateStafDto extends CreateUserDto {
    private String position;
    private LocalDate employmentDate;

    public CreateStafDto(String firstName, String lastName, int age, String personalNumber, String email,
                         String username, String password, String telephoneNumber, String position, LocalDate employmentDate) {
        super(firstName, lastName, age, personalNumber, email, username, password, telephoneNumber);
        this.position = position;
        this.employmentDate = employmentDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }
}

