package repository;

import database.DBConnection;
import models.*;
import models.Dto.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VeturatRepository {
    private Connection connection;

    public VeturatRepository() {
        this.connection= DBConnection.getConnection();
    }
    // 1. metoda getAll
    public ArrayList<Veturat> getAll() {
        ArrayList<Veturat> veturat=new ArrayList<>();
        String query="SELECT * FROM VETURAT";
        try {
            Statement statement=this.connection.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next()) {
                veturat.add()
            }
        }
    }
}
