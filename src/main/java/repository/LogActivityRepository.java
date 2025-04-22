package repository;

import database.DBConnection;
import models.Dto.CreateLogActivityDto;
import models.LogActivity;

import java.sql.*;
import java.util.ArrayList;

public class LogActivityRepository {
    private Connection connection;

    public LogActivityRepository() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    // Metoda getAll
    public ArrayList<LogActivity> getAll() {
        ArrayList<LogActivity> logActivities = new ArrayList<>();
        String query = "SELECT * FROM LOGACTIVITY";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                logActivities.add(LogActivity.fromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logActivities;
    }

    // Metoda getById
    public LogActivity getById(int id) {
        String query = "SELECT * FROM LOGACTIVITY WHERE id = ?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return LogActivity.fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Metoda create
    public LogActivity create(CreateLogActivityDto logActivityDto) {
        String query = "INSERT INTO LogActivity (clientUsername, staffUsername, action, date) VALUES (?, ?, ?, CURRENT_DATE)";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setObject(1, logActivityDto.getClientUsername());
            pstm.setObject(2, logActivityDto.getStaffUsername());
            pstm.setString(3, logActivityDto.getAction());

            pstm.executeUpdate();

            ResultSet resultSet = pstm.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                return getById(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Metoda delete
    public boolean delete(int id) {
        String query = "DELETE FROM LOGACTIVITY WHERE id = ?";
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
