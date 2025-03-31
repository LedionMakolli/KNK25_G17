package repository;

import database.DBConnection;
import models.Rezervimet;

import java.sql.*;
import java.util.ArrayList;

public class RezervimetRepository {
private Connection connection;

public RezervimetRepository() throws SQLException{
    this.connection= DBConnection.getConnection();
    if(connection.isValid(1000)){
        System.out.println("DB is connected");
    }
}

//1. Metoda getALL()
public ArrayList<Rezervimet> getAll() {
    ArrayList<Rezervimet> rezervimet = new ArrayList<>();
    String query = "SELCET * FROM Rezervimet";
    try {
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            rezervimet.add(Rezervimet.getInstance(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return rezervimet;
}
//2. Metoda getById()
    public Rezervimet getById(int id_rezervimet){
    String query ="SELECT * FROM Rezervimet where id_rezervimet=?";
    try{
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id_rezervimet);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return Rezervimet.getInstance(resultSet);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    return null;
}
}
