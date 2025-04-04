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



}

