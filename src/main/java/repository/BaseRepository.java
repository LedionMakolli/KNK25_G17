package repository;

import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;

abstract class BaseRepository<Model, CreateModelDto, UpdateModelDto> {
    protected Connection connection;
    private String tableName;

    public BaseRepository(String tableName) {
        this.connection = DBConnection.getConnection();
        this.tableName = tableName;
    }
    abstract Model fromResultSet(ResultSet rs);

    // metoda getAll
    public ArrayList<Model> getAll(){
        ArrayList<Model> models = new ArrayList<>();
        String query = "SELECT * FROM " + this.tableName;
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                models.add(this.fromResultSet(rs));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return models;
    }

    // metoda getById
    Model getById (int id) {
        String query = "SELECT * FROM " + this.tableName + " WHERE id = ?";
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                return this.fromResultSet(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // metoda delete
    boolean delete(int id) {
        String query = "DELETE FROM " + this.tableName + " WHERE id = ?";
        try{
            PreparedStatement pstm = this.connection.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}

