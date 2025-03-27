package testim;

import database.DBConnection;

import java.sql.*;

public class test {
    public static void main(String[] args) {

        try{
            Connection conn = DBConnection.getConnection();
            if (conn.isValid(1000)){
                System.out.println("DB connected");
            }
            Statement stm = conn.createStatement();

            stm.execute("INSERT INTO users(name, email, age) VALUES ('Filan Fisteku', 'FFF@gmail.com', 27);");

            ResultSet resultSet = stm.executeQuery("SELECT * FROM users");

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String emri = resultSet.getString("name");
                String email = resultSet.getString ("email");
                int age = resultSet.getInt("age");

                System.out.println("ID: " + id + "\n" + "Emri: " + "\n" + emri + "Email: " + "\n" + email + "Age: " + age);
                System.out.println("----------------------");
            }
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
