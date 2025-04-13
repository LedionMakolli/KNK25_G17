package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Clients extends User {

    private Clients(int id, String firstName, String lastName, int age, String personalNumber,
                    String email, String username, String password, String telephoneNumber) {
        super(id, firstName, lastName, age, personalNumber, email, username, password, telephoneNumber);
    }

    public static Clients getInstance(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstname");
        String lastName = resultSet.getString("lastname");
        int age=resultSet.getInt("age");
        String personalNumber=resultSet.getString("personalnumber");
        String email=resultSet.getString("email");
        String username=resultSet.getString("username");
        String password=resultSet.getString("password");
        String telephonenumber = resultSet.getString("telephonenumber");
        return new Clients(id, firstName, lastName, age, personalNumber, username, email, password, telephonenumber);
    }
    public void printClientData() {
        System.out.println("Client is Found:");
        System.out.println("ID: " + getId());
        System.out.println("First Name: "+ getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Personal Number: " + getPersonalNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Username: " + getUsername());
        // password ?
        System.out.println("Telephone Number: " + getTelephoneNumber());
        System.out.println("------------------------------");
    }
}
