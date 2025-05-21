package services;

import database.DBConnection;
import models.Insurance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceService {

    private final Connection connection;

    public InsuranceService() {
        connection = DBConnection.getConnection();
    }

    public List<Insurance> getAllInsurances() {
        List<Insurance> list = new ArrayList<>();
        String sql = "SELECT * FROM Insurance";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Insurance insurance = Insurance.getInstance(rs);
                list.add(insurance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
