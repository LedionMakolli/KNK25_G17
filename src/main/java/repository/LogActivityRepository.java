package repository;

import database.DBConnection;
import models.Dto.CreateLogActivityDto;
import models.LogActivity;
import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class LogActivityRepository {
    private Connection connection;

    public LogActivityRepository() throws SQLException {
        this.connection= DBConnection.getConnection();
    }

    //metoda getAll
    public ArrayList<LogActivity> getAll(){
        ArrayList<LogActivity> logActivity = new ArrayList<>();
        String query = "SELECT * FROM LOGACTIVITY";
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                logActivity.add(LogActivity.getInstance(rs));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return logActivity;
    }

    //metoda getById
    public LogActivity getById (int id) {
        String query = "SELECT * FROM LOGACTIVITY WHERE id = ?";
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                return LogActivity.getInstance(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // metoda create
    public LogActivity create(CreateLogActivityDto logActivityDto) {
        String query = "INSERT INTO LogActivity (idUser, userType, action, date) VALUES (?, ?, ?, CURRENT_DATE)";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, logActivityDto.getIdUser());
            pstm.setString(2, logActivityDto.getUserType());
            pstm.setObject(3, "Log In");

            pstm.execute();

            ResultSet resultSet = pstm.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                return this.getById(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    // metoda delete
    public  boolean delete(int id) {
        String query = "DELETE FROM LOGACTIVITY WHERE id = ?";
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