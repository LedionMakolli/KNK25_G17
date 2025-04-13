package models.Dto;

import models.enums.StaffPositionEnum;

import java.time.LocalDate;

public class CreateStafDto extends CreateUserDto {
    private StaffPositionEnum position;
    private LocalDate employmentDate;
    private double salary;

    public CreateStafDto(String firstName, String lastName, int age, String personalNumber, String email,
                         String username, String password, String telephoneNumber, StaffPositionEnum position, LocalDate employmentDate, double salary) {
        super(firstName, lastName, age, personalNumber, email, username, password, telephoneNumber);
        this.position = position;
        this.employmentDate = employmentDate;
        this.salary=salary;
    }

    public StaffPositionEnum getPosition() {
        return position;
    }

    public void setPosition(StaffPositionEnum position) {
        this.position = position;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

