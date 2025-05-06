package repository;

import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.function.Function;

abstract class BaseRepository<Model, CreateModelDto, UpdateModelDto> {
    protected Connection connection;
    private String tableName;

    public BaseRepository(String tableName) throws SQLException {
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

    protected <T> T findByCredentials(String query, String username, String password, Function<ResultSet,T> mapper){
        try{
            PreparedStatement ptsm = this.connection.prepareStatement(query);
            ptsm.setString(1,username);
            ptsm.setString(2,password);
            ResultSet rs = ptsm.executeQuery();
            if (rs.next()){
                return mapper.apply(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // metoda getById
    public Model getById (int id) {
        String query = "SELECT * FROM " + this.tableName + " WHERE id = ?";
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                return this.fromResultSet(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // metoda delete
  public  boolean delete(int id) {
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


