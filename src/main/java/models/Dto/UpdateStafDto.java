package models.Dto;

import models.enums.StaffPositionEnum;

public class UpdateStafDto extends UpdateUserDto {
    private StaffPositionEnum position;
    private double salary;

    public UpdateStafDto(int id, int age, String email, String password, String telephoneNumber, StaffPositionEnum position, double salary) {
        super(id, age, email, password, telephoneNumber);
        this.position=position;
        this.salary=salary;
    }

    public void setPosition(StaffPositionEnum position) {
        this.position = position;
    }

    public StaffPositionEnum getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
