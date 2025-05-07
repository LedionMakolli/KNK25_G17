package models;

import models.enums.StaffPositionEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Staff extends User {
    private StaffPositionEnum position;
    private LocalDate employmentDate;
    private double salary;

    private Staff(int id, String firstName, String lastName, int age, String personalNumber, String email, String username,
                  String password, String saltedHash, String telephoneNumber, StaffPositionEnum position, LocalDate employmentDate, double salary) {
        super(id, firstName, lastName, age, personalNumber, email, username, password, saltedHash, telephoneNumber);
        this.position = position;
        this.employmentDate = employmentDate;
        this.salary=salary;
    }

    public static Staff getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstname");
        String lastName = resultSet.getString("lastname");
        int age = resultSet.getInt("age");
        String personalNumber=resultSet.getString("personalnumber");
        String email = resultSet.getString("email");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String saltedHash=resultSet.getString("saltedhash");
        String telephoneNumber = resultSet.getString("telephonenumber");
        String positionString = resultSet.getString("position");
        StaffPositionEnum position = StaffPositionEnum.valueOf(positionString);
        LocalDate employmentDate = resultSet.getDate("employmentDate").toLocalDate();
        double salary=resultSet.getDouble("salary");
        return new Staff(id, firstName, lastName, age, personalNumber, email, username, password, saltedHash, telephoneNumber, position, employmentDate,salary);
    }

    public StaffPositionEnum getPosition() {
        return position;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public void printStaffDetails() {
        System.out.println("Staff member found:");
        System.out.println("ID: " + getId());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone Number: " + getTelephoneNumber());
        System.out.println("Position: " + getPosition());
        System.out.println("Employment Date: " + getEmploymentDate());
        System.out.println("Salary: " + getSalary());
        System.out.println("------------------------------");
    }
}
