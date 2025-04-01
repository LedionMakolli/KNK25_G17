package repository;

import database.DBConnection;
import models.Sigurimi;
import models.Veturat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SigurimiRepository {
    public class VeturatRepository {
        private Connection connection;

        public VeturatRepository() throws SQLException {
            this.connection = DBConnection.getConnection();
            if (connection.isValid(1000)) {
                System.out.println("DB Connected");
            }
        }
    }
    public ArrayList<Sigurimi> getAll() {
        ArrayList<Sigurimi> veturat=new ArrayList<>();
        String query="SELECT * FROM SIGURIMI";
        try {
            Statement statement=this.connection.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next()) {
                veturat.add(Sigurimi.getInstance(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veturat;
    }
}
