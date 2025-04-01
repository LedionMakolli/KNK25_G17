package repository;

import database.DBConnection;
import models.Dto.*;
import models.*;

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

//1. Metoda getALL
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
//2. Metoda getById
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
//3. Metoda create

    public Rezervimet create(CreateRezervimetDto rezervimetDto){
    String query = """
            INSERT INTO Rezervimet (id_klienti, id_vetura, data_fillimit, data_mbarimit, statusi_rezervimet)
            VALUES (?,?,?,?,?)""";
    try{
        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, rezervimetDto.getId_klienti());
        pstm.setInt(2, rezervimetDto.getId_vetura());
        pstm.setDate(3, rezervimetDto.getData_fillimit());
        pstm.setDate(4, rezervimetDto.getData_mbarimit());
        pstm.setObject(5, rezervimetDto.getStatusi(), Types.OTHER);
        pstm.execute();

        ResultSet rs = pstm.getGeneratedKeys();
        if(rs.next()){
            int id = rs.getInt(1);
            return this.getById(id);
        }
    }catch(SQLException e){
      e.printStackTrace();
    }
    return null;
 }
 //4. Metoda update
public int getIdVeturaByModeli(String modeli){
    String query = "SELECT ID_Vetura FROM VETURA WHERE Modeli=?";
   PreparedStatement preparedStatement = null;
   ResultSet resultSet = null;
    try{
preparedStatement = connection.prepareStatement(query);
preparedStatement.setString(1, modeli);
resultSet = preparedStatement.executeQuery();
if(resultSet.next()){
    return resultSet.getInt("ID_Vetura");
}
    }catch(SQLException e){
        e.printStackTrace();
    }
    return -1;
}











 //5. Metoda delete
public boolean delete(int id_rezervimet){
    String query = "DELETE FROM REZERVIMET WHERE id_rezervimet=?";
    try{
         PreparedStatement pstm = connection.prepareStatement(query);
         pstm.setInt(1, id_rezervimet);
         return pstm.executeUpdate()==1;
     }catch(SQLException e){
         e.printStackTrace();
     }
     return false;
 }
}